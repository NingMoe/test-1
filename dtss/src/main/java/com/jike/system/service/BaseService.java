package com.jike.system.service;

import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.BeanUtils;

import com.jike.system.bean.Page;
import com.jike.system.web.CommonException;


/**
 * service层只做数据的转换（model-bean）和原子性的业务逻辑<br>
 * 成功数据的返回，失败信息的返回，错误的捕获，都在Controller做
 * 
 * @author Sun
 * 
 */
public abstract class BaseService {
	Logger log = LoggerFactory.getLogger(BaseService.class);

	/**
	 * 不需要设置page属性的多行查询 <br>
	 * 
	 * @param exampleClass
	 * @param model
	 * @return
	 * @throws Exception
	 */
	public Object getExample(Class<?> exampleClass) throws CommonException {
		return getExample(exampleClass, null);
	}

	/**
	 * 需要设置page属性的多行查询 <br>
	 * 利用JAVA反射机制 设置 page属性;
	 * 
	 * @param exampleClass
	 * @param model
	 * @return
	 * @throws Exception
	 */
	public Object getExample(Class<?> exampleClass, Page page)
			throws CommonException {

		Object example = null;
		try {
			example = exampleClass.newInstance();

			if (page != null) {
				Method setPageMethod = exampleClass.getMethod("setPage",
						Page.class);
				setPageMethod.invoke(example, page);
			}

		} catch (Exception e) {
			log.error("Example 反射设置 Page属性 出错  [{}{}]", e);
			throw new CommonException("Example 反射设置 Page属性 出错", e);
		}
		return example;
	}

	/**
	 * 
	 * @param example
	 * @param model
	 * @return
	 * @throws Exception
	 */
	public Object getEqualCriteria(Object example, Object model)
			throws CommonException {
		if (example == null || model == null) {
			return null;
		}
		try {
			Method createCriteriaMethod = example.getClass().getMethod(
					"createCriteria");
			Object criteria = createCriteriaMethod.invoke(example);

			Method[] modelMethods = model.getClass().getMethods();

			for (Method method : modelMethods) {
				String methodName = method.getName();
				if (methodName != null
						&& (methodName.startsWith("get") || methodName
								.startsWith("is"))) {
					Object beanProperty = method.invoke(model);
					if (beanProperty != null
							&& !(beanProperty instanceof Class)) {
						String propertyName = null;

						if (methodName.startsWith("get"))
							propertyName = methodName.substring(3,
									methodName.length());
						else if (methodName.startsWith("is"))
							propertyName = methodName.substring(2,
									methodName.length());

						// page是Example的属性 不是criteria的属性
						if ("page".equals(propertyName.toLowerCase())) {
							Method setPageMethod = example.getClass()
									.getDeclaredMethod("setPage",
											beanProperty.getClass());
							if (setPageMethod != null)
								setPageMethod.invoke(example, beanProperty);

							continue;
						}
						// if ("keywords".equals(propertyName.toLowerCase())) {
						// continue;
						// }
						// if ("limit".equals(propertyName.toLowerCase())) {
						// continue;
						// }
						// if ("no".equals(propertyName.toLowerCase())) {
						// continue;
						// }

						try {
							Method equalToMethod = criteria.getClass()
									.getDeclaredMethod(
											"and" + propertyName + "EqualTo",
											beanProperty.getClass());
							if (equalToMethod != null)
								equalToMethod.invoke(criteria, beanProperty);
						} catch (NoSuchMethodException e) {
							// log.info("Model -> Criteria 转换赋值错误 property:"
							// + propertyName);
						}
					}
				}
			}
			return criteria;
		} catch (Exception e) {
			log.error("Example 反射设置 Criteria Equal出错  [{}{}]", e);
			e.printStackTrace();
			throw new CommonException("Example 反射设置 Criteria Equal出错  ", e);
		}
	}

	/**
	 * 复制属性
	 * 
	 * @param source
	 * @param targetClass
	 * @return
	 * @throws Exception
	 */
	public Object copyProperties(Object source, Class<?> targetClass)
			throws CommonException {
		Object target = null;
		if (source != null) {
			try {
				target = targetClass.newInstance();
				BeanUtils.copyProperties(source, target);
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

	public static void main(String[] args) throws Exception {
	}
}
