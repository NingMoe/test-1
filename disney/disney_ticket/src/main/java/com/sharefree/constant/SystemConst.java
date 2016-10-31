package com.sharefree.constant;

public class SystemConst {

	public static final String VALIDATE_LOGIN_TOKEN = "token";

	public static String REDIS_KEY_LOGIN_TOKEN = "OPT_TOKEN";

	// 登陆token失效时间（秒）
	public static int LOGIN_TOKEN_TIMEOUT = 30 * 60;

}
