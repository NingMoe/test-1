package com.jike.system.biz;

import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.jike.system.util.HttpClientUtil;
import com.jike.system.util.SmsParamUtil;

public class SmsHandler{

	private static Logger log = LoggerFactory.getLogger(SmsHandler.class);
	// 请求编码
	public static String REQUEST_ENCODECHARSET = SmsParamUtil.getParam("REQUEST_ENCODECHARSET");
	// 请求URL
	public static String REQUEST_URL= SmsParamUtil.getParam("REQUEST_URL");
	// 请求发送短信--账号
	public static String REQUEST_ACCOUNT = SmsParamUtil.getParam("REQUEST_ACCOUNT");
	// 请求发送短信--密码
	public static String REQUEST_PASSWD = SmsParamUtil.getParam("REQUEST_PASSWD");
	// 需要状态?
	public static String NEED_STATUS = SmsParamUtil.getParam("NEED_STATUS");
	// ext号
	public static String EXT_NO = SmsParamUtil.getParam("EXT_NO");
	// 短信号码分隔符--","
	public static String MOBILE_SPLIT = ",";
	
	
	/**
	 * 发送创蓝短信
	 * get请求
	 * url: http://222.73.117.158/msg/HttpBatchSendSM?account=jiekou-clcs-02&pswd=Txb159357&mobile=15501302313,17712613261&msg=您的注册验证码您的注册验证码您的注册码!&needstatus=true&extno=123456
	 * @param message:
	 * @return 是否成功发送
	 */
	public static boolean sendMessage(String[] message){
		boolean sendSuccess = false;
		if(message.length == 2){
			String mobile = "&mobile="+message[0];
			String msg = null;
			try {
				msg = "&msg="+URLEncoder.encode(message[1], REQUEST_ENCODECHARSET);
			} catch (UnsupportedEncodingException e) {
				e.printStackTrace();
			}
			String send = REQUEST_URL+"?account="+REQUEST_ACCOUNT+"&pswd="+REQUEST_PASSWD+mobile+msg+"&needstatus="+NEED_STATUS+"&extno="+EXT_NO;
			// 待验证条件
			Map<String, Object> respObject = HttpClientUtil.sendGetRequest(send, null);
			log.info("创蓝短信："+respObject.get(HttpClientUtil.RESPONSE_CONTENT));
			sendSuccess = true;
		}
		return sendSuccess;
	}
	
	
	public static void main(String[] args) {
		// 发生提示短信
/*		String[] message = new String[2];
		message[0] = "13770270322";
		message[1] = "系统[travel_cs_web]接口,请及时查看";
		SmsHandler.sendMessage(message);*/
	}
}

