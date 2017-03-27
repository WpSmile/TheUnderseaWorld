package com.qifeng.theunderseaworld.fragment;


import android.app.ProgressDialog;
import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.text.InputType;
import android.text.TextUtils;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.EditText;
import android.widget.Toast;

import com.qifeng.theunderseaworld.I;
import com.qifeng.theunderseaworld.R;
import com.qifeng.theunderseaworld.UnderseaWorldApplication;
import com.qifeng.theunderseaworld.activity.MainActivity;
import com.qifeng.theunderseaworld.bean.Result;
import com.qifeng.theunderseaworld.bean.User;
import com.qifeng.theunderseaworld.dao.SharePrefrenceUtils;
import com.qifeng.theunderseaworld.dao.UserDao;
import com.qifeng.theunderseaworld.net.NetDao;
import com.qifeng.theunderseaworld.utils.L;
import com.qifeng.theunderseaworld.utils.MFGT;
import com.qifeng.theunderseaworld.utils.OkHttpUtils;
import com.qifeng.theunderseaworld.utils.ResultUtils;
import com.qifeng.theunderseaworld.view.ImageViewPlus;
import com.tencent.connect.UserInfo;
import com.tencent.connect.common.Constants;
import com.tencent.tauth.IUiListener;
import com.tencent.tauth.Tencent;
import com.tencent.tauth.UiError;

import org.json.JSONException;
import org.json.JSONObject;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import butterknife.Unbinder;

/**
 * A simple {@link Fragment} subclass.
 */
public class PersonalUnloginFragment extends Fragment {


    MainActivity mContext;
    @BindView(R.id.imageViewPlus)
    ImageViewPlus imageViewPlus;
    @BindView(R.id.login_edit_name)
    EditText loginEditName;
    @BindView(R.id.login_edit_password)
    EditText loginEditPassword;
    @BindView(R.id.login_checkbox_eye)
    CheckBox loginCheckboxEye;
    Unbinder unbinder;

    String username, password;

    /*QQ分享功能所需属性*/

    private Tencent mTencent;
    private String APP_ID = "1106061374";
    private IUiListener loginListener;
    private String SCOPE = "all";
    private IUiListener userInfoListener;


    public PersonalUnloginFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.activity_login, container, false);
        unbinder = ButterKnife.bind(this, view);
        mContext = (MainActivity) getActivity();
        L.e(mContext.toString());

        setListener();
        return view;
    }

    private void setListener() {
        //密码可见的btn点击事件
        loginCheckboxEye.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if (!TextUtils.isEmpty(loginEditPassword.getText().toString().trim())) {//密码不为空
                    if (isChecked) {//如果是隐藏的就设置点击可见
                        loginEditPassword.setInputType(InputType.TYPE_TEXT_VARIATION_PASSWORD | InputType.TYPE_CLASS_TEXT);
                    } else {
                        loginEditPassword.setInputType(InputType.TYPE_TEXT_VARIATION_VISIBLE_PASSWORD);//设置密码不可见
                    }
                } else {//密码为空
                    Toast.makeText(mContext, R.string.login_password, Toast.LENGTH_SHORT).show();
                }
            }
        });
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        unbinder.unbind();
    }

    @OnClick({R.id.login_checkbox_eye, R.id.login_text_phone, R.id.login_text_forget, R.id.login_btn_own, R.id.login_btn_merchant,
            R.id.login_rl_weixin, R.id.login_rl_qq})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.login_text_phone://手机快速注册
                MFGT.gotoRegisterByPhoneActivity(mContext);
                break;
            case R.id.login_text_forget://忘记密码
                MFGT.gotoForgetPasswordActivity(mContext);
                break;
            case R.id.login_btn_own://个人登录btn
                checkInput();//检测登录的用户信息
                UnderseaWorldApplication.setUsersign("顾客");
                break;
            case R.id.login_btn_merchant://商家登录按钮
                checkInput();//检测登录的用户信息
                UnderseaWorldApplication.setUsersign("商家");
                break;
            case R.id.login_rl_weixin://第三方微信登录
                Toast.makeText(mContext, "暂未开通", Toast.LENGTH_SHORT).show();
                loginByWeixin();
                break;
            case R.id.login_rl_qq://第三方QQ登录
                //Toast.makeText(mContext, "暂未开通", Toast.LENGTH_SHORT).show();
                loginByQQ();
                break;
        }
    }

    private void loginByQQ() {
        initQQlogin();//初始化QQ登录分享所需资源
        mTencent.login(this, SCOPE, loginListener);
    }

    private void initQQlogin() {
        mTencent = Tencent.createInstance(APP_ID, mContext);
        //创建QQ登录回调接口
        loginListener = new IUiListener() {
            @Override
            public void onComplete(Object o) {
                //登录成功后调用的方法
                JSONObject jo = (JSONObject) o;
                Toast.makeText(mContext, "登录成功", Toast.LENGTH_SHORT).show();
                Log.e("COMPLETE:", jo.toString());
                String openID;
                try {
                    openID = jo.getString("openid");
                    String accessToken = jo.getString("access_token");
                    String expires = jo.getString("expires_in");
                    mTencent.setOpenId(openID);
                    mTencent.setAccessToken(accessToken, expires);
                } catch (JSONException e) {
                    e.printStackTrace();
                }
            }

            @Override
            public void onError(UiError uiError) {
                //登录失败后回调该方法
                Toast.makeText(mContext, "登录失败", Toast.LENGTH_SHORT).show();
                Log.e("LoginError:", uiError.toString());
            }

            @Override
            public void onCancel() {
                //取消登录后回调该方法
                Toast.makeText(mContext, "取消登录", Toast.LENGTH_SHORT).show();
            }
        };

        userInfoListener = new IUiListener() {
            @Override
            public void onComplete(Object o) {
                if(o == null){
                    return;
                }
                try {
                    JSONObject jo = (JSONObject) o;
                    Log.e("JO:",jo.toString());
                    int ret = jo.getInt("ret");
                    String nickName = jo.getString("nickname");
                    String gender = jo.getString("gender");
                    Toast.makeText(mContext, "你好，" + nickName,Toast.LENGTH_LONG).show();

                } catch (Exception e) {
                }
            }
            @Override
            public void onError(UiError uiError) {
            }
            @Override
            public void onCancel() {
            }
        };
    }

    @Override
    public void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

        if (requestCode == Constants.REQUEST_LOGIN) {
            if (resultCode == -1) {
                Tencent.onActivityResultData(requestCode, resultCode, data, loginListener);
                Tencent.handleResultData(data, loginListener);
                UserInfo info = new UserInfo(mContext, mTencent.getQQToken());
                info.getUserInfo(userInfoListener);
            }
        }
    }

    private void loginByWeixin() {

    }

    private void checkInput() {
        //获取输入的账号和密码
        username = loginEditName.getText().toString().trim();
        password = loginEditPassword.getText().toString().trim();
        if (TextUtils.isEmpty(username)) {//用户名为空
            Toast.makeText(mContext, R.string.user_name_cannot_be_empty, Toast.LENGTH_SHORT).show();
            loginEditName.requestFocus();
            return;
        } else if (TextUtils.isEmpty(password)) {//密码为空
            Toast.makeText(mContext, R.string.password_cannot_be_empty, Toast.LENGTH_SHORT).show();
            loginEditPassword.requestFocus();
            return;
        }
        login();
    }

    private void login() {
        final ProgressDialog pd = new ProgressDialog(mContext);
        pd.setMessage(getResources().getString(R.string.logining));
        pd.show();
        //登录请求
        OkHttpUtils<Result> utils = new OkHttpUtils<>(mContext);
        utils.url(I.SERVER_URL+"Login"+I.INDEX)
                .addParam("mobile",username)
                .addParam("password",password)
                .post()
                .targetClass(Result.class)
                .execute(new OkHttpUtils.OnCompleteListener<Result>() {
                    @Override
                    public void onSuccess(Result result) {
                        if (result.getRetData()==null){
                            Toast.makeText(mContext, R.string.login_fail, Toast.LENGTH_SHORT).show();
                        }else {
                            if (result.isRetMsg()){
                                //Result resultFromJson = ResultUtils.getResultFromJson(result.getRetData().toString(), User.class);
                                User user = (User) result.getRetData();
                                L.e("user="+user);
                                UserDao dao = new UserDao(mContext);
                                boolean isSuccess = dao.saveUser(user);
                                if (isSuccess){
                                    //保存登录的用户信息
                                    SharePrefrenceUtils.getInstance(mContext).saveUser(user.getMuserName());
                                    UnderseaWorldApplication.setUser(user);


                                    Toast.makeText(mContext, "hahahaha==========登录成功了！！！！！！", Toast.LENGTH_SHORT).show();
                                }else {
                                    Toast.makeText(mContext, R.string.user_database_error, Toast.LENGTH_SHORT).show();
                                }

                            }
                        }
                        pd.dismiss();
                    }

                    @Override
                    public void onError(String error) {
                        Toast.makeText(mContext,error, Toast.LENGTH_SHORT).show();
                        L.e("error="+error);
                    }
                });
    }
}
