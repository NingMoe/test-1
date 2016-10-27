package com.sharefree.service.itf;

import java.util.List;
import java.util.Map;
import java.util.Set;


/**
 * 
 * Title: IBaseService
 *
 * Description:
 *
 * Company: LuoPan
 *
 * @author pfxu
 *
 * @date Feb 17, 2016
 *
 */
public interface IRedisService {
	
	/**
	 * 确认一个key是否存在
	 * 
	 * @param key
	 * @return
	 */
	boolean exists(String key);

	/**
	 * 返回数据库中名称为key的string的value
	 * 
	 * @param key
	 * @return
	 */
	String get(String key);

	/**
	 * 返回满足给定pattern的所有key
	 * 
	 * @param pattern
	 * @return
	 */
	Set<String> keys(String pattern);

	/**
	 * 给数据库中名称为key的string赋予值value
	 * 没有则新建
	 * 
	 * @param key
	 * @param value
	 * @return
	 */
	boolean set(String key, String value);

	/**
	 * 删除一个key
	 * 
	 * @param key
	 * @return
	 */
	boolean del(String key);
	
	/**
	 * 在名称为key的list尾添加元素
	 * 
	 * @param key
	 * @param strings
	 * @return
	 */
	boolean rpush(String key, String... strings);
	
	/**
	 * 按范围取出list元素
	 * 
	 * @param key
	 * @param start
	 * @param end
	 * @return
	 */
	List<String> lrange(String key, long start, long end);

	/**
	 * 返回名称为key的hash中所有的键（field）及其对应的value
	 * 
	 * @param key
	 * @return
	 */
	Map<String, String> hGetAll(String key);

	/**
	 * 返回名称为key的hash中field对应的value
	 * 
	 * @param key
	 * @param field
	 * @return
	 */
	String hGet(String key, String field);

	/**
	 * 设定一个key的活动时间（s）
	 * 
	 * @param key
	 * @param seconds
	 * @return
	 */
	boolean expire(String key, int seconds);

	/**
	 * 向库中添加string，设定过期时间time
	 * 
	 * @param key
	 * @param value
	 * @param seconds
	 * @return
	 */
	boolean setEx(String key, String value, int seconds);
	
}
