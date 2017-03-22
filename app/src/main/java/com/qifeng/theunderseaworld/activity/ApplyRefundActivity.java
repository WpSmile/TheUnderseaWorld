package com.qifeng.theunderseaworld.activity;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

import com.qifeng.theunderseaworld.R;
import com.qifeng.theunderseaworld.utils.CommonUtils;
import com.qifeng.theunderseaworld.utils.MFGT;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

/*申请退款*/
public class ApplyRefundActivity extends AppCompatActivity {
    private final static String TAG = ApplyRefundActivity.class.getCanonicalName();

    ApplyRefundActivity mContext;

    @BindView(R.id.apply_refund_et_price_num)
    EditText applyRefundEtPriceNum;
    @BindView(R.id.apply_refund_tv_expand)
    TextView applyRefundTvExpand;
    @BindView(R.id.apply_refund_et)
    EditText applyRefundEt;
    @BindView(R.id.apply_refund_tv_num)
    TextView applyRefundTvNum;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_apply_refund);
        ButterKnife.bind(this);
        mContext = this;
    }

    @OnClick({R.id.apply_refund_img_back, R.id.apply_refund_tv_only_tuikuan, R.id.apply_refund_tv_tuihuo, R.id.apply_refund_btn_send})
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.apply_refund_img_back:
                MFGT.finish(this);
                break;
            case R.id.apply_refund_tv_only_tuikuan:
                break;
            case R.id.apply_refund_tv_tuihuo:
                break;
            case R.id.apply_refund_btn_send:
                CommonUtils.showShortToast("已提交");
                break;
        }
    }
}
