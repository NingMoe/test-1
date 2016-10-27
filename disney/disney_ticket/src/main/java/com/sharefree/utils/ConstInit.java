package com.sharefree.utils;

import java.lang.reflect.Field;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.nutz.dao.Dao;
import org.nutz.dao.Sqls;
import org.nutz.dao.sql.Sql;
import org.nutz.ioc.impl.PropertiesProxy;

import com.sharefree.constant.DisneyConst;
import com.sharefree.constant.SqlsConst;
import com.sharefree.constant.SystemConst;

public class ConstInit {

	private PropertiesProxy conf = null;

	private static Dao dao = null;

	public ConstInit(PropertiesProxy conf, Dao dao) {
		// 初始化conf
		this.conf = conf;
		// 初始化dao
		ConstInit.dao = dao;
		// 初始化静态数据
		init();
		initPassengerRowMax();
		initTripRowMax();
	}

	// 初始化静态数据, key格式为：类名简称.属性名
	public void init() {
		if (conf != null) {
			// 组织keys
			List<String> keys = conf.getKeys();
			if (keys != null && keys.size() > 0) {
				Map<String, List<String>> keyMap = new HashMap<String, List<String>>();
				for (String key : keys) {
					String[] splitKey = key.split("\\.");
					if (splitKey.length == 2) {
						String key1 = splitKey[0];
						String key2 = splitKey[1];
						if (keyMap.containsKey(key1)) {
							List<String> key2List = keyMap.get(key1);
							key2List.add(key2);
						} else {
							List<String> key2List = new ArrayList<String>();
							key2List.add(key2);
							keyMap.put(key1, key2List);
						}
					}
				}
				// 分别初始化各Class的静态数据
				for (String key1 : keyMap.keySet()) {
					switch (key1) {
					case "DisneyConst":
						initDisneyConst(keyMap.get(key1));
						break;
					case "SystemConst":
						initSystemConst(keyMap.get(key1));
						break;
					default:
						break;
					}

				}
			}
		}
		System.out.println("完成数据初始化");
	}

	public void initDisneyConst(List<String> keys) {
		Class<DisneyConst> clazz = DisneyConst.class;
		initValue(clazz, keys);
	}

	public void initSystemConst(List<String> keys) {
		Class<SystemConst> clazz = SystemConst.class;
		initValue(clazz, keys);
	}

	public void initValue(Class<?> clazz, List<String> keys) {
		String key1 = clazz.getSimpleName();
		String key;
		for (String key2 : keys) {
			key = key1 + "." + key2;
			Field declaredField;
			try {
				// 如果有字段名和配置的字段名相同
				declaredField = clazz.getDeclaredField(key2);
				// 按字段的类型设置
				if (declaredField != null) {
					if (declaredField.getType() == String.class) {
						declaredField.set(clazz, conf.get(key));
					} else if (declaredField.getType() == Boolean.class || declaredField.getType() == boolean.class) {
						declaredField.set(clazz, conf.getBoolean(key));
					} else if (declaredField.getType() == Integer.class || declaredField.getType() == int.class) {
						declaredField.set(clazz, conf.getInt(key));
					} else if (declaredField.getType() == Long.class || declaredField.getType() == long.class) {
						declaredField.set(clazz, conf.getLong(key));
					} else if (declaredField.getType() == Double.class || declaredField.getType() == double.class) {
						declaredField.set(clazz, Double.valueOf(conf.get(key)));
					} else if (declaredField.getType() == BigDecimal.class) {
						declaredField.set(clazz, new BigDecimal(conf.get(key)));
					}
				}
			} catch (NoSuchFieldException | SecurityException | IllegalArgumentException | IllegalAccessException e) {
				e.printStackTrace();
			}
		}
	}

	/**
	 * 查询乘客总数
	 */
	public static void initPassengerRowMax() {
		Sql sql = dao.sqls().create(SqlsConst.SELECT_PASSENGER_SUM);
		sql.setCallback(Sqls.callback.integer());
		dao.execute(sql);
		DisneyConst.PASSENGETR_ROW_MAX = sql.getObject(Integer.class);
	}

	/**
	 * 查询行程总数
	 */
	public static void initTripRowMax() {
		Sql sql = dao.sqls().create(SqlsConst.SELECT_TRIP_SUM);
		sql.setCallback(Sqls.callback.integer());
		dao.execute(sql);
		DisneyConst.TRIP_ROW_MAX = sql.getObject(Integer.class);
	}

	public static void main(String[] args) {
		Class<DisneyConst> clazz = DisneyConst.class;
		System.out.println(clazz.getSimpleName());
		System.out.println(DisneyConst.class.getSimpleName());

	}

}
