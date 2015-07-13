package org.flyingmemory.service.iface;

import java.util.List;

import org.flyingmemory.beans.system.TblMenuInfo;

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
public interface MenuService {
	
	/**
	 * 查询所有菜单项
	 * 
	 * @param user
	 * @return
	 */
	public List<TblMenuInfo> getAllMenu();
	
}