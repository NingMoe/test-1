package com.sharefree.websocket.disney;

import java.util.Hashtable;
import java.util.List;
import java.util.Map;
import java.util.Set;

import javax.websocket.CloseReason;
import javax.websocket.OnClose;
import javax.websocket.OnError;
import javax.websocket.OnMessage;
import javax.websocket.OnOpen;
import javax.websocket.Session;
import javax.websocket.server.ServerEndpoint;

import org.apache.log4j.Logger;
import org.nutz.json.Json;
import org.nutz.json.JsonFormat;

import com.sharefree.constant.SystemConst;
import com.sharefree.model.SocketRender;
import com.sharefree.model.SocketResult;
import com.sharefree.model.system.OperatorModel;
import com.sharefree.utils.WebSystemUtils;

@ServerEndpoint(value = "/main")
public class DisneySocket {
	private static final Logger log = Logger.getLogger(DisneySocket.class);

	public static Map<String, Object[]> sessionMap = new Hashtable<String, Object[]>();

	@OnOpen
	public void onOpen(Session session) throws Exception {
		String token = validateLogin(session);
		if (token != null) {
			point(token, SocketRender.pointInfoResult(DisneySocket.class.getSimpleName(), "连接服务器成功"));
			log.info(String.format("Session [%s] is open Y(^_^)Y", token));
		} else {
			log.info(String.format("Session [%s] is invalid (T_T) ,Session closed", token));
			session.close();
		}
	}

	@OnMessage
	public void onMessage(String paramter, Session session) throws Exception {
		String token = getToken(session);
		if (token != null) {
			handleRequest(token, paramter);
		} else {
			log.info(String.format("Session [%s] is invalid (T_T) ,Session closed", token));
			session.close();
		}
	}

	@OnClose
	public void onClose(Session session, CloseReason closeReason) {
		String token = getToken(session);
		if (token != null) {
			sessionMap.remove(token);
			log.info(String.format("Session [%s] closed because of [%s] (T_T)", token, closeReason));
		}
	}

	@OnError
	public void error(Session session, Throwable throwable) throws Exception {
		String token = getToken(session);
		if (token != null) {
			sessionMap.remove(token);
			log.info(String.format("Session [%s] error: [%s]", token, throwable));
		} else {
			log.info(String.format("Session [%s] is invalid (T_T) ,Session closed", token));
			session.close();
		}
	}

	/**
	 * 
	 * 
	 * @param result
	 */
	public static void handleRequest(String token, String paramter) {
		point(token, SocketRender.pointInfoResult(DisneySocket.class.getSimpleName(), paramter));
	}

	/**
	 * 广播
	 * 
	 * @param result
	 */
	public static void broadcast(SocketResult result) {
		Set<String> keys = sessionMap.keySet();
		for (String key : keys) {
			try {
				Session session = getSession(key);
				if (session != null)
					session.getBasicRemote().sendText(Json.toJson(result, JsonFormat.compact()));
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
	}

	/**
	 * 私信
	 * 
	 * @param token
	 * @param result
	 */
	public static void point(String token, SocketResult result) {
		try {
			Session session = getSession(token);
			if (session != null)
				session.getBasicRemote().sendText(Json.toJson(result, JsonFormat.compact()));
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	private static String validateLogin(Session session) {
		String token = getToken(session);
		if (WebSystemUtils.validateLogin(token)) {
			if (!sessionMap.containsKey(token)) {
				Object[] obj = new Object[2];
				obj[0] = session;
				OperatorModel operator = WebSystemUtils.getLoginOpt(WebSystemUtils.getTokenKey(token));
				obj[1] = operator;
				sessionMap.put(token, obj);
			}
			resetTimeOut(token);
		} else {
			token = null;
		}
		return token;
	}

	private static String getToken(Session session) {
		// 获取token
		List<String> tokens = session.getRequestParameterMap().get(SystemConst.VALIDATE_LOGIN_TOKEN);
		// 验证登陆
		if (tokens != null && tokens.size() == 1) {
			return tokens.get(0);
		}
		return null;
	}

	private static Session getSession(String token) {
		Session session = null;
		if (sessionMap.containsKey(token)) {
			session = (Session) sessionMap.get(token)[0];
		}
		return session;
	}

	public static OperatorModel getOperator(String token) {
		OperatorModel operator = null;
		if (sessionMap.containsKey(token)) {
			operator = (OperatorModel) sessionMap.get(token)[1];
		}
		return operator;
	}

	/**
	 * 维持Session有效
	 * 
	 * @param token
	 */
	public static void resetTimeOut(String token) {
		Session session = getSession(token);
		if (session != null)
			session.setMaxIdleTimeout(SystemConst.LOGIN_TOKEN_TIMEOUT * 1000);
	}
}
