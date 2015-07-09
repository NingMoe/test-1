package org.flyingmemory.dao.iface;

import java.util.List;

public interface TblMenuInfoDAO {

	@SuppressWarnings("rawtypes")
	public List findByHQLQuery(final String hql);
}
