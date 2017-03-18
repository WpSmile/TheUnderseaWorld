package com.qifeng.theunderseaworld.activity;


import android.app.ProgressDialog;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.text.TextUtils;
import android.view.View;
import android.widget.EditText;

import com.qifeng.theunderseaworld.I;
import com.qifeng.theunderseaworld.R;
import com.qifeng.theunderseaworld.UnderseaWorldApplication;
import com.qifeng.theunderseaworld.bean.Result;
import com.qifeng.theunderseaworld.bean.User;
import com.qifeng.theunderseaworld.dao.SharePrefrenceUtils;
import com.qifeng.theunderseaworld.dao.UserDao;
import com.qifeng.theunderseaworld.net.NetDao;
import com.qifeng.theunderseaworld.utils.CommonUtils;
import com.qifeng.theunderseaworld.utils.L;
import com.qifeng.theunderseaworld.utils.MFGT;
import com.qifeng.theunderseaworld.utils.OkHttpUtils;
import com.qifeng.theunderseaworld.utils.ResultUtils;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class LoginActivity extends AppCompatActivity {

    @BindView(R.id.login_edit_name)
    EditText loginEditName;
    @BindView(R.id.login_edit_password)
    EditText loginEditPassword;
    LoginActivity mContext;
    String username,password;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        ButterKnife.bind(this);
        L.e("main",this.toString());
        mContext = this;
    }

    @OnClick({R.id.login_image_eye, R.id.login_text_phone, R.id.login_text_forget, R.id.login_btn_own, R.id.login_btn_merchant, R.id.login_rl_weixin, R.id.login_rl_qq})
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.login_image_eye://密码的可视按钮

                break;
            case R.id.login_text_phone:
                MFGT.gotoRegisterByPhoneActivity(mContext);
                MFGT.finish(mContext);
                break;
            case R.id.login_text_forget:
                Intent intent = new Intent();
                intent.setClass(this,ForgetPasswordActivity.class);
                startActivity(intent);
                break;
            case R.id.login_btn_own://个人登录
                checkInput();
                break;
            case R.id.login_btn_merchant://商家登录
                checkInput();
                break;
            case R.id.login_rl_weixin://微信登录

                break;
            case R.id.login_rl_qq://QQ登录

                break;
        }
    }

    private void checkInput() {
        username = loginEditName.getText().toString().trim();
        password = loginEditPassword.getText().toString().trim();
        if (TextUtils.isEmpty(username)){
            CommonUtils.showLongToast(R.string.user_name_cannot_be_empty);
            loginEditName.requestFocus();
            return;
        }else if (TextUtils.isEmpty(password)){
            CommonUtils.showLongToast(R.string.password_cannot_be_empty);
            loginEditPassword.requestFocus();
            return;
        }
        login();
    }

    private void login() {
        final ProgressDialog pd = new ProgressDialog(mContext);
        pd.setMessage(getResources().getString(R.string.logining));
        pd.show();
        NetDao.login(mContext, username, password, new OkHttpUtils.OnCompleteListener<String>() {
            @Override
            public void onSuccess(String s) {
                Result result = ResultUtils.getResultFromJson(s, User.class);
                L.e("result="+result);
                if (result==null){
                    CommonUtils.showLongToast(R.string.login_fail);
                }else {
                    if (result.isRetMsg()){
                        User user = (User) result.getRetData();
                        L.e("user="+user);
                        UserDao dao = new UserDao(mContext);
                        boolean isSuccess = dao.saveUser(user);
                        if (isSuccess){
                            SharePrefrenceUtils.getInstance(mContext).saveUser(user.getMuserName());
                            UnderseaWorldApplication.setUser(user);
                            MFGT.finish(mContext);
                            /*MFGT.gotoMainActivity(mContext,1);*/
                        }else {
                            CommonUtils.showLongToast(R.string.user_database_error);
                        }

                    }else {
                        if (result.getRetCode()== I.MSG_LOGIN_UNKNOW_USER){
                            CommonUtils.showLongToast(R.string.login_fail_unknow_user);
                        }else if (result.getRetCode()==I.MSG_LOGIN_ERROR_PASSWORD){
                            CommonUtils.showLongToast(R.string.login_fail_error_password);
                        }else {
                            CommonUtils.showLongToast(R.string.login_fail);
                        }
                    }
                }
                pd.dismiss();
            }

            @Override
            public void onError(String error) {
                CommonUtils.showLongToast(error);
                L.e("error="+error);
            }
        });
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (resultCode == RESULT_OK && requestCode == I.REQUEST_CODE_RESGITER) {
            String name = data.getStringExtra(I.User.USER_NAME);
            loginEditName.setText(name);
        }
    }
}
