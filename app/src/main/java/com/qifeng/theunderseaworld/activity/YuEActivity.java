package com.qifeng.theunderseaworld.activity;

import android.os.Build;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.view.WindowManager;
import android.widget.TextView;
import android.widget.Toast;

import com.qifeng.theunderseaworld.R;
import com.qifeng.theunderseaworld.utils.CommonUtils;
import com.qifeng.theunderseaworld.utils.MFGT;
import com.qifeng.theunderseaworld.utils.StatusBarCompat;
import com.qifeng.theunderseaworld.view.ImageViewPlus;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

/*余额管理页面*/
public class YuEActivity extends AppCompatActivity {
    private final static String TAG = YuEActivity.class.getCanonicalName();
    YuEActivity mContext;

    @BindView(R.id.yu_e_imageViewPlus)
    ImageViewPlus yuEImageViewPlus;
    @BindView(R.id.Yu_e_tv_price)
    TextView YuETvPrice;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //API19以下用于沉侵式菜单栏
        if (Build.VERSION.SDK_INT <= Build.VERSION_CODES.KITKAT) {
            getWindow().addFlags(WindowManager.LayoutParams.FLAG_TRANSLUCENT_STATUS);
            getWindow().addFlags(WindowManager.LayoutParams.FLAG_TRANSLUCENT_NAVIGATION);
        }
        setContentView(R.layout.activity_yu_e);
        //API20以上
        if (Build.VERSION.SDK_INT>Build.VERSION_CODES.KITKAT){
            //沉侵
            StatusBarCompat.compat(this,getResources().getColor(R.color.bottom_blue));
        }
        mContext = this;

        ButterKnife.bind(this);
    }

    @OnClick({R.id.phone_register_img_back, R.id.Yue_btn_chongzhi, R.id.Yue_btn_tixian})
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.phone_register_img_back:
                MFGT.finish(mContext);
                break;
            case R.id.Yue_btn_chongzhi://充值
                Toast.makeText(mContext, "未绑定银行卡！", Toast.LENGTH_SHORT).show();
                break;
            case R.id.Yue_btn_tixian://提现
                Toast.makeText(mContext, "未绑定银行卡！", Toast.LENGTH_SHORT).show();
                break;
        }
    }
}
