package com.qifeng.theunderseaworld.activity;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.text.Spannable;
import android.text.SpannableStringBuilder;
import android.text.Spanned;
import android.text.style.ForegroundColorSpan;
import android.text.style.RelativeSizeSpan;
import android.widget.TextView;

import com.qifeng.theunderseaworld.R;
import com.qifeng.theunderseaworld.utils.L;
import com.qifeng.theunderseaworld.utils.MFGT;
import com.qifeng.theunderseaworld.view.FlowIndicator;
import com.qifeng.theunderseaworld.view.SlideAutoLoopView;

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
    @BindView(R.id.intro_flowIndicator)
    FlowIndicator introFlowIndicator;
    @BindView(R.id.intro_slideAuto)
    SlideAutoLoopView introSlideAuto;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_introduce);
        ButterKnife.bind(this);
        initView();
        initData();
    }

    private void initData() {
        String[] imageurl = {"http://ofrf20oms.bkt.clouddn.com/Clannad.jpg",
                "http://ofrf20oms.bkt.clouddn.com/THE%20IDOLM@STER.jpg",
                "http://ofrf20oms.bkt.clouddn.com/miku.jpg"};
        L.e(TAG,"=============开始图片轮播");
        //introSlideAuto.startPlayLoop(introFlowIndicator, imageurl, 3);
    }

    /*private int getAlbumImgCount(GoodsDetailsBean details) {
        if (details.getProperties() != null && details.getProperties().length > 0) {
            return details.getProperties()[0].getAlbums().length;
        }
        return 0;
    }*/

    /*private String[] getAlbumImgUrl(CartBean details) {
        String[] url = new String[]{};
        if (details.getProperties() != null && details.getProperties().length > 0) {
            AlbumsBean[] albums = details.getProperties()[0].getAlbums();
            url = new String[albums.length];
            for (int i = 0; i < albums.length; i++) {
                url[i] = albums[i].getImgUrl();
            }
        }
        return url;

    }*/


    private void initView() {
        //设置介绍的textView前面6个字的大小和属性
        String str = textIntroduce.getText().toString();
        L.e(TAG, str);
        int fstart = str.indexOf("南宁海底世界");
        int fend = fstart + "南宁海底世界".length();
        RelativeSizeSpan sizeSpan = new RelativeSizeSpan(1.3f);
        SpannableStringBuilder style = new SpannableStringBuilder(str);
        style.setSpan(new ForegroundColorSpan(getResources().getColor(R.color.bottom_blue)), fstart, fend, Spannable.SPAN_EXCLUSIVE_INCLUSIVE);
        style.setSpan(sizeSpan, fstart, fend, Spanned.SPAN_EXCLUSIVE_INCLUSIVE);
        textIntroduce.setText(style);
        //设置标题格式
        phoneRegisterTxtTitle.setText("海底世界简介");
    }

    @OnClick(R.id.phone_register_img_back)
    public void onClick() {
        MFGT.finish(this);
    }
}
