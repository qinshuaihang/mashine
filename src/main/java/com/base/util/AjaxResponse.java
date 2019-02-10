package com.base.util;

/**
 * 
 *@ClassName:AjaxResponse.java
 *@Description:  采用双重校验单利模式,用于存储程序逻辑的返回判断  
 *@Author:lxt<839376636@qq.com>
 *@Date:2017年10月6日下午6:44:44
 *@Version:1.1.0
 */
public class AjaxResponse {
	private volatile static AjaxResponse singleton;
	private boolean success; 
	private String message;
	private Object data;

	public AjaxResponse() {
		super();
	}

	public AjaxResponse(boolean success, Object data) {
		super();
		this.success =success;
		this.data = data;
	}

	public static AjaxResponse instance() {
		if (singleton == null) {
			synchronized (AjaxResponse.class) {
				if (singleton == null) {
					singleton = new AjaxResponse();
				}
			}
		}
		return singleton;
	}

	public boolean isSuccess() {
		return success;
	}

	public void setSuccess(boolean success) {
		this.success = success;
	}

	public Object getData() {
		return data;
	}

	public void setData(Object data) {
		this.data = data;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}
	
}
