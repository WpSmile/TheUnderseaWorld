package com.qifeng.theunderseaworld.network;

/**
 * ��Ӧ������
 * @author �Ƽ������޺�
 *
 */
public interface OnResponseHandler {
	
	/**
	 * �����Ӧ���
	 * @param result ��Ӧ����
	 * @param status ״̬
	 */
	void onResponse(String result, RequestStatus status);
}
