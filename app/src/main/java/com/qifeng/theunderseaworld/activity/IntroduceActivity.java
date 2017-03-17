package com.qifeng.theunderseaworld.activity;

import android.graphics.Color;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.text.Spannable;
import android.text.SpannableStringBuilder;
import android.text.Spanned;
import android.text.style.ForegroundColorSpan;
import android.text.style.RelativeSizeSpan;
import android.view.View;
import android.widget.TextView;

import com.qifeng.theunderseaworld.R;
import com.qifeng.theunderseaworld.utils.L;
import com.qifeng.theunderseaworld.utils.MFGT;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class IntroduceActivity extends AppCompatActivity {
    private static final String TAG = IntroduceActivity.class.getCanonicalName();


    //TextView phoneRegisterTxtTitle;
    //TextView textIntroduce;
    @BindView(R.id.phone_register_txtTitle)
    TextView phoneRegisterTxtTitle;
    @BindView(R.id.text_introduce)
    TextView textIntroduce;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_introduce);
        ButterKnife.bind(this);
        initView();
    }

    private void initView() {
        //设置介绍的textView前面6个字的大小和属性
        String str = textIntroduce.getText().toString();
        L.e(TAG, str);
        int fstart = str.indexOf("南宁海底世界");
        int fend = fstart + "南宁海底世界".length();
        RelativeSizeSpan sizeSpan = new RelativeSizeSpan(1.5f);
        SpannableStringBuilder style = new SpannableStringBuilder(str);
        style.setSpan(new ForegroundColorSpan(Color.BLUE), fstart, fend, Spannable.SPAN_EXCLUSIVE_INCLUSIVE);
        style.setSpan(sizeSpan,fstart,fend,Spanned.SPAN_EXCLUSIVE_INCLUSIVE);
        textIntroduce.setText(style);
        //设置标题格式
        phoneRegisterTxtTitle.setText("海底世界简介");
    }

    @OnClick(R.id.phone_register_img_back)
    public void onClick() {
        //MFGT.finish(this);
        finish();
        L.e(TAG,"完了");
    }
}
