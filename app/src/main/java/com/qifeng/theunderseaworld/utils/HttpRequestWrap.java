package com.qifeng.theunderseaworld.utils;

import android.content.Context;
import android.content.SharedPreferences;
import android.preference.PreferenceManager;
import android.text.TextUtils;
import android.util.Log;

import com.lidroid.xutils.HttpUtils;
import com.lidroid.xutils.http.RequestParams;
import com.lidroid.xutils.http.client.HttpRequest.HttpMethod;

import org.apache.http.impl.client.BasicCookieStore;
import org.apache.http.impl.cookie.BasicClientCookie;

import java.io.File;
import java.util.Map;
import java.util.Set;


public class HttpRequestWrap {
	public static final String GET = "get";
	public static final String POST = "post";

	private HttpUtils httpUtils;
	private Context context;
	private RequestHandler requestHandler;


	private HttpMethod method;

	public HttpRequestWrap() {
		this(null, GET);
	}


	public HttpRequestWrap(Context context) {
		this(context, GET);
	}


	public HttpRequestWrap(Context context, String method) {
		this.context = context;
		resetMethod(method);
		httpUtils = new HttpUtils();
		setCookie();
	}


	public void setMethod(String method) {
		resetMethod(method);
	}
	

	public void setCallBack(RequestHandler requestHandler) {
		this.requestHandler = requestHandler;
	}
	

	public HttpUtils getHttpUtils() {
		return httpUtils;
	}
	

	private void setCookie(){
		//���SessionID
		SharedPreferences sp = PreferenceManager.getDefaultSharedPreferences(context);
		String session = sp.getString("session", "");
		
		if(!TextUtils.isEmpty(session)){
			Log.d("HttpRequest", session);
			//����BasicClientCookie
			BasicClientCookie cc = 
					new BasicClientCookie("JSESSIONID", session);
			cc.setVersion(0);
			cc.setDomain("tr.zzapi.gson.cn");
			cc.setPath("/");
			

			BasicCookieStore cs = new BasicCookieStore();
			cs.addCookie(cc);
			

			httpUtils.configCookieStore(cs);
		}
	}


	private void resetMethod(String method) {
		if (GET.equals(method)) {
			this.method = HttpMethod.GET;
		} else if (POST.equals(method)) {
			this.method = HttpMethod.POST;
		} else {
			throw new IllegalArgumentException("请求不合理");
		}
	}
	

	public void send(String url, Map<String, Object> params){
		Log.d("URL", url);
		httpUtils.send(method, url, 
				tranlateParams(params), requestHandler);
	}
	

	public void send(String url){
		httpUtils.send(method, url, null, requestHandler);
	}
	
	
	

	private RequestParams tranlateParams(Map<String, Object> map){
		RequestParams params = new RequestParams();
		if(map == null) return params;
		
		Set<String> keys = map.keySet();
		for(String key : keys){
			if(HttpMethod.GET == method){
				//get����
				params.addQueryStringParameter(key, 
						(String)map.get(key));
			}else{
				//post����
				Object value = map.get(key);
				if(value.getClass() == String.class){
					params.addBodyParameter(key, (String)value);
				}else if(value.getClass() == File.class){
					params.addBodyParameter(key, (File)value);
				}
			}
		}
		return params;
	}
}







