package org.flyingmemory.service.imple;

import java.util.List;

import org.flyingmemory.beans.system.TblMenuInfo;
import org.flyingmemory.dao.iface.TblMenuInfoDAO;

/**
 * 
 * Title: 菜单查询维护类
 * 
 * Description: 针对主页菜单的查询维护
 * 
 * Copyright: Copyright (c) 2013-12-01
 * 
 * Company: Shanghai allinfinance Co., Ltd.
 * 
 * author: 徐鹏飞
 *  
 * time: 2015年4月3日下午1:50:40
 * 
 * version: 1.0
 */
public class MenuService implements org.flyingmemory.service.iface.MenuService {
	
	private TblMenuInfoDAO tblMenuInfoDAO;
	/* (non-Javadoc)
	 * @see org.flyingmemory.service.iface.MenuService#getAllMenu()
	 */
	@Override
	@SuppressWarnings("unchecked")
	public List<TblMenuInfo> getAllMenu() {
		String hql = "from TblMenuInfo m order by m.menuId";
		return (List<TblMenuInfo>)tblMenuInfoDAO.findByHQLQuery(hql);
	}
	/**
	 * @return the tblMenuInfoDAO
	 */
	public TblMenuInfoDAO getTblMenuInfoDAO() {
		return tblMenuInfoDAO;
	}
	/**
	 * @param tblMenuInfoDAO the tblMenuInfoDAO to set
	 */
	public void setTblMenuInfoDAO(TblMenuInfoDAO tblMenuInfoDAO) {
		this.tblMenuInfoDAO = tblMenuInfoDAO;
	}
	
}