package com.qifeng.theunderseaworld.activity;


import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

import com.qifeng.theunderseaworld.R;
import com.qifeng.theunderseaworld.utils.MFGT;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class LoginActivity extends AppCompatActivity {

    @BindView(R.id.login_edit_name)
    EditText loginEditName;
    @BindView(R.id.login_edit_password)
    EditText loginEditPassword;
    LoginActivity mContext;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        ButterKnife.bind(this);
        mContext = this;
    }

    @OnClick({R.id.login_image_eye, R.id.login_text_phone, R.id.login_text_forget, R.id.login_btn_own, R.id.login_btn_merchant, R.id.login_rl_weixin, R.id.login_rl_qq})
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.login_image_eye:
                break;
            case R.id.login_text_phone:
                MFGT.gotoRegisterByPhoneActivity(mContext);
                MFGT.finish(mContext);
                break;
            case R.id.login_text_forget:
                break;
            case R.id.login_btn_own:
                break;
            case R.id.login_btn_merchant:
                break;
            case R.id.login_rl_weixin:
                break;
            case R.id.login_rl_qq:
                break;
        }
    }
}
