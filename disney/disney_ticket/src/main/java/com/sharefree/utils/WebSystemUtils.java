package com.sharefree.utils;

import com.sharefree.common.CommonException;
import com.sharefree.constant.SystemConst;
import com.sharefree.model.disney.TicketStockModel;
import com.sharefree.model.system.OperatorModel;
import com.sharefree.service.itf.IRedisService;
import com.sharefree.websocket.disney.DisneySocket;
import org.apache.log4j.Logger;
import org.nutz.json.Json;
import org.nutz.json.JsonFormat;

import javax.servlet.http.HttpServletRequest;
import java.util.*;

public class WebSystemUtils {

	private static final Logger log = Logger.getLogger(WebSystemUtils.class);

	public static IRedisService redisService;

	/**
	 * 验证登陆信息
	 * 
	 * @param request
	 * @return
	 */
	public static boolean validateLogin(HttpServletRequest request) {
		// 获取token
		String token = getToken(request);
		if (StringUtil.isEmpty(token))
			return false;
		String key = getTokenKey(token);
		if (!redisService.exists(key))
			return false;
		// 获取对象
		OperatorModel model = getLoginOpt(key);
		// 重置超时时间
		setTokenValue(key, model);
		DisneySocket.resetTimeOut(token);
		return true;
	}

	/**
	 * 验证登陆信息
	 * 
	 * @param token
	 * @return
	 */
	public static boolean validateLogin(String token) {
		if (StringUtil.isEmpty(token))
			return false;
		String key = getTokenKey(token);
		if (!redisService.exists(key))
			return false;
		return true;
	}

	/**
	 * 根据HttpServletRequest获取操作员信息对象
	 * 
	 * @param request
	 * @return
	 */
	public static OperatorModel getLoginOpt(HttpServletRequest request) {
		// 获取token
		String token = getToken(request);
		if (StringUtil.isEmpty(token))
			throw new CommonException("无效请求");
		String key = getTokenKey(token);
		if (!redisService.exists(key))
			throw new CommonException("登录超时");
		// 获取对象
		OperatorModel model = getLoginOpt(key);
		// 返回对象
		return model;
	}

	/**
	 * 根据token获取操作员信息对象
	 * 
	 * @param key
	 * @return
	 */
	public static OperatorModel getLoginOpt(String key) {
		// 获取对象
		String value = redisService.get(key);
		// 解析对象
		OperatorModel model = Json.fromJson(OperatorModel.class, value);
		// 返回对象
		return model;
	}

	/**
	 * http请求头部获取token
	 * 
	 * @param request
	 * @return
	 */
	public static String getToken(HttpServletRequest request) {
		String token = request.getHeader(SystemConst.VALIDATE_LOGIN_TOKEN);
		log.debug(token);
		return token;
	}

	/**
	 * 设置token-value
	 * 
	 * @param token
	 * @param value
	 */
	public static String setTokenValue(String token, Object value) {
		redisService.setEx(token, Json.toJson(value, JsonFormat.compact()), SystemConst.LOGIN_TOKEN_TIMEOUT);
		return Base64.encode(token);
	}

	/**
	 * 删除token
	 * 
	 * @param token
	 */
	public static void deleteToken(String token) {
		DisneySocket.sessionMap.remove(token);
		String key = getTokenKey(token);
		redisService.del(key);
	}

	/**
	 * 删除所有token
	 */
	public static void clearToken() {
		DisneySocket.sessionMap.clear();
		// 所有满足条件的keys
		String pattern = SystemConst.REDIS_KEY_LOGIN_TOKEN + ":*";
		Set<String> keys = redisService.keys(pattern);
		if (keys != null && keys.size() > 0) {
			for (String key : keys) {
				redisService.del(key);
			}
		}
	}

	/**
	 * 获取token-key
	 * 
	 * @param token
	 * @return
	 */
	public static String getTokenKey(String token) {
		return Base64.decode(token);
	}

	/**
	 * 统计库存
	 */
	public static void countStock(List<TicketStockModel> models) {
		if(models != null && models.size() > 0){
			//
			String key = SystemConst.REDIS_KEY_TICKET_STOCK;
			// 获取对象
			String value = redisService.get(key);
			Map<String, Integer> stock = null;
			if(StringUtil.isNotEmpty(value)){
				// 解析对象
				stock = Json.fromJson(Map.class, value);
				for(TicketStockModel model : models){
					String date = DateUtil.parseDateToString(model.getVisitDate(), DateUtil.FORMAT1);
					if(stock.containsKey(date)){
						if(stock.get(date) < model.getStock())
							stock.put(date, stock.get(date) + model.getStock());
					}else{
						stock.put(date, model.getStock());
					}
				}
				sortMap(stock);
			}else{
				stock = new LinkedHashMap<>();
				for(TicketStockModel model : models){
					String date = DateUtil.parseDateToString(model.getVisitDate(), DateUtil.FORMAT1);
					stock.put(date, model.getStock());
				}

			}
			redisService.set(key, Json.toJson(stock, JsonFormat.compact()));
		}
	}

	public static void sortMap(Map<String, Integer> stock){
		List<Map.Entry<String,Integer>> list = new ArrayList<Map.Entry<String,Integer>>(stock.entrySet());
		Collections.sort(list, new Comparator<Map.Entry<String, Integer>>() {
			@Override
			public int compare(Map.Entry<String, Integer> o1, Map.Entry<String, Integer> o2) {
				return o1.getValue().compareTo(o2.getValue());
			}
		});
	}

}
