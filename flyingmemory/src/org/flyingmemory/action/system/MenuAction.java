package org.flyingmemory.action.system;

import java.util.List;

import org.flyingmemory.base.util.ContextUtil;
import org.flyingmemory.beans.system.TblMenuInfo;
import org.flyingmemory.service.iface.MenuService;


/**
 * 
 * Title: 菜单查询维护
 * 
 * Description: 针对主页菜单的查询维护
 * 
 * Copyright: Copyright (c) 2013-12-01
 * 
 * Company: Shanghai allinfinance Co., Ltd.
 * 
 * author: 徐鹏飞
 *  
 * time: 2015年4月3日下午2:30:49
 * 
 * version: 1.0
 */
public class MenuAction extends BaseAction {

	private static final long serialVersionUID = -6231788474659550252L;

	private MenuService menuService = (MenuService) ContextUtil.getBean("MenuService");	
	
	@Override
	protected void subExecute() throws Exception {
		List<TblMenuInfo> allMenu = menuService.getAllMenu();
		if(allMenu != null){
			setSessionAttribute("allMenu",allMenu);
/*			JSONBean jsonBean = new JSONBean();
			jsonBean.addJSONElement(Constants.SUCCESS_HEADER, true);
			jsonBean.addJSONElement("allMenu", allMenu);
			writeMessage(jsonBean.toString());*/  
		}
	}

}
