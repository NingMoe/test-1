package org.flyingmemory.service.imple;

import org.flyingmemory.beans.user.TblWeChatUser;
import org.flyingmemory.dao.iface.WeChatUserDAO;

/**
 * Title:核心服务类
 * 
 * Description:
 * 
 * Copyright: Copyright (c) 2013-12-01
 * 
 * Company: Shanghai allinfinance Co., Ltd.
 * 
 * author: 徐鹏飞
 *  
 * time: 2015年3月3日下午5:09:15
 * 
 * version: 1.0
 */
public class TestService implements org.flyingmemory.service.iface.TestService {
	
	private WeChatUserDAO weChatUserDAO;
	
	@Override
	public String addUser(TblWeChatUser user) {
		// TODO Auto-generated method stub
    	weChatUserDAO.save(user);
        
	    return "success"; 
	}

	/* (non-Javadoc)
	 * @see org.flyingmemory.service.iface.TestService#checkUser(java.lang.String)
	 */
	@Override
	public boolean checkUser(String username) {
		// TODO Auto-generated method stub
		if(weChatUserDAO.get(username) == null){
			return false;
        }
		return true;
	}

	/* (non-Javadoc)
	 * @see org.flyingmemory.service.iface.TestService#getUser(java.lang.String)
	 */
	@Override
	public TblWeChatUser getUser(String username) {
		// TODO Auto-generated method stub
		if(weChatUserDAO.get(username) == null){
			return null;
        }
		return weChatUserDAO.get(username);
	}

	/**
	 * @return the weChatUserDAO
	 */
	public WeChatUserDAO getWeChatUserDAO() {
		return weChatUserDAO;
	}

	/**
	 * @param weChatUserDAO the weChatUserDAO to set
	 */
	public void setWeChatUserDAO(WeChatUserDAO weChatUserDAO) {
		this.weChatUserDAO = weChatUserDAO;
	}
	
}