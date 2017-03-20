package com.qifeng.theunderseaworld.adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CheckBox;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.qifeng.theunderseaworld.R;
import com.qifeng.theunderseaworld.bean.CartBean;

import java.util.ArrayList;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

/**
 * Created by Administrator on 2016/10/27.
 */
public class CartAdapter extends RecyclerView.Adapter {
    Context mContext;
    ArrayList<CartBean> mlist;
    RecyclerView parent;
    boolean isMore;


    public boolean isMore() {
        return isMore;
    }

    public void setMore(boolean more) {
        this.isMore = more;
        notifyDataSetChanged();
    }

    public int getFooterString() {
        return isMore ? R.string.load_more : R.string.no_more;
    }


    public CartAdapter(Context mContext, ArrayList<CartBean> list) {
        this.mContext = mContext;
        this.mlist = list;

    }

    public void initData(ArrayList<CartBean> list) {
        if (mlist != null) {
            mlist.clear();
        }
        mlist.addAll(list);
        //mlist = list;
        notifyDataSetChanged();
    }

    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        this.parent = (RecyclerView) parent;
        RecyclerView.ViewHolder holder = null;
        View layout = LayoutInflater.from(mContext).inflate(R.layout.item_cart, parent, false);
        holder = new CartViewHolder(layout);
        return holder;
    }

    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder holder, int position) {

        /*((CartViewHolder) holder).tvGoodsNum.setText("(" + cartBean.getCount() + ")");

        ((CartViewHolder) holder).tvGoodsName.setText(goods.getGoodsName());
        ((CartViewHolder) holder).tvprice.setText(goods.getCurrencyPrice());
        ((CartViewHolder) holder).idCheckbox1.setChecked(cartBean.isChecked());
        ImageLoader.downloadImg(mContext, ((CartViewHolder) holder).ivGoodsPicture, goods.getGoodsThumb());
        ((CartViewHolder) holder).idCheckbox1.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean b) {
                cartBean.setChecked(b);
                mContext.sendBroadcast(new Intent(I.BROADCASE_UPDATE_CART));
            }
        });

        ((CartViewHolder) holder).ivAddCart.setTag(position);*/


    }

    @Override
    public int getItemCount() {
        //return mlist == null ? 0 : mlist.size();
        return 3;
    }

    @OnClick({R.id.iv_dele_cart, R.id.iv_add_cart, R.id.rl_cart_item})
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.iv_dele_cart:
                break;
            case R.id.iv_add_cart:
                break;
            case R.id.rl_cart_item:
                break;
        }
    }


    class CartViewHolder extends RecyclerView.ViewHolder {

        @BindView(R.id.id_checkbox1)
        CheckBox idCheckbox1;
        @BindView(R.id.iv_Cart_picture)
        ImageView ivCartPicture;
        @BindView(R.id.tv_goods_name)
        TextView tvGoodsName;
        @BindView(R.id.tv_goods_num)
        TextView tvGoodsNum;
        @BindView(R.id.tv_price)
        TextView tvPrice;
        @BindView(R.id.rl_cart_item)
        RelativeLayout rlCartItem;

        public CartViewHolder(View view) {
            super(view);
            ButterKnife.bind(this, view);
        }

        @OnClick({R.id.id_checkbox1, R.id.iv_add_cart, R.id.iv_dele_cart})
        public void onClick(View view) {
            //final int position = (int) ivAddCart.getTag();
            //CartBean cart = mlist.get(position);

            switch (view.getId()) {
                case R.id.iv_add_cart:

                   /* NetDao.updateCart(mContext, cart.getId(), cart.getCount() + 1, new OkHttpUtils.OnCompleteListener<MessageBean>() {
                        @Override
                        public void onSuccess(MessageBean result) {
                            if (result != null && result.isSuccess()) {
                                mlist.get(position).setCount(mlist.get(position).getCount() + 1);
                                mContext.sendBroadcast(new Intent(I.BROADCASE_UPDATE_CART));
                                tvGoodsNum.setText("(" + mlist.get(position).getCount() + ")");
                            }
                        }

                        @Override
                        public void onError(String error) {

                        }
                    });*/

                    break;
                case R.id.iv_dele_cart:

                    //if (cart.getCount() > 1) {
                        /*NetDao.updateCart(mContext, cart.getId(), cart.getCount() - 1, new OkHttpUtils.OnCompleteListener<MessageBean>() {
                            @Override
                            public void onSuccess(MessageBean result) {
                                if (result != null && result.isSuccess()) {
                                    mlist.get(position).setCount(mlist.get(position).getCount() - 1);
                                    mContext.sendBroadcast(new Intent(I.BROADCASE_UPDATE_CART));
                                    tvGoodsNum.setText("(" + mlist.get(position).getCount() + ")");
                                }
                            }

                            @Override
                            public void onError(String error) {

                            }
                        });
                    } else {
                        NetDao.delCart(mContext, cart.getId(), new OkHttpUtils.OnCompleteListener<MessageBean>() {
                            @Override
                            public void onSuccess(MessageBean result) {
                                if (result != null && result.isSuccess()) {
                                    mlist.remove(position);
                                    mContext.sendBroadcast(new Intent(I.BROADCASE_UPDATE_CART));
                                    notifyDataSetChanged();

                                }
                            }

                            @Override
                            public void onError(String error) {

                            }
                        });*/
                    }

                   //break;

            //}
        }

        /*@OnClick(R.id.iv_Goods_picture)
        public void goDetails() {
            //final int position = (int) ivAddCart.getTag();
            //CartBean cart = mlist.get(position);
            //MFGT.gotoGoodsChildActivity((Activity) mContext, cart.getGoodsId());
        }*/
    }
}
