package com.qifeng.theunderseaworld.fragment;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;

import com.qifeng.theunderseaworld.R;
import com.qifeng.theunderseaworld.activity.MainActivity;
import com.qifeng.theunderseaworld.utils.MFGT;
import com.qifeng.theunderseaworld.view.ImageViewPlus;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import butterknife.Unbinder;

/**
 * A simple {@link Fragment} subclass.
 */
public class PersonalUnloginFragment extends Fragment {


    //MainActivity mContext;
    @BindView(R.id.imageViewPlus)
    ImageViewPlus imageViewPlus;
    @BindView(R.id.login_edit_name)
    EditText loginEditName;
    @BindView(R.id.login_edit_password)
    EditText loginEditPassword;
    Unbinder unbinder;

    public PersonalUnloginFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.activity_login, container, false);
        unbinder = ButterKnife.bind(this, view);
        //mContext = (MainActivity) getActivity();
        return view;
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        unbinder.unbind();
    }

    @OnClick({R.id.login_image_eye, R.id.login_text_phone, R.id.login_text_forget, R.id.login_btn_own, R.id.login_btn_merchant, R.id.login_rl_weixin, R.id.login_rl_qq})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.login_image_eye://密码可见btn
                break;
            case R.id.login_text_phone://手机快速注册
                //MFGT.gotoRegisterByPhoneActivity(mContext);
                break;
            case R.id.login_text_forget://忘记密码
                break;
            case R.id.login_btn_own://个人登录btn
                break;
            case R.id.login_btn_merchant://商家登录按钮
                break;
            case R.id.login_rl_weixin://第三方微信登录
                break;
            case R.id.login_rl_qq://第三方QQ登录
                break;
        }
    }
}
