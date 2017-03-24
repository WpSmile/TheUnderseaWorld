package com.qifeng.theunderseaworld.activity;

import android.os.Build;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import com.qifeng.theunderseaworld.R;
import com.qifeng.theunderseaworld.utils.MFGT;
import com.qifeng.theunderseaworld.utils.StatusBarCompat;
import com.qifeng.theunderseaworld.view.ImageViewPlus;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class PaySystemBusinessActivity extends AppCompatActivity {
    private final static String TAG = PaySystemBusinessActivity.class.getCanonicalName();

    PaySystemBusinessActivity mContext;

    @BindView(R.id.pay_system_btn_mingxi)
    Button paySystemBtnMingxi;
    @BindView(R.id.pay_system_imageViewPlus)
    ImageViewPlus paySystemImageViewPlus;
    @BindView(R.id.pay_system_tv_price)
    TextView paySystemTvPrice;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //API19以下用于沉侵式菜单栏
        if (Build.VERSION.SDK_INT <= Build.VERSION_CODES.KITKAT) {
            getWindow().addFlags(WindowManager.LayoutParams.FLAG_TRANSLUCENT_STATUS);
            getWindow().addFlags(WindowManager.LayoutParams.FLAG_TRANSLUCENT_NAVIGATION);
        }
        setContentView(R.layout.activity_pay_system);
        //API20以上
        if (Build.VERSION.SDK_INT>Build.VERSION_CODES.KITKAT){
            //沉侵
            StatusBarCompat.compat(this,getResources().getColor(R.color.bottom_blue));
        }
        ButterKnife.bind(this);

        mContext = this;
        initView();
    }

    private void initView() {
        //paySystemBtnMingxi.setVisibility(View.GONE);//设置明细按钮的隐藏
    }

    @OnClick({R.id.pay_system_img_back, R.id.pay_system_btn_mingxi, R.id.pay_system_btn_zhifu, R.id.pay_system_btn_chongzhi, R.id.pay_system_btn_tixian, R.id.weixin_pay_rl, R.id.zhifubao_pay_rl, R.id.yinlian_pay_rl})
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.pay_system_img_back:
                MFGT.finish(mContext);
                break;
            case R.id.pay_system_btn_mingxi://标题上的明细按钮

                break;
            case R.id.pay_system_btn_zhifu://支付
                Toast.makeText(mContext, "暂未开通", Toast.LENGTH_SHORT).show();
                break;
            case R.id.pay_system_btn_chongzhi://充值
                Toast.makeText(mContext, "暂未开通", Toast.LENGTH_SHORT).show();
                break;
            case R.id.pay_system_btn_tixian://提现
                Toast.makeText(mContext, "暂未开通", Toast.LENGTH_SHORT).show();
                break;
            case R.id.weixin_pay_rl://微信的支付方式
                Toast.makeText(mContext, "暂未开通", Toast.LENGTH_SHORT).show();
                break;
            case R.id.zhifubao_pay_rl://支付宝的支付方式
                Toast.makeText(mContext, "暂未开通", Toast.LENGTH_SHORT).show();
                break;
            case R.id.yinlian_pay_rl://银联支付
                Toast.makeText(mContext, "暂未开通", Toast.LENGTH_SHORT).show();
                break;
        }
    }
}
