package com.jike.system.util;

import java.util.HashSet;
import java.util.Set;

import org.springframework.beans.BeanWrapper;
import org.springframework.beans.BeanWrapperImpl;

import com.alibaba.fastjson.JSON;

/**
 * Title:POJO工具
 * 
 * Description:
 * 
 * Copyright: Copyright (c) 2010-5-28
 * 
 * 
 * @version 1.0
 */
public class BeanUtils extends org.springframework.beans.BeanUtils {
	
	/**
	 * 将POJO属性为NULL的进行重新赋值
	 * @param source
	 * @param target
	 */
	public static void copyWithoutNullProperties (Object source, Object target) {
		BeanUtils.copyProperties(source, target, BeanUtils.getNullPropertyNames(source));
    }
	
	/**
	 * 获取空属性
	 * @param source
	 * @return
	 */
	public static String[] getNullPropertyNames (Object source) {
        final BeanWrapper src = new BeanWrapperImpl(source);
        java.beans.PropertyDescriptor[] pds = src.getPropertyDescriptors();

        Set<String> emptyNames = new HashSet<String>();
        for(java.beans.PropertyDescriptor pd : pds) {
            Object srcValue = src.getPropertyValue(pd.getName());
            if (srcValue == null) emptyNames.add(pd.getName());
        }
        String[] result = new String[emptyNames.size()];
        return emptyNames.toArray(result);
    }

    /**
     * 
     * 将待发送的数据转换为json格式
     * @param obj 待处理对象
     * @return json格式数据
     */
	public static String bean2Json(Object obj){
    	return JSON.toJSONString(obj);
    }
    
    /**
     * 将接受的json格式数据转换为对象
     * @param msg 待处理信息
     * @param targetObj 目标对象
     * @return 返回信息对象
     */
	public static Object json2Bean(String msg, Class<?> targetClass){
    	return JSON.toJavaObject(JSON.parseObject(msg), targetClass);
    }
	
}
