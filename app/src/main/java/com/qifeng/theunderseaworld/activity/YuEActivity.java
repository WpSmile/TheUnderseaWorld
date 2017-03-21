package com.qifeng.theunderseaworld.activity;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import com.qifeng.theunderseaworld.R;
import com.qifeng.theunderseaworld.utils.CommonUtils;
import com.qifeng.theunderseaworld.utils.MFGT;
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
        setContentView(R.layout.activity_yu_e);
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
