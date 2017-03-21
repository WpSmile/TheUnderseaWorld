package com.qifeng.theunderseaworld.activity;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;

import com.qifeng.theunderseaworld.R;
import com.qifeng.theunderseaworld.utils.CommonUtils;
import com.qifeng.theunderseaworld.utils.MFGT;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

/*发表评论*/
public class CommentActivity extends AppCompatActivity {
    private final static String TAG = CommentActivity.class.getCanonicalName();
    CommentActivity mContext;

    @BindView(R.id.comment_btn_fabu)
    Button commentBtnFabu;
    @BindView(R.id.comment_btn_grade01)
    Button commentBtnGrade01;
    @BindView(R.id.comment_btn_grade02)
    Button commentBtnGrade02;
    @BindView(R.id.comment_btn_grade03)
    Button commentBtnGrade03;
    @BindView(R.id.comment_btn_grade04)
    Button commentBtnGrade04;
    @BindView(R.id.comment_btn_grade05)
    Button commentBtnGrade05;
    @BindView(R.id.comment_et)
    EditText commentEt;
    @BindView(R.id.comment_image_first)
    ImageView commentImageFirst;
    @BindView(R.id.comment_image_item_add)
    ImageView commentImageItemAdd;
    @BindView(R.id.comment_textView_num)
    TextView commentTextViewNum;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_comment);
        ButterKnife.bind(this);
        mContext = this;
        initView();
        initData();
    }

    private void initData() {

    }

    private void initView() {
        //获取输入的文本
        String string = commentEt.getText().toString();
        //计算输入的长度
        int count = string.length();
        //改变显示的数字
        //commentTextViewNum.setText(200 - count);
    }

    @OnClick({R.id.comment_img_back, R.id.comment_btn_fabu, R.id.comment_btn_grade01, R.id.comment_btn_grade02, R.id.comment_btn_grade03, R.id.comment_btn_grade04, R.id.comment_btn_grade05, R.id.comment_image_item_add})
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.comment_img_back:
                MFGT.finish(mContext);
                break;
            case R.id.comment_btn_fabu://发布评论
                if ("".equals(commentEt)) {//判断输入框的内容是否为空
                    CommonUtils.showLongToast("评论不能为空");
                } else {//发布

                }
                break;
            case R.id.comment_btn_grade01://评分对应的按钮
                break;
            case R.id.comment_btn_grade02:
                break;
            case R.id.comment_btn_grade03:
                break;
            case R.id.comment_btn_grade04:
                break;
            case R.id.comment_btn_grade05:
                break;
            case R.id.comment_image_item_add://图片添加(从本地相机等选择图片)
                break;
        }
    }
}
