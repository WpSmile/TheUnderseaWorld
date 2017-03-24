package com.qifeng.theunderseaworld.seabed_state;

import android.content.Context;
import android.widget.Toast;

import com.qifeng.theunderseaworld.view.Personal;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by XinAiXiaoWen on 2017/3/16.
 */

public class SeabedState {

    private String TAG = SeabedState.class.getSimpleName();

    private static SeabedState seabedState = new SeabedState();

    //内容
    private String[] personal = {
            "会飞的鱼",
            "137*****040",
            "yxpyxpyxp",
            "yxpyxpyxp",
            "四川省成都市青羊区狮马路22"
    };

    //类别
    private String[] personalType = {
            "昵称设置",
            "绑定手机",
            "绑定微信",
            "绑定支付宝",
            "收货地址"
    };

    //集合
    private List<Personal> personalList = new ArrayList<Personal>();

    /**
     * 初始化数据
     */
    public void personalInit(){
        for(int i = 0;i <personalType.length;i++){
            Personal p = new Personal(personal[i],personalType[i]);
            personalList.add(p);
        }
    }

    /**
     * 提示信息
     * @param context
     * @param prompt
     */
    public void initToast(Context context,String prompt){
        Toast.makeText(context,prompt,Toast.LENGTH_SHORT).show();
    }

    public static SeabedState getSeabedState() {
        return seabedState;
    }


    public List<Personal> getPersonalList() {
        return personalList;
    }
}
