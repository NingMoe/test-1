package org.flyingmemory.action.weChat;

import java.util.Map;

import org.flyingmemory.action.system.BaseAction;
import org.flyingmemory.base.util.ContextUtil;
import org.flyingmemory.base.util.SignUtil;
import org.flyingmemory.service.iface.CoreService;
import org.flyingmemory.system.util.MessageUtil;

/**
 * Title:核心请求处理类
 * 
 * Description:
 * 
 * Copyright: Copyright (c) 2013-12-01
 * 
 * Company: Shanghai allinfinance Co., Ltd.
 * 
 * author: 徐鹏飞
 *  
 * time: 2015年3月3日下午3:56:08
 * 
 * version: 1.0
 */
public class CoreAction extends BaseAction {
	
	private static final long serialVersionUID = 4440739483644821986L;
	private CoreService coreService = (CoreService) ContextUtil.getBean("CoreService");

	// 微信加密签名
	String signature;
	// 时间戳
	String timestamp;
	// 随机数
	String nonce;
	// 随机字符串
	String echostr;
	
	@Override
	protected void subExecute() throws Exception {

		/**
		 * 确认请求来自微信服务器
		 */
		if("GET".equals(method)){
			// 通过检验signature对请求进行校验，若校验成功则原样返回echostr，表示接入成功，否则接入失败
			if (SignUtil.checkSignature(signature, timestamp, nonce)) {
				writeMessage(echostr);
			}
		}
		
		/**
		 * 处理微信服务器发来的消息
		 */
		if("POST".equals(method)){
			// TODO 消息的接收、处理、响应
	        Map<String, String> requestMap =  null;
	        // xml请求解析  
	        try {
				requestMap = MessageUtil.parseXml(getRequest());
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}  
	        
	        // 调用核心业务类接收消息、处理消息  
	        String respMessage = coreService.processRequest(requestMap); 
			writeMessage(respMessage);
		}
	}

	/**
	 * @return the signature
	 */
	public String getSignature() {
		return signature;
	}

	/**
	 * @param signature the signature to set
	 */
	public void setSignature(String signature) {
		this.signature = signature;
	}

	/**
	 * @return the timestamp
	 */
	public String getTimestamp() {
		return timestamp;
	}

	/**
	 * @param timestamp the timestamp to set
	 */
	public void setTimestamp(String timestamp) {
		this.timestamp = timestamp;
	}

	/**
	 * @return the nonce
	 */
	public String getNonce() {
		return nonce;
	}

	/**
	 * @param nonce the nonce to set
	 */
	public void setNonce(String nonce) {
		this.nonce = nonce;
	}

	/**
	 * @return the echostr
	 */
	public String getEchostr() {
		return echostr;
	}

	/**
	 * @param echostr the echostr to set
	 */
	public void setEchostr(String echostr) {
		this.echostr = echostr;
	}

}
