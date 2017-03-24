package com.qifeng.theunderseaworld.activity;

import android.content.Context;
import android.os.Build;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.AdapterView;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;

import com.qifeng.theunderseaworld.R;
import com.qifeng.theunderseaworld.adapter.DeliveryAddressAdapter;
import com.qifeng.theunderseaworld.seabed_state.BaseActivity;
import com.qifeng.theunderseaworld.seabed_state.StatusBarCompat;

/**
 * 收货地址页面
 * Created by XinAiXiaoWen on 2017/3/21.
 */

public class DeliveryAddressActivity extends BaseActivity implements View.OnClickListener,AdapterView.OnItemClickListener{

    private String TAG = DeliveryAddressActivity.class.getSimpleName();

    private Context deliveryAddressContext = null;

    private ImageView ivSeabedDeliveryaddressReturn = null;

    private TextView tvSeabedDeliveryaddressDlete = null;

    private ListView lvSeabedDeliveryaddressList = null;

    private DeliveryAddressAdapter deliveryAddressAdapter = null;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        requestWindowFeature(Window.FEATURE_NO_TITLE);

        //API19以下用于沉侵式菜单栏
        if (Build.VERSION.SDK_INT <= Build.VERSION_CODES.KITKAT) {
            getWindow().addFlags(WindowManager.LayoutParams.FLAG_TRANSLUCENT_STATUS);
            getWindow().addFlags(WindowManager.LayoutParams.FLAG_TRANSLUCENT_NAVIGATION);
        }

        //加载布局
        setContentView(R.layout.activity_deliveryaddress);

        //API>=20以上用于沉侵式菜单栏
        if (Build.VERSION.SDK_INT > Build.VERSION_CODES.KITKAT) {
            //沉侵
            StatusBarCompat.compat(this, getResources().getColor(R.color.colorPrimary));
        }

        initDeliveryAddressAgo();

        initDeliveryAddressView();

        initDeliveryAddressListener();

        initDeliveryAddressAdapter();

        initDeliveryAddressBack();
    }

    private void initDeliveryAddressAgo(){
        deliveryAddressContext = this;
    }

    private void initDeliveryAddressView(){
        ivSeabedDeliveryaddressReturn = (ImageView) this.findViewById(R.id.iv_seabed_deliveryaddress_return);
        tvSeabedDeliveryaddressDlete = (TextView) this.findViewById(R.id.tv_seabed_deliveryaddress_delete);
        lvSeabedDeliveryaddressList = (ListView) this.findViewById(R.id.lv_seabed_deliveryaddress_list);
    }

    private void initDeliveryAddressListener(){
        ivSeabedDeliveryaddressReturn.setOnClickListener(this);
        tvSeabedDeliveryaddressDlete.setOnClickListener(this);
        lvSeabedDeliveryaddressList.setOnItemClickListener(this);
    }

    private void initDeliveryAddressAdapter(){
        deliveryAddressAdapter = new DeliveryAddressAdapter(deliveryAddressContext);
        lvSeabedDeliveryaddressList.setAdapter(deliveryAddressAdapter);
    }

    private void initDeliveryAddressBack(){

    }


    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.iv_seabed_deliveryaddress_return:
                break;
            case R.id.tv_seabed_deliveryaddress_delete:
                break;
        }
    }

    @Override
    public void onItemClick(AdapterView<?> parent, View view, int position, long id) {

    }

    @Override
    protected void onStart() {
        super.onStart();
        Log.e(TAG, "---启动---");
    }

    @Override
    protected void onRestart() {
        super.onRestart();
        Log.e(TAG, "---恢复---");
    }

    @Override
    protected void onPause() {
        super.onPause();
        Log.e(TAG, "---暂停---");
    }

    @Override
    protected void onStop() {
        super.onStop();
        Log.e(TAG, "---停止---");
    }

    @Override
    protected void onResume() {
        super.onResume();
        Log.e(TAG, "---重启---");
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        Log.e(TAG, "---销毁---");
    }
}
