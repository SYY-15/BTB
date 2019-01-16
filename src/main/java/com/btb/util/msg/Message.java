package com.btb.util.msg;

import org.json.JSONObject;

/**
 * 用于返回数据
 * @author 王宁
 *
 */
public class Message {
	
	private JSONObject message;
	
	public Message() {
		this.message = new JSONObject();
	}
	
	/**
	 * 添加消息
	 * @param msg 消息
	 */
	public void setMsg(String msg) {
		message.put("msg", msg);
	}
	
	/**
	 * 添加状态
	 * @param status 状态
	 */
	public void setStatus(int status) {
		message.put("status", status);
	}
	
	/**
	 * 添加数据
	 * @param data 数据
	 */
	public void setData(Object data) {
		message.put("data", data);
	}

	@Override
	public String toString() {
		return message.toString();
	}

	
}
