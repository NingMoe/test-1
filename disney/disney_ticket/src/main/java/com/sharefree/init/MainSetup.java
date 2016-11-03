package com.sharefree.init;

import java.util.List;

import org.apache.log4j.Logger;
import org.nutz.dao.Dao;
import org.nutz.dao.impl.FileSqlManager;
import org.nutz.dao.impl.NutDao;
import org.nutz.ioc.Ioc;
import org.nutz.mvc.NutConfig;
import org.nutz.mvc.Setup;

import redis.clients.jedis.Jedis;
import redis.clients.jedis.JedisPool;

import com.sharefree.jobs.disney.CheckTicketStockJob;
import com.sharefree.model.disney.ConstModel;
import com.sharefree.service.imp.RedisService;
import com.sharefree.service.imp.disney.ConstService;
import com.sharefree.service.itf.disney.IConstService;
import com.sharefree.utils.ConstInit;
import com.sharefree.utils.QuartzManager;
import com.sharefree.utils.StringUtil;
import com.sharefree.utils.WebSystemUtils;

public class MainSetup implements Setup {

	private static final Logger log = Logger.getLogger(MainSetup.class);

	public void init(NutConfig conf) {
		Ioc ioc = conf.getIoc();

		// 加载 SQL 文件
		initSqls(ioc);

		// REDIS启动验证
		initRedis(ioc);

		// 初始化静态数据
		initConsts(ioc);

		// 启动job
		// JobInfo.updateJob(new JobInfo(JobInfo.JobStateOpt.RUN));
		QuartzManager.addSimpleJob("testJob", "testJobGroup", "testTrigger", "testTriggerGroup", CheckTicketStockJob.class, null, null, -1, 10, null);

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
	 * 初始化静态数据
	 * 
	 * @param ioc
	 */
	private void initConsts(Ioc ioc) {
		// 获取Dao实例
		Dao dao = ioc.get(Dao.class);
		// 获取ConstService实例
		IConstService constService = ioc.get(ConstService.class);
		List<ConstModel> models = constService.query(new ConstModel());
		ConstInit.init(models, dao);
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
			WebSystemUtils.redisService = ioc.get(RedisService.class);
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
