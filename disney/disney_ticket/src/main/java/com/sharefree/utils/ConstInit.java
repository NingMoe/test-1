package com.sharefree.utils;

import java.lang.reflect.Field;
import java.math.BigDecimal;
import java.util.List;

import org.nutz.dao.Dao;
import org.nutz.dao.Sqls;
import org.nutz.dao.entity.annotation.Comment;
import org.nutz.dao.sql.Sql;

import com.sharefree.constant.DisneyConst;
import com.sharefree.constant.SqlsConst;
import com.sharefree.model.disney.ConstModel;

public class ConstInit {

	// 初始化静态数据
	public static void init(List<ConstModel> models, Dao dao) {
		initValue(DisneyConst.class, models);
		initPassengerRowMax(dao);
		initTripRowMax(dao);
	}

	public static void initValue(Class<?> clazz, List<ConstModel> models) {
		if (models != null && models.size() > 0) {
			for (ConstModel model : models) {
				Field declaredField;
				try {
					// 如果有字段名和配置的字段名相同
					declaredField = clazz.getDeclaredField(model.getConstKey());
					// 按字段的类型设置
					if (declaredField != null) {
						if (declaredField.getAnnotation(Comment.class) != null) {
							if (declaredField.getType() == String.class) {
								declaredField.set(clazz, model.getConstValue());
							} else if (declaredField.getType() == Boolean.class || declaredField.getType() == boolean.class) {
								declaredField.set(clazz, Boolean.valueOf(model.getConstValue()));
							} else if (declaredField.getType() == Integer.class || declaredField.getType() == int.class) {
								declaredField.set(clazz, Integer.valueOf(model.getConstValue()));
							} else if (declaredField.getType() == Long.class || declaredField.getType() == long.class) {
								declaredField.set(clazz, Long.valueOf(model.getConstValue()));
							} else if (declaredField.getType() == Double.class || declaredField.getType() == double.class) {
								declaredField.set(clazz, Double.valueOf(model.getConstValue()));
							} else if (declaredField.getType() == BigDecimal.class) {
								declaredField.set(clazz, new BigDecimal(model.getConstValue()));
							}
						}
					}
				} catch (NoSuchFieldException | SecurityException | IllegalArgumentException | IllegalAccessException e) {
					e.printStackTrace();
				}
			}
		}
	}

	/**
	 * 查询乘客总数
	 */
	public static void initPassengerRowMax(Dao dao) {
		if (dao != null) {
			Sql sql = dao.sqls().create(SqlsConst.SELECT_PASSENGER_SUM);
			sql.setCallback(Sqls.callback.integer());
			dao.execute(sql);
			DisneyConst.PASSENGETR_ROW_MAX = sql.getObject(Integer.class);
		}
	}

	/**
	 * 查询行程总数
	 */
	public static void initTripRowMax(Dao dao) {
		if (dao != null) {
			Sql sql = dao.sqls().create(SqlsConst.SELECT_TRIP_SUM);
			sql.setCallback(Sqls.callback.integer());
			dao.execute(sql);
			DisneyConst.TRIP_ROW_MAX = sql.getObject(Integer.class);
		}
	}

	public static void main(String[] args) {
		Class<DisneyConst> clazz = DisneyConst.class;
		System.out.println(clazz.getSimpleName());
		System.out.println(DisneyConst.class.getSimpleName());
	}

}
