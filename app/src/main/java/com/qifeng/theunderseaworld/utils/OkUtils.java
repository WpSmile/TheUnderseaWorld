package com.qifeng.theunderseaworld.utils;

import android.content.Context;
import android.os.Handler;
import android.os.Message;

import com.google.gson.Gson;

import java.io.File;
import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;

import okhttp3.Call;
import okhttp3.Callback;
import okhttp3.FormBody;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.RequestBody;
import okhttp3.Response;

/**
 * Created by yao on 2016/12/1.
 */

public class OkUtils<T> {
    public static final String UTF_8 = "utf-8";
    public static final int RESULT_SUCCESS = 0;
    private static final int RESULT_ERROR = 1;

    private static OkHttpClient mOkHttpClient;

    private Handler mHandler;

    private StringBuilder mUrl;

    private OnCompleteListener<T> mListener;

    //用来json解析的，解析为T的对象
    private Class<T> mClazz;

    //定义post方式的表单构建者
    FormBody.Builder mFormBuilder;

    /** 定义用于存放上传文件的类型*/
    RequestBody mFileBody;

    //
    Callback mCallback=new Callback() {
        @Override
        public void onFailure(Call call, IOException e) {
            Message msg = Message.obtain();
            msg.what = RESULT_ERROR;
            msg.obj = e.getMessage();
            mHandler.sendMessage(msg);
        }

        @Override
        public void onResponse(Call call, Response response) throws IOException {
            String json = response.body().string();
            Gson gson = new Gson();
            T t = gson.fromJson(json, mClazz);
            Message msg = Message.obtain();
            msg.what = RESULT_SUCCESS;
            msg.obj = t;
            mHandler.sendMessage(msg);
        }
    };

    public interface OnCompleteListener<T> {
        void onSuccess(T t);

        void onError(String error);
    }

    public OkUtils(Context context) {
        if (mOkHttpClient == null) {
            synchronized (OkUtils.class) {
                if (mOkHttpClient == null) {
                    mOkHttpClient = new OkHttpClient();
                }
            }
        }
        initHandler(context);
    }

    private void initHandler(Context context) {
        mHandler = new Handler(context.getMainLooper()) {
            @Override
            public void handleMessage(Message msg) {
                switch (msg.what) {
                    case RESULT_ERROR:
                        if (mListener != null && msg.obj != null) {
                            mListener.onError(msg.obj.toString());
                        }
                        break;
                    case RESULT_SUCCESS:
                        if (mListener != null && msg.obj != null) {
                            T t = (T) msg.obj;
                            mListener.onSuccess(t);
                        }
                        break;
                }
            }
        };
    }

    public OkUtils<T> url(String rootUrl) {
        mUrl = new StringBuilder(rootUrl);
        return this;
    }

    public OkUtils<T> addParam(String key, String value) {
        if (mFormBuilder != null) {//若调用了post方法
            try {
                mFormBuilder.add(key, URLEncoder.encode(value, UTF_8));
            } catch (UnsupportedEncodingException e) {
                e.printStackTrace();
            }
        } else {//get请求方式的url
            if (mUrl.indexOf("?") == -1) {
                mUrl.append("?");
            } else {
                mUrl.append("&");
            }
            try {
                mUrl.append(key).append("=").append(URLEncoder.encode(value, UTF_8));
            } catch (UnsupportedEncodingException e) {
                e.printStackTrace();
            }
        }
        return this;
    }

    /**
     * 设置json解析的目标类.class
     *
     * @param clazz
     * @return
     */
    public OkUtils<T> targetClass(Class<T> clazz) {
        mClazz = clazz;
        return this;
    }

    public void execute(OnCompleteListener<T> listener) {
        mListener = listener;
        //创建builder
        Request.Builder builder = new Request.Builder().url(mUrl.toString());
        if (mFormBuilder != null) {//设置post要求的提交
            builder.post(mFormBuilder.build());
        }

        if (mFileBody != null) {
            builder.post(mFileBody);
        }

        Request request = builder.build();
        Call call = mOkHttpClient.newCall(request);
        call.enqueue(mCallback);
    }

    /**设置post请求*/
    public OkUtils<T> post() {
        mFormBuilder = new FormBody.Builder();
        return this;
    }

    public OkUtils<T> addFile(File file) {
        mFileBody = RequestBody.create(null, file);
        return this;
    }

    public OkUtils<T> doInBackground(Callback callback) {
        mCallback=callback;
        return this;
    }

    public void sendMessage(Message msg) {
        mHandler.sendMessage(msg);
    }
}
