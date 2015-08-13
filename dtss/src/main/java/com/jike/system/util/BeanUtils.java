package com.jike.system.util;

import java.util.HashSet;
import java.util.Set;

import org.springframework.beans.BeanWrapper;
import org.springframework.beans.BeanWrapperImpl;

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
	
}
