package org.flyingmemory.dao.iface;

import org.hibernate.HibernateException;
import org.flyingmemory.beans.user.TblWeChatUser;

public interface WeChatUserDAO {

	public TblWeChatUser get(String key) throws HibernateException;

	public void save(TblWeChatUser user) throws HibernateException;

}
