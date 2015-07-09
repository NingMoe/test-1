package org.flyingmemory.dao.imple;

import org.hibernate.HibernateException;
import org.springframework.orm.hibernate3.support.HibernateDaoSupport;
import org.flyingmemory.beans.user.TblWeChatUser;

public class WeChatUserDAO extends HibernateDaoSupport implements org.flyingmemory.dao.iface.WeChatUserDAO {

	public Class<TblWeChatUser> getReferenceClass () {
		return TblWeChatUser.class;
	}
	
	/* (non-Javadoc)
	 * @see org.flyingmemory.dao.iface.UserDoIface#get(java.lang.String)
	 */
	@Override
	public TblWeChatUser get(String key) {
		// TODO Auto-generated method stub
		return (TblWeChatUser) getHibernateTemplate().get(getReferenceClass(), key);
	}

	@Override
	public void save(TblWeChatUser user) throws HibernateException {
		getHibernateTemplate().save(user);
	}

}
