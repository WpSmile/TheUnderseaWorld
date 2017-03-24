package com.qifeng.theunderseaworld.activity;

import android.os.Build;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.view.WindowManager;
import android.widget.TextView;

import com.qifeng.theunderseaworld.R;
import com.qifeng.theunderseaworld.utils.MFGT;
import com.qifeng.theunderseaworld.utils.StatusBarCompat;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class ForgetPasswordActivity extends AppCompatActivity {

    @BindView(R.id.phone_register_txtTitle)
    TextView phoneRegisterTxtTitle;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //API19以下用于沉侵式菜单栏
        if (Build.VERSION.SDK_INT <= Build.VERSION_CODES.KITKAT) {
            getWindow().addFlags(WindowManager.LayoutParams.FLAG_TRANSLUCENT_STATUS);
            getWindow().addFlags(WindowManager.LayoutParams.FLAG_TRANSLUCENT_NAVIGATION);
        }
        setContentView(R.layout.activity_forget_password);
        //API20以上
        if (Build.VERSION.SDK_INT>Build.VERSION_CODES.KITKAT){
            //沉侵
            StatusBarCompat.compat(this,getResources().getColor(R.color.bottom_blue));
        }
        ButterKnife.bind(this);
    }

    @OnClick({R.id.phone_register_img_back, R.id.forget_password_text_send, R.id.forget_password_btn_sure, R.id.yi_you_zhang_hao_login})
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.phone_register_img_back:
                MFGT.finish(this);
                break;
            case R.id.forget_password_text_send:
                break;
            case R.id.forget_password_btn_sure:
                break;
            case R.id.yi_you_zhang_hao_login:
                MFGT.finish(this);
                break;
        }
    }
}
