package com.qifeng.theunderseaworld.receiver;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.telephony.SmsMessage;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/*
*
* 用于接受短信验证码的广播
* */
public class MessageReceiver extends BroadcastReceiver {


    //定义回调接口(收到广播时候传入code)
    public interface ISMSListener {
        public void onSmsReceive(String code);
    }

    private ISMSListener mListener;

    public static final String SMS_RECEIVED_ACTION = "android.provider.Telephony.SMS_RECEIVED";

    public MessageReceiver() {
    }

    public MessageReceiver(ISMSListener mListener) {
        this.mListener = mListener;
    }

    @Override
    public void onReceive(Context context, Intent intent) {
        if (SMS_RECEIVED_ACTION.equals(intent.getAction())) {
            SmsMessage[] messages = getMessagesFromIntent(intent);
            for (SmsMessage message : messages) {
                String tel = message.getOriginatingAddress();//获取专用的号码用于判断（这里我们没有用到）
                String content = message.getDisplayMessageBody();//获取信息内容
                String code = null;
                Pattern p = Pattern.compile("\\d{4}");//一般验证码是6位数字的(当然你也可以更改)
                Matcher m = p.matcher(content);
                while (m.find()) {
                    code = m.group();
                    break;
                }

                if (mListener != null) {
                    mListener.onSmsReceive(code);
                }

            }
        }
    }


    public final SmsMessage[] getMessagesFromIntent(Intent intent) {
        Object[] messages = (Object[]) intent.getSerializableExtra("pdus");
        byte[][] pduObjs = new byte[messages.length][];
        for (int i = 0; i < messages.length; i++) {
            pduObjs[i] = (byte[]) messages[i];
        }
        byte[][] pdus = new byte[pduObjs.length][];
        int pduCount = pdus.length;
        SmsMessage[] msgs = new SmsMessage[pduCount];
        for (int i = 0; i < pduCount; i++) {
            pdus[i] = pduObjs[i];
            msgs[i] = SmsMessage.createFromPdu(pdus[i]);
        }
        return msgs;
    }

}
