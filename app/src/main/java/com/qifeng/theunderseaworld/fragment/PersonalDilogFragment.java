package com.qifeng.theunderseaworld.fragment;

import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.DialogFragment;
import android.util.DisplayMetrics;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.widget.TextView;

import com.qifeng.theunderseaworld.R;


/**
 * 更换头像对话框
 * Created by XinAiXiaoWen on 2017/3/21.
 */

public class PersonalDilogFragment extends DialogFragment implements View.OnClickListener{

    //输出日志
    private String TAG = PersonalDilogFragment.class.getSimpleName();

    //组件
    private View personalDialog = null;

    //本地相册
    private TextView tvSeabedHeadLocal = null;

    //拍照上传
    private TextView tvSeabedHeadTake = null;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        getDialog().requestWindowFeature(Window.FEATURE_NO_TITLE);
        Window window = getDialog().getWindow();
        window.setGravity(Gravity.CENTER);
        personalDialog = inflater.inflate(R.layout.personal_dilog_head, null);
        window.setBackgroundDrawable(new ColorDrawable(Color.TRANSPARENT));

        //初始化前
        initPersonalDilogAgo();

        //初始化控件
        initPersonalDilogView();

        //注册监听器
        initPersonalDilogListener();

        //初始化后
        initPersonalDilogBack();

        return personalDialog;
    }

    /**
     * 初始化前
     */
    private void initPersonalDilogAgo(){

    }

    /**
     * 初始化控件
     */
    private void initPersonalDilogView(){
        //本地相册
        tvSeabedHeadLocal = (TextView) personalDialog.findViewById(R.id.tv_seabed_head_local);
        //拍照上传
        tvSeabedHeadTake = (TextView) personalDialog.findViewById(R.id.tv_seabed_head_take);
    }

    /**
     * 注册监听
     */
    private void initPersonalDilogListener(){
        tvSeabedHeadLocal.setOnClickListener(this);
        tvSeabedHeadTake.setOnClickListener(this);
    }

    /**
     * 初始化后
     */
    private void initPersonalDilogBack(){

    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.tv_seabed_head_local:
                break;
            case R.id.tv_seabed_head_take:
                break;
        }
    }

    @Override
    public void onStart() {
        super.onStart();
        DisplayMetrics dm = new DisplayMetrics();
        getActivity().getWindowManager().getDefaultDisplay().getMetrics(dm);
        getDialog().getWindow().setLayout(dm.widthPixels, getDialog().getWindow().getAttributes().height);
    }
}
