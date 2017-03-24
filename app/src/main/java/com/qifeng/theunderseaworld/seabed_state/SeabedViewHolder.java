package com.qifeng.theunderseaworld.seabed_state;

import android.widget.CheckBox;
import android.widget.ImageView;
import android.widget.RadioButton;
import android.widget.TextView;

import com.qifeng.theunderseaworld.view.CircleImageView;

/**
 * Created by XinAiXiaoWen on 2017/3/16.
 */

public class SeabedViewHolder {

    /**
     * 商城
     */
    //图片
    public ImageView ivSeabedItemMallImage = null;
    //景区
    public TextView tvSeabedItemMallName = null;
    //票类
    public TextView tvSeabedItemMallTicket = null;
    //钱
    public TextView tvSeabedItemMallMoney = null;

    /**
     * 商品详情留言区
     */
    //头像
    public CircleImageView ciSeabedDetailsItemHead = null;
    //姓名
    public TextView tvSeabedDetailsItemName = null;
    //日期
    public TextView tvSeabedDetailsItemDate = null;
    //留言内容
    public TextView tvSeabedDetailsItemContext = null;

    /**
     * 个人信息
     */
    //头像
    public CircleImageView ciSeabedPersonalItemHead = null;
    //内容
    public TextView tvSeabedPersonalItemContext = null;
    //类别
    public TextView tvSeabedPersonalItemType = null;

    /**
     * 收货地址
     */
    //选择状态
    public RadioButton rbSeabedDeliveryaddressItemSelect = null;
    //姓名
    public TextView tvSeabedDeliveryaddressItemName = null;
    //电话
    public TextView tvSeabedDeliveryaddressItemPhone = null;
    //地址
    public TextView tvSeabedDeliveryaddressItemAddress = null;

    /**
     * 国家和地区
     */
    //国家
    public TextView tvSeabedCountryItemTitle = null;
    //分类字母
    public TextView tvSeabedCountryItemCatalog = null;
    //线
    public TextView tvSeabedCountryItemLine = null;

    /**
     * 商品管理
     */
    //商品图片
    public ImageView ivSeabedWareImage = null;
    //商家
    public TextView tvSeabedWareTicket = null;
    //来自
    public TextView tvSeabedWareFrom = null;
    //钱
    public TextView tvSeabedWareMoney = null;
    //减
    public ImageView ivSeabedWareMinus = null;
    //数量
    public TextView tvSseabedWareNumber = null;
    //加
    public ImageView ivSeabedWareAdd = null;
    //选择
    public CheckBox cbSeabedWareSelete = null;
}
