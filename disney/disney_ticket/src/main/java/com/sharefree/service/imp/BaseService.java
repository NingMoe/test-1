package com.sharefree.service.imp;

import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.List;

import org.apache.log4j.Logger;
import org.nutz.dao.Chain;
import org.nutz.dao.Cnd;
import org.nutz.dao.Dao;
import org.nutz.dao.FieldMatcher;
import org.nutz.dao.Sqls;
import org.nutz.dao.entity.Entity;
import org.nutz.dao.pager.Pager;
import org.nutz.dao.sql.Criteria;
import org.nutz.dao.sql.OrderBy;
import org.nutz.dao.sql.Sql;
import org.nutz.ioc.loader.annotation.Inject;

import com.sharefree.common.CommonException;
import com.sharefree.model.BaseModel;
import com.sharefree.service.itf.IBaseService;
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
public class BaseService<Model extends BaseModel, Bean, Id> implements IBaseService<Model, Id> {

	private static final Logger log = Logger.getLogger(BaseService.class);

	@Inject
	protected Dao dao;

	private Class<Model> modelClass;

	private Class<Bean> beanClass;

	private Class<Id> idClass;

	@SuppressWarnings("unchecked")
	public BaseService() {
		Type type = this.getClass().getGenericSuperclass();
		if (type instanceof ParameterizedType) {
			ParameterizedType pt = (ParameterizedType) this.getClass().getGenericSuperclass();
			this.modelClass = (Class<Model>) pt.getActualTypeArguments()[0];
			this.beanClass = (Class<Bean>) pt.getActualTypeArguments()[1];
			this.idClass = (Class<Id>) pt.getActualTypeArguments()[2];
		} else {
			log.debug("type instanceof :" + type.getClass().getName());
		}
	}

	/**
	 * 复制model信息到bean
	 * 
	 * @param model
	 * @return
	 * @throws CommonException
	 */
	@SuppressWarnings("unchecked")
	protected Bean copyModel2Bean(Model model) throws CommonException {
		Bean bean = null;
		if (model != null) {
			try {
				bean = (Bean) BeanUtils.copyObject(model, beanClass);
			} catch (Exception e) {
				log.error("BaseService.copyModel2Bean出错  [{}{}]", e);
				e.printStackTrace();
				throw new CommonException("BaseService.copyModel2Bean出错 ", e);
			}
		}
		return bean;
	}

	/**
	 * 复制bean信息到model
	 * 
	 * @param bean
	 * @return
	 * @throws CommonException
	 */
	@SuppressWarnings("unchecked")
	protected Model copyBean2Model(Bean bean) throws CommonException {
		Model model = null;
		if (bean != null) {
			try {
				model = (Model) BeanUtils.copyObject(bean, modelClass);
			} catch (Exception e) {
				log.error("BaseService.copyBean2Model出错  [{}{}]", e);
				e.printStackTrace();
				throw new CommonException("BaseService.copyBean2Model出错 ", e);
			}
		}
		return model;
	}

	/**
	 * 复制models列表信息到beans列表
	 * 
	 * @param models
	 * @return
	 * @throws CommonException
	 */
	protected List<Bean> copyModels2Beans(List<Model> models) throws CommonException {
		List<Bean> beans = null;
		try {
			if (models != null) {
				beans = new ArrayList<Bean>();
			}
			for (Model source : models) {
				Bean obj = copyModel2Bean(source);
				beans.add(obj);
			}
		} catch (Exception e) {
			log.error("BaseService.copyModels2Beans出错  [{}{}]", e);
			e.printStackTrace();
			throw new CommonException("BaseService.copyModels2Beans出错 ", e);
		}
		return beans;
	}

	/**
	 * 复制beans列表信息到models列表
	 * 
	 * @param beans
	 * @return
	 * @throws CommonException
	 */
	protected List<Model> copyBeans2Models(List<Bean> beans) throws CommonException {
		List<Model> models = null;
		try {
			if (beans != null) {
				models = new ArrayList<Model>();
			}
			for (Bean source : beans) {
				Model obj = copyBean2Model(source);
				models.add(obj);
			}
		} catch (Exception e) {
			log.error("BaseService.copyBeans2Models出错  [{}{}]", e);
			e.printStackTrace();
			throw new CommonException("BaseService.copyBeans2Models出错 ", e);
		}
		return models;
	}

	@Override
	public Model fetch(Id id) {
		Bean bean = null;
		if (idClass.isAssignableFrom(Long.class)) {
			bean = dao.fetch(beanClass, (Long) id);
		} else if (idClass.isAssignableFrom(String.class)) {
			bean = dao.fetch(beanClass, (String) id);
		} else {
			log.error("非法ID类型：" + idClass.getClass().getSimpleName());
			throw new CommonException("非法ID类型：" + idClass.getClass().getSimpleName());
		}
		return copyBean2Model(bean);
	}

	@Override
	public List<Model> query(Model cnd) {
		// 查询条件
		Criteria cri = criteriaCreator(cnd);
		// 排序信息
		orderByCreator(cnd, cri);
		// 查询
		return query(cri, cnd.getPager());
	}

	/**
	 * 自定义条件查询数据
	 * 
	 * @param cri
	 * @param pager
	 * @return
	 */
	public List<Model> query(Criteria cri, Pager pager) {
		// 查询
		List<Bean> beans = dao.query(beanClass, cri, pager);
		return copyBeans2Models(beans);
	}

	/**
	 * 自定义查询SQL
	 * 
	 * @param cnd
	 * @return
	 */
	@Override
	public List<Model> queryByCustomSQL(Model cnd) {
		// 查询条件
		Criteria cri = criteriaCreator(cnd);
		// 排序信息
		orderByCreator(cnd, cri);
		// 查询
		return queryByCustomSQL(cnd, cri, cnd.getPager());
	}

	/**
	 * 自定义查询SQL
	 * 
	 * @param cnd
	 * @return
	 */
	public List<Model> queryByCustomSQL(Model cnd, Criteria cri, Pager pager) {
		Sql sql = dao.sqls().create(cnd.getSqlKey());
		sql.setCallback(Sqls.callback.entities());
		Entity<Bean> entity = dao.getEntity(beanClass);
		sql.setEntity(entity);
		sql.setCondition(cri);
		sql.setPager(pager);
		dao.execute(sql);
		List<Bean> beans = sql.getList(beanClass);
		return copyBeans2Models(beans);
	}

	@Override
	public int count(Model cnd) {
		// 查询条件
		Criteria cri = criteriaCreator(cnd);
		// 查询
		return count(cri);
	}

	/**
	 * 自定义条件查询数量
	 * 
	 * @param cri
	 * @param pager
	 * @return
	 */
	public int count(Criteria cri) {
		// 查询
		return dao.count(beanClass, cri);
	}

	/**
	 * 自定义计数SQL
	 * 
	 * @param cnd
	 * @return
	 */
	@Override
	public int countByCustomSQL(Model cnd) {
		// 查询条件
		Criteria cri = criteriaCreator(cnd);
		// 查询
		return countByCustomSQL(cnd, cri);
	}

	/**
	 * 自定义计数SQL
	 * 
	 * @param cnd
	 * @return
	 */
	public int countByCustomSQL(Model cnd, Criteria cri) {
		Sql sql = dao.sqls().create(cnd.getSqlKey());
		sql.setCallback(Sqls.callback.integer());
		sql.setCondition(cri);
		dao.execute(sql);
		return sql.getObject(Integer.class);
	}

	@Override
	public Model insert(Model model) {
		Bean bean = copyModel2Bean(model);
		bean = dao.insert(bean);
		return copyBean2Model(bean);
	}

	@Override
	public List<Model> insert(List<Model> models) {
		List<Bean> beans = copyModels2Beans(models);
		beans = dao.insert(beans);
		return copyBeans2Models(beans);
	}

	@Override
	public int delete(Id id) {
		if (idClass.isAssignableFrom(Long.class)) {
			return dao.delete(beanClass, (Long) id);
		} else if (idClass.isAssignableFrom(String.class)) {
			return dao.delete(beanClass, (String) id);
		} else {
			log.error("非法ID类型：" + idClass.getClass().getSimpleName());
			throw new CommonException("非法ID类型：" + idClass.getClass().getSimpleName());
		}
	}

	@Override
	public int clear(Model cnd) {
		// 查询条件
		Criteria cri = criteriaCreator(cnd);
		// 删除
		return dao.clear(beanClass, cri);
	}

	@Override
	public int updateById(Model model, Boolean ignoreNull) {
		Bean bean = copyModel2Bean(model);
		if (ignoreNull != null && !ignoreNull) {
			return dao.update(bean);
		} else {
			return dao.updateIgnoreNull(bean);
		}
	}

	@Override
	public int updateById(List<Model> models, Boolean ignoreNull) {
		List<Bean> beans = copyModels2Beans(models);
		if (ignoreNull != null && !ignoreNull) {
			return dao.update(beans);
		} else {
			return dao.updateIgnoreNull(beans);
		}
	}

	@Override
	public int update(Model chain, Model cnd) {
		// 查询条件
		Criteria cri = criteriaCreator(cnd);
		Chain cha = Chain.from(copyModel2Bean(chain), FieldMatcher.create(true));
		return dao.update(beanClass, cha, cri);
	}

	/**
	 * 创建查询条件
	 * 
	 * @param model
	 * @return
	 */
	protected Criteria criteriaCreator(Model cnd) {
		Bean bean = copyModel2Bean(cnd);
		return Cnd.from(dao, bean, FieldMatcher.create(false));
	}

	/**
	 * 创建排序信息
	 * 
	 * @param model
	 * @return
	 */
	protected void orderByCreator(Model cnd, Criteria cri) {
		// 排序信息
		if (cnd.getOrderByClause() != null && cnd.getOrderByClause().length > 0) {
			OrderBy orderBy = cri.getOrderBy();
			for (String orderByField : cnd.getOrderByClause()) {
				if (orderByField.startsWith("-")) {
					orderBy.desc(orderByField.substring(1));
				} else if (orderByField.startsWith("+")) {
					orderBy.asc(orderByField.substring(1));
				} else {
					orderBy.asc(orderByField);
				}
			}
		}
	}

}
