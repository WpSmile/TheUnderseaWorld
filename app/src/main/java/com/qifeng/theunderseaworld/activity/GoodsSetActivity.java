package com.qifeng.theunderseaworld.activity;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import com.qifeng.theunderseaworld.R;
import com.qifeng.theunderseaworld.adapter.GoodsSetAdapter;
import com.qifeng.theunderseaworld.bean.GoodsSetBean;
import com.qifeng.theunderseaworld.utils.MFGT;
import com.qifeng.theunderseaworld.view.SpaceItemDecoretion;

import java.util.ArrayList;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

/*
* 团购的商品管理页面
* */
public class GoodsSetActivity extends AppCompatActivity {
    private final static String TAG = GoodsSetActivity.class.getCanonicalName();
    GoodsSetActivity mContext;

    @BindView(R.id.goods_set_recyclerView)
    RecyclerView goodsSetRecyclerView;

    ArrayList<GoodsSetBean> list;
    GoodsSetAdapter mAdapter;
    LinearLayoutManager manager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_goods_set);
        ButterKnife.bind(this);

        mContext = this;
        intiView();
    }

    private void intiView() {
        list = new ArrayList<>();
        GoodsSetBean bean = new GoodsSetBean();
        bean.setImage(R.drawable.today_activity_default);
        bean.setTitle("海底世界儿童票");
        bean.setPrice("￥35");
        bean.setKucun("999");
        bean.setStorename("海底世界官方旗舰店");

        for (int i = 0; i < 2; i++) {
            list.add(bean);
        }
        manager = new LinearLayoutManager(mContext);
        mAdapter = new GoodsSetAdapter(list,mContext);

        goodsSetRecyclerView.setLayoutManager(manager);
        goodsSetRecyclerView.setAdapter(mAdapter);

        goodsSetRecyclerView.setHasFixedSize(true);
        goodsSetRecyclerView.addItemDecoration(new SpaceItemDecoretion(12));

    }

    @OnClick(R.id.goods_set_img_back)
    public void onViewClicked() {
        MFGT.finish(mContext);
    }
}
