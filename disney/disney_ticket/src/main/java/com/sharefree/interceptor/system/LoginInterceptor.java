package com.sharefree.interceptor.system;

import java.util.Date;

import org.apache.log4j.Logger;
import org.nutz.aop.InterceptorChain;
import org.nutz.aop.MethodInterceptor;
import org.nutz.ioc.loader.annotation.Inject;
import org.nutz.ioc.loader.annotation.IocBean;

import com.sharefree.constant.SystemConst;
import com.sharefree.model.JsonResult;
import com.sharefree.model.system.OperatorModel;
import com.sharefree.service.itf.IRedisService;
import com.sharefree.utils.DateUtil;
import com.sharefree.utils.WebSystemUtils;

/**
 * Title: RedisInterceptor
 *
 * Description:
 *
 * Company: LuoPan
 *
 * @author pfxu
 *
 * @date Mar 18, 2016
 *
 */
@IocBean
public class LoginInterceptor implements MethodInterceptor {
	private static Logger log = Logger.getLogger(LoginInterceptor.class);

	@Inject
	private IRedisService redisService;

	@Override
	public void filter(InterceptorChain chain) throws Throwable {
		chain.doChain();
		if (chain.getReturn() instanceof JsonResult) {
			// 获取返回对象
			JsonResult result = (JsonResult) chain.getReturn();
			// 获取登录信息
			OperatorModel model = (OperatorModel) result.getResults();
			// 设置登录token
			String token = SystemConst.REDIS_KEY_LOGIN_TOKEN + ":" + model.getOptNo() + ":" + DateUtil.parseDateToString(new Date(), DateUtil.FORMAT13);
			// 保存登陆token
			token = WebSystemUtils.setTokenValue(token, model);
			// 回复登陆token
			result.setToken(token);
			chain.setReturnValue(result);
		} else {
			log.debug("登陆结果失败");
		}

	}

}
