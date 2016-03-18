package com.sharefree.service.imp;

import java.util.ArrayList;
import java.util.List;

import org.apache.log4j.Logger;
import org.nutz.dao.Dao;
import org.nutz.ioc.loader.annotation.Inject;

import com.sharefree.common.CommonException;
import com.sharefree.utils.BeanUtils;

/**
 * Title: BaseService
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
public abstract class BaseService {
	Logger log = Logger.getLogger(this.getClass());

    @Inject
    protected Dao dao;

	/**
	 * 复制属性
	 * 
	 * @param source
	 * @param targetClass
	 * @return
	 * @throws Exception
	 */
    protected Object copyProperties(Object source, Class<?> targetClass)
			throws CommonException {
		Object target = null;
		if (source != null) {
			try {
				target = BeanUtils.copyObject(source, targetClass);
			} catch (Exception e) {
				log.error("BaseService 复制model,target出错  [{}{}]", e);
				e.printStackTrace();
				throw new CommonException("BaseService 复制model,target出错 ", e);
			}
		}
		return target;
	}

	/**
	 * list列表复制属性
	 * 
	 * @param sourceList
	 * @param targetClass
	 * @return
	 * @throws CommonException
	 */
	@SuppressWarnings({ "unchecked", "rawtypes" })
	public List<?> copyListProperties(List<?> sourceList, Class<?> targetClass)
			throws CommonException {
		List targetList = null;
		try {
			if (sourceList != null) {
				targetList = new ArrayList<>();
			}
			for (Object source : sourceList) {
				Object obj = copyProperties(source, targetClass);
				targetList.add(obj);
			}
		} catch (Exception e) {
			log.error("BaseService 复制model,target出错  [{}{}]", e);
			e.printStackTrace();
			throw new CommonException("BaseService 复制model,target出错 ", e);
		}
		return targetList;
	}
	

}
