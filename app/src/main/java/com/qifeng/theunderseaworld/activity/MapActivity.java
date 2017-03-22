package com.qifeng.theunderseaworld.activity;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.MotionEvent;
import android.view.View;
import android.widget.ScrollView;
import android.widget.TextView;

import com.qifeng.theunderseaworld.R;
import com.qifeng.theunderseaworld.utils.MFGT;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class MapActivity extends AppCompatActivity {

    @BindView(R.id.phone_register_txtTitle)
    TextView phoneRegisterTxtTitle;
    @BindView(R.id.map_scrollView)
    ScrollView mapScrollView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_map);
        ButterKnife.bind(this);
        initView();
        setListener();
    }

    private void setListener() {
        mapScrollView.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View v, MotionEvent event) {
                switch (event.getAction()) {
                    //手指抬起
                    case MotionEvent.ACTION_UP:

                        break;

                    //手指落下
                    case MotionEvent.ACTION_DOWN:

                        break;

                    //手指滑动
                    case MotionEvent.ACTION_MOVE:
                        /**
                         * 1、getScorollY()——滚动条滑动的距离
                         * 2、getMeasuredHeight()——内容的整体高度，包括隐藏部分
                         * 3、getHeight()——显示高度。内容未布满屏幕，2=3；内容大于屏幕，3=屏幕高度，2>3。
                         */
                        //顶部状态
                        if(mapScrollView.getScrollY()<=0){
                        }

                        //顶部状态
                        //TextView的总高度<=一屏幕的高度+滚动条的滚动距离(getChildAt(0):第0个子控件)
                        if(mapScrollView.getChildAt(0).getMeasuredHeight()<= mapScrollView.getScrollY() + mapScrollView.getHeight()){

                        }
                        break;
                }
                return false;
            }
        });
    }

    private void initView() {
        phoneRegisterTxtTitle.setText("管内导览图");
    }


    @OnClick({R.id.phone_register_img_back})
    public void onClick(View view) {
        MFGT.finish(this);
    }
}
