package com.qifeng.theunderseaworld.utils;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;

/**
 * 用于保存用户信息的工具类
 * Created by liu on 2017/3/31.
 */

public class userInfoUtils {
    /*
    *
    * 保存用户信息的方法
    * */
    public static boolean saveUserInfo(String username,String userid){
        try {
            String result = username+"##"+userid;
            //写入数据
            File file = new File("/data/data/com.qifeng.underserworld/userInfo.text");//创建File，指定数据的存储位置
            FileOutputStream fos = new FileOutputStream(file);//创建文件的输出流
            fos.write(result.getBytes());//写入数据
            fos.close();//关闭流
            return true;
        }catch (Exception e){
            e.printStackTrace();
            return false;
        }
    }

    /*
    *
    * 读取用户信息的方法
    *
    * */

    public static Map<String,String> readUserInfo(){

        try{
            Map<String,String> userInfoMap = new HashMap<>();
            File file = new File("/data/data/com.qifeng.underserworld/userInfo.text");
            FileInputStream fis = new FileInputStream(file);
            BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(fis));
            String content = bufferedReader.readLine();//读取数据
            //切割数据、并把用户信息存入Map
            String[] userInfo = content.split("##");
            userInfoMap.put("username",userInfo[0]);
            userInfoMap.put("userid",userInfo[1]);
            fis.close();//关闭流

            return userInfoMap;

        }catch (Exception e){
            e.printStackTrace();
            return null;
        }


    }

}
