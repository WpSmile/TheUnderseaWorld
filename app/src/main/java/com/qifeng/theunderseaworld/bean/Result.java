package com.qifeng.theunderseaworld.bean;

import java.io.Serializable;

public class Result implements Serializable {
	private boolean retMsg;
	private Object retData;

	public Result() {
	}

	public Result(boolean retMsg, Object retData) {
		this.retMsg = retMsg;
		this.retData = retData;
	}

	public boolean isRetMsg() {
		return retMsg;
	}

	public void setRetMsg(boolean retMsg) {
		this.retMsg = retMsg;
	}

	public Object getRetData() {
		return retData;
	}

	public void setRetData(Object retData) {
		this.retData = retData;
	}

	@Override
	public String toString() {
		return "Result{" +
				"retMsg=" + retMsg +
				", retData=" + retData +
				'}';
	}
}
