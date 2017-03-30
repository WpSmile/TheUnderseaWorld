package com.qifeng.theunderseaworld.network;

import android.app.ProgressDialog;
import android.content.Context;

import com.lidroid.xutils.exception.HttpException;
import com.lidroid.xutils.http.ResponseInfo;
import com.lidroid.xutils.http.callback.RequestCallBack;

/**
 * �������������������ΪString
 * <p>
 * ����ʱ����ӽ�����
 * 
 * @author �Ƽ������޺�
 * 
 */
public class RequestHandler extends RequestCallBack<String> {
	private Context context;
	private ProgressDialog progressDialog;
	private OnResponseHandler responseHandler;
	private JSONValidator jsonValidator;

	public RequestHandler(Context context, 
			OnResponseHandler responseHandler) {
		super();
		this.context = context;
		this.responseHandler = responseHandler;
		jsonValidator = new JSONValidator();
	}

	@Override
	public void onStart() {
		super.onStart();
		openDialog();
	}

	/**
	 * �򿪽������Ի���
	 */
	private void openDialog() {
		progressDialog = new ProgressDialog(context);
		progressDialog.setTitle("数据加载");
		progressDialog.setMessage("正在下载数据...");
		progressDialog.setProgressStyle(ProgressDialog.STYLE_SPINNER);//����
		progressDialog.show();
	}
	
	/**
	 * �رս������Ի���
	 */
	private void closeDialog(){
		if(progressDialog != null){
			progressDialog.dismiss();
		}
	}

	@Override
	public void onLoading(long total, long current, boolean isUploading) {
		super.onLoading(total, current, isUploading);
	}

	@Override
	public void onFailure(HttpException arg0, String arg1) {
		if(responseHandler != null){
			responseHandler.onResponse(null, RequestStatus.FAILURE);
		}
		//closeDialog();
	}

	@Override
	public void onSuccess(ResponseInfo<String> responseInfo) {
		if(responseHandler != null){
			String result = responseInfo.result;
			//����Ƿ�Ϊ��Ч��JSON
			if(jsonValidator.validate(result)){
				responseHandler.onResponse(result, RequestStatus.SUCCESS);
			}else{
				responseHandler.onResponse(null, RequestStatus.BAD_JSON);
			}
		}
		
		closeDialog();
	}

}
