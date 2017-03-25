package com.qifeng.theunderseaworld.activity;

import android.content.IntentFilter;
import android.os.Build;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.text.TextUtils;
import android.view.View;
import android.view.WindowManager;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.qifeng.theunderseaworld.R;
import com.qifeng.theunderseaworld.receiver.MessageReceiver;
import com.qifeng.theunderseaworld.utils.CountDownTimerUtils;
import com.qifeng.theunderseaworld.utils.MFGT;
import com.qifeng.theunderseaworld.utils.StatusBarCompat;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import cn.smssdk.EventHandler;
import cn.smssdk.SMSSDK;

public class ForgetPasswordActivity extends AppCompatActivity implements MessageReceiver.ISMSListener {

    ForgetPasswordActivity mContext;

    @BindView(R.id.phone_register_txtTitle)
    TextView phoneRegisterTxtTitle;
    @BindView(R.id.forget_edt_phonenumber)
    EditText forgetEdtPhonenumber;
    @BindView(R.id.forget_edt_sms)
    EditText forgetEdtSms;
    @BindView(R.id.forget_edt_new_password)
    EditText forgetEdtNewPassword;
    @BindView(R.id.forget_password_text_send)
    TextView forgetPasswordTextSend;


    private String phoneNumber;
    private String code;

    private MessageReceiver messageReceiver;

    private CountDownTimerUtils countDownTimerUtils;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //API19以下用于沉侵式菜单栏
        if (Build.VERSION.SDK_INT <= Build.VERSION_CODES.KITKAT) {
            getWindow().addFlags(WindowManager.LayoutParams.FLAG_TRANSLUCENT_STATUS);
            getWindow().addFlags(WindowManager.LayoutParams.FLAG_TRANSLUCENT_NAVIGATION);
        }

        SMSSDK.initSDK(this, "1c6c318dfff7c", "6b094594aac349176a9dffca6c26325c");
        setContentView(R.layout.activity_forget_password);
        //API20以上
        if (Build.VERSION.SDK_INT > Build.VERSION_CODES.KITKAT) {
            //沉侵
            StatusBarCompat.compat(this, getResources().getColor(R.color.bottom_blue));
        }
        ButterKnife.bind(this);

        mContext = this;

        initView();

        messageReceiver = new MessageReceiver();
        IntentFilter filter = new IntentFilter("android.provider.Telephony.SMS_RECEIVED");
        filter.setPriority(1000);
        registerReceiver(messageReceiver, filter);
    }

    private void initView() {
        phoneRegisterTxtTitle.setText("忘记密码");
    }

    @OnClick({R.id.phone_register_img_back, R.id.forget_password_text_send, R.id.forget_password_btn_sure, R.id.yi_you_zhang_hao_login})
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.phone_register_img_back:
                MFGT.finish(this);
                break;
            case R.id.forget_password_text_send://发送验证码
                regist();//调用了注册短信发送的回调接口

                //传入计时时间
                countDownTimerUtils = new CountDownTimerUtils(60000, 1000, forgetPasswordTextSend);
                countDownTimerUtils
                        .start();

                phoneNumber = forgetEdtPhonenumber.getText().toString().trim();
                if (TextUtils.isEmpty(phoneNumber) || phoneNumber.length() < 11)//判断字符串是null或者是“”或者是否少于11位
                {
                    Toast.makeText(getApplicationContext(), "请输入合法的手机号", Toast.LENGTH_LONG).show();
                } else {
                    SMSSDK.getVerificationCode("86", phoneNumber);
                }
                break;
            case R.id.forget_password_btn_sure://确认按钮
                checkInput();//输入手机、验证码、密码的逻辑判断方法
                break;
            case R.id.yi_you_zhang_hao_login:
                MFGT.finish(this);
                break;
        }
    }


    private void checkInput() {
        phoneNumber = forgetEdtPhonenumber.getText().toString().trim();
        code = forgetEdtSms.getText().toString().trim();
        if (TextUtils.isEmpty(phoneNumber) && TextUtils.isEmpty(code)) {//如果密码（验证码）为空
            Toast.makeText(getApplicationContext(), "请检验您输入的信息", Toast.LENGTH_LONG).show();
        } else if (TextUtils.isEmpty(forgetEdtNewPassword.getText().toString().trim())) {
            Toast.makeText(this, "密码不能为空", Toast.LENGTH_SHORT).show();
        } else {
            SMSSDK.submitVerificationCode("86", phoneNumber, code);
        }

        MFGT.finish(mContext);

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
    public void onSmsReceive(String code) {
        forgetEdtSms.setText(code);
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        unregisterReceiver(messageReceiver);
    }
}
