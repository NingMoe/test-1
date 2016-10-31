package com.sharefree.init;

import org.apache.log4j.Logger;
import org.nutz.dao.Dao;
import org.nutz.dao.impl.FileSqlManager;
import org.nutz.dao.impl.NutDao;
import org.nutz.integration.quartz.NutQuartzCronJobFactory;
import org.nutz.ioc.Ioc;
import org.nutz.mvc.NutConfig;
import org.nutz.mvc.Setup;

import redis.clients.jedis.Jedis;
import redis.clients.jedis.JedisPool;

import com.sharefree.utils.ConstInit;
import com.sharefree.utils.StringUtil;
import com.sharefree.utils.WebSystemUtils;

public class MainSetup implements Setup {

	private static final Logger log = Logger.getLogger(MainSetup.class);

	public void init(NutConfig conf) {
		Ioc ioc = conf.getIoc();

		// 加载 SQL 文件
		initSqls(ioc);

		// 初始化静态数据
		ioc.get(ConstInit.class);

		// 计划任务的初始化与启动
		ioc.get(NutQuartzCronJobFactory.class);

		// REDIS启动验证
		initRedis(ioc);

		log.info("系统启动成功");
	}

	/**
	 * 加载SQL文件
	 * 
	 * @param ioc
	 */
	private void initSqls(Ioc ioc) {
		// 获取NutDao实例
		NutDao nutDao = (NutDao) ioc.get(Dao.class);
		// 加载 SQL 文件
		nutDao.setSqlManager(new FileSqlManager("sqls/"));
		log.debug("加载SQL配置文件成功，共" + nutDao.sqls().count() + "条");
	}

	/**
	 * REDIS启动验证
	 * 
	 * @param ioc
	 */
	private void initRedis(Ioc ioc) {
		JedisPool jedisPool = ioc.get(JedisPool.class);
		Jedis jedis = jedisPool.getResource();
		String resp = jedis.ping();
		if (StringUtil.isNotEmpty(resp)) {
			log.info("[PING --> " + resp + "],REDIS启动成功");
		} else {
			log.info("REDIS启动失败");
		}
	}

	public void destroy(NutConfig conf) {
		// 清除所有登陆token
		WebSystemUtils.clearToken();
		log.info("系统关闭成功");
	}

}
