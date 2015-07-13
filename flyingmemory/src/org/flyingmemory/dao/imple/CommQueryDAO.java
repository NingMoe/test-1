package org.flyingmemory.dao.imple;

import java.sql.SQLException;
import java.util.List;

import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.Session;
import org.springframework.orm.hibernate3.HibernateCallback;
import org.springframework.orm.hibernate3.support.HibernateDaoSupport;


/**
 * Title:通用查询
 * 
 * Description:
 * 
 * Copyright: Copyright (c) 2010-3-8
 * 
 * 
 * @version 1.0
 */
@SuppressWarnings("rawtypes")
public class CommQueryDAO extends HibernateDaoSupport implements org.flyingmemory.dao.iface.CommQueryDAO {

	@Override
	public List findBySQLQuery(final String sql) {
		List data = getHibernateTemplate().executeFind(new HibernateCallback() {
			
			public Object doInHibernate(Session session)
					throws HibernateException, SQLException {
				Query query = session.createSQLQuery(sql);
				return query.list();
			}
		});
		return data;
	}

	@Override
	public List findBySQLQuery(final String sql, final int begin, final int count) {
		return getHibernateTemplate().executeFind(new HibernateCallback() {
			
			public Object doInHibernate(Session session)
					throws HibernateException, SQLException {
				Query query = session.createSQLQuery(sql);
				if (begin >= 0) {
					query.setFirstResult(begin);
					query.setMaxResults(count);
				}
				return query.list();
			}
		});
	}

	@Override
	public void excute(final String sql) {
		getHibernateTemplate().execute(new HibernateCallback() {
			
			public Object doInHibernate(Session session)
					throws HibernateException, SQLException {
				session.getTransaction().begin();
				Query query = session.createSQLQuery(sql);
				int executeColum = query.executeUpdate();
				session.getTransaction().commit();
				return executeColum;
			}
		});
	}

	@Override
	public String findCountBySQLQuery(final String countSql) {
		List data = getHibernateTemplate().executeFind(new HibernateCallback() {
			
			public Object doInHibernate(Session session)
					throws HibernateException, SQLException {
				Query query = session.createSQLQuery(countSql);
				return query.list();
			}
		});
		return data.get(0).toString();
	}

	@Override
	public List findByHQLQuery(final String hql) {
		List data = getHibernateTemplate().executeFind(new HibernateCallback() {
			
			public Object doInHibernate(Session session)
					throws HibernateException, SQLException {
				Query query = session.createQuery(hql);
				return query.list();
			}
		});
		return data;
	}

	@Override
	public List findByHQLQuery(final String hql, final int begin, final int count) {
		return getHibernateTemplate().executeFind(new HibernateCallback() {
			public Object doInHibernate(Session session)
					throws HibernateException, SQLException {
				Query query = session.createQuery(hql);
				if (begin >= 0) {
					query.setFirstResult(begin);
					query.setMaxResults(count);
				}
				return query.list();
			}
		});
	}

	@Override
	public void flush() {
		getHibernateTemplate().flush();
	}
	
}
