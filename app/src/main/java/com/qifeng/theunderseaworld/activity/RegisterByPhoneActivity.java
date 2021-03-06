package com.qifeng.theunderseaworld.activity;

import android.app.ProgressDialog;
import android.content.IntentFilter;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.text.TextUtils;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.qifeng.theunderseaworld.I;
import com.qifeng.theunderseaworld.R;
import com.qifeng.theunderseaworld.UnderseaWorldApplication;
import com.qifeng.theunderseaworld.bean.Result;
import com.qifeng.theunderseaworld.bean.User;
import com.qifeng.theunderseaworld.receiver.MessageReceiver;
import com.qifeng.theunderseaworld.utils.CountDownTimerUtils;
import com.qifeng.theunderseaworld.utils.HttpRequestWrap;
import com.qifeng.theunderseaworld.utils.L;
import com.qifeng.theunderseaworld.utils.MFGT;
import com.qifeng.theunderseaworld.utils.OkHttpUtils;
import com.qifeng.theunderseaworld.utils.OnResponseHandler;
import com.qifeng.theunderseaworld.utils.RequestHandler;
import com.qifeng.theunderseaworld.utils.RequestStatus;
import com.qifeng.theunderseaworld.utils.ResultUtils;

import java.util.HashMap;
import java.util.Map;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import cn.smssdk.EventHandler;
import cn.smssdk.SMSSDK;

public class RegisterByPhoneActivity extends AppCompatActivity {
    private final static String TAG = RegisterByPhoneActivity.class.getCanonicalName();

    @BindView(R.id.register_edt_input_phonenumber)
    EditText registerEdtInputPhonenumber;
    @BindView(R.id.register_edt_input_sms)
    EditText registerEdtInputSms;
    @BindView(R.id.register_edt_password)
    EditText registerEdtPassword;
    @BindView(R.id.phone_register_btn_send)
    TextView phoneRegisterBtnSend;

    private String phoneNumber;
    private String code;

    private MessageReceiver messageReceiver;

    private CountDownTimerUtils countDownTimerUtils;

    RegisterByPhoneActivity mContext;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        SMSSDK.initSDK(this, "1c6c318dfff7c", "6b094594aac349176a9dffca6c26325c");
        setContentView(R.layout.activity_register_by_phone);
        ButterKnife.bind(this);

        mContext = this;

    }

    @Override
    protected void onStart() {
        super.onStart();

        messageReceiver = new MessageReceiver();
        IntentFilter filter = new IntentFilter("android.provider.Telephony.SMS_RECEIVED");
        filter.setPriority(Integer.MAX_VALUE);
        //注册广播
        this.registerReceiver(messageReceiver, filter);
        messageReceiver.setOnReceivedMessageListener(new MessageReceiver.MessageListener() {
            @Override
            public void onReceived(String message) {
                registerEdtInputSms.setText(message);
            }
        });
    }

    @OnClick(R.id.phone_register_img_back)
    public void onClick() {
        MFGT.finish(this);
    }

    @OnClick({R.id.register_login_btn_own, R.id.register_login_btn_merchant, R.id.register_find_phone_area, R.id.phone_register_btn_send})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.register_login_btn_own://个人登录
                L.e(TAG, "============个人登录被点击");
                checkInput();//输入手机、验证码、密码的逻辑判断方法
                UnderseaWorldApplication.setUsersign("顾客");
                break;
            case R.id.register_login_btn_merchant://商家登录
                checkInput();
                UnderseaWorldApplication.setUsersign("商家");
                break;
            case R.id.register_find_phone_area://电话地区页面
                break;
            case R.id.phone_register_btn_send://发送验证码


                regist();//调用了注册短信发送的回调接口

                //传入计时时间
                countDownTimerUtils = new CountDownTimerUtils(60000, 1000, phoneRegisterBtnSend);
                countDownTimerUtils
                        .start();

                phoneNumber = registerEdtInputPhonenumber.getText().toString().trim();
                if (TextUtils.isEmpty(phoneNumber) || phoneNumber.length() != 11)//判断字符串是null或者是“”或者是否11位
                {
                    Toast.makeText(getApplicationContext(), "请输入合法的手机号", Toast.LENGTH_LONG).show();
                } else {
                    SMSSDK.getVerificationCode("86", phoneNumber);
                }
                break;
        }
    }

    private void checkInput() {
        L.e(TAG, "=============登录之前检查状态");
        phoneNumber = registerEdtInputPhonenumber.getText().toString().trim();
        code = registerEdtInputSms.getText().toString().trim();
        if (TextUtils.isEmpty(phoneNumber) && TextUtils.isEmpty(code)) {//如果密码（验证码）为空
            Toast.makeText(getApplicationContext(), "请检验您输入的信息", Toast.LENGTH_LONG).show();
        } else if (TextUtils.isEmpty(registerEdtPassword.getText().toString().trim())) {
            Toast.makeText(this, "密码不能为空", Toast.LENGTH_SHORT).show();
        } else {
            SMSSDK.submitVerificationCode("86", phoneNumber, code);

            //注册的方法
            registMethod();
        }


    }

    private void registMethod() {
        L.e(TAG, "===============登录的网络请求");
        final ProgressDialog pd = new ProgressDialog(this);
        pd.setMessage(getResources().getString(R.string.registering));
        pd.show();
        String username = registerEdtInputPhonenumber.getText().toString();
        String password = registerEdtPassword.getText().toString();

        HttpRequestWrap httpRequestWrap = null;
        httpRequestWrap = new HttpRequestWrap(mContext);
        httpRequestWrap.setMethod(HttpRequestWrap.POST);
        httpRequestWrap.setCallBack(new RequestHandler(mContext, new OnResponseHandler() {
            @Override
            public void onResponse(String s, RequestStatus status) {
                if (status == RequestStatus.SUCCESS) {
                    if (!s.isEmpty()) {
                        Log.e("tag", "registe============" + s);

                        JSONObject jsonObject = JSON.parseObject(s);
                        Log.e("tag", "jsonObject==============" + jsonObject.toString());
                        JSONObject result = jsonObject.getJSONObject("result");

                        String retData = result.getString("retData");

                        Boolean retMsg = result.getBoolean("retMsg");

                        if (retMsg) {
                            Toast.makeText(mContext, R.string.register_success, Toast.LENGTH_SHORT).show();
                            MFGT.finish(mContext);
                        } else {
                            Toast.makeText(mContext, R.string.register_fail_exists, Toast.LENGTH_SHORT).show();
                            registerEdtInputPhonenumber.requestFocus();
                            pd.dismiss();
                        }

                    }
                }
            }
        }));
        Map<String, Object> map = new HashMap<>();
        map.put("username", username);
        map.put("password", password);
        httpRequestWrap.send(I.SERVER_URL + "Registe" + I.INDEX, map);
    }


    public void regist() {
        //需要先定义一个接口回调
        EventHandler eh = new EventHandler() {
            @Override
            public void afterEvent(int event, int result, Object data) {


                if (result == SMSSDK.RESULT_COMPLETE) {
                    System.out.println("SMSSDK.RESULT_COMPLETE");
                    //回调完成
                    if (event == SMSSDK.EVENT_SUBMIT_VERIFICATION_CODE) {
                        runOnUiThread(new Runnable() {
                            @Override
                            public void run() {
                                Toast.makeText(getApplication(),
                                        "您已验证成功",
                                        Toast.LENGTH_SHORT)
                                        .show();
                            }
                        });
                        //提交验证码成功
                    } else if (event == SMSSDK.EVENT_GET_VERIFICATION_CODE) {
                        System.out.println("EVENT_GET_VERIFICATION_CODE");
                        System.out.println("发送了");
                        //如果收到了验证码就会走这
                        runOnUiThread(new Runnable() {
                            @Override
                            public void run() {
                                Toast.makeText(getApplication(),
                                        "已发送验证码，请注意查收",
                                        Toast.LENGTH_SHORT)
                                        .show();
                            }
                        });

                    } else if (event == SMSSDK.EVENT_GET_SUPPORTED_COUNTRIES) {
                        System.out.println("EVENT_GET_SUPPORTED_COUNTRIES");
                        //返回支持发送验证码的国家列表
                    }
                } else {
                    runOnUiThread(new Runnable() {
                        @Override
                        public void run() {
                            Toast.makeText(getApplication(),
                                    "操作失败，重新获取验证码",
                                    Toast.LENGTH_SHORT)
                                    .show();
                        }
                    });
                    ((Throwable) data).printStackTrace();
                }
            }
        };
        SMSSDK.registerEventHandler(eh); //注册短信回调
    }


    @Override
    protected void onDestroy() {
        super.onDestroy();
        this.unregisterReceiver(messageReceiver);
    }
}
