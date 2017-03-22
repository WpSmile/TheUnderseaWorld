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

/*回复页面*/
public class ReplyActivity extends AppCompatActivity {

    @BindView(R.id.reply_et)
    EditText replyEt;
    @BindView(R.id.reply_tv_num)
    TextView replyTvNum;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_reply);
        ButterKnife.bind(this);
    }

    @OnClick({R.id.reply_img_back, R.id.reply_btn_send})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.reply_img_back:
                MFGT.finish(this);
                break;
            case R.id.reply_btn_send:
                CommonUtils.showShortToast("恢复成功");
                break;
        }
    }
}
