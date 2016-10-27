package com.sharefree.service.imp;

import static com.sharefree.interceptor.RedisInterceptor.*;

import java.util.List;
import java.util.Map;
import java.util.Set;

import org.nutz.ioc.aop.Aop;
import org.nutz.ioc.loader.annotation.IocBean;

import com.sharefree.service.itf.IRedisService;

/**
 * Title: RedisService
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
public class RedisService implements IRedisService {

	@Override
	@Aop("redis")
	public boolean exists(String key) {
		return jedis().exists(key);
	}

	@Override
	@Aop("redis")
	public String get(String key) {
		return jedis().get(key);
	}

	@Override
	@Aop("redis")
	public Set<String> keys(String pattern) {
		return jedis().keys(pattern);
	}

	@Override
	@Aop("redis")
	public boolean set(String key, String value) {
		String result = jedis().set(key, value);
		if("OK".equals(result)){
			return true;
		}
		return false;
	}

	@Override
	@Aop("redis")
	public boolean del(String key) {
		Long result = jedis().del(key);
		if(result == 1){
			return true;
		}
		return false;
	}

	@Override
	@Aop("redis")
	public boolean rpush(String key, String... strings) {
		Long result = jedis().rpush(key, strings);
		if(result == 1){
			return true;
		}
		return false;
	}

	@Override
	@Aop("redis")
	public List<String> lrange(String key, long start, long end) {
		return jedis().lrange(key, start, end);
	}

	@Override
	@Aop("redis")
	public Map<String, String> hGetAll(String key) {
		return jedis().hgetAll(key);
	}

	@Override
	@Aop("redis")
	public String hGet(String key, String field) {
		return jedis().hget(key, field);
	}

	@Override
	@Aop("redis")
	public boolean expire(String key, int seconds) {
		Long result = jedis().expire(key, seconds);
		if(result == 1){
			return true;
		}
		return false;
	}

	@Override
	@Aop("redis")
	public boolean setEx(String key, String value, int seconds) {
		String result = jedis().setex(key, seconds, value);
		if("OK".equals(result)){
			return true;
		}
		return false;
	}

}
