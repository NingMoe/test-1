package org.flyingmemory.service.imple;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Map;

import org.flyingmemory.beans.user.TblWeChatUser;
import org.flyingmemory.dao.iface.WeChatUserDAO;
import org.flyingmemory.message.resp.Article;
import org.flyingmemory.message.resp.NewsMessage;
import org.flyingmemory.system.util.MessageUtil;

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
public class CoreService implements org.flyingmemory.service.iface.CoreService {
	
	private WeChatUserDAO weChatUserDAO;
	
	/** 
	* 处理微信发来的请求 
	*  
	* @param request 
	* @return 
	*/ 
	@Override
	public String processRequest(Map<String, String> requestMap) {
		// TODO Auto-generated method stub
		String respMessage = null;
	    try {
	
	        // 发送方帐号（open_id）
	        String fromUserName = requestMap.get("FromUserName");  
	        // 公众帐号  
	        String toUserName = requestMap.get("ToUserName");
	        
	        // 验证用户新旧
        	if(weChatUserDAO.get(fromUserName) == null){
  	      	  TblWeChatUser user = new TblWeChatUser();
  	      	  user.setUserId(fromUserName);
  	      	  weChatUserDAO.save(user);
        	}
	        
	        // 回复图文消息
	        NewsMessage newsMessage = new NewsMessage();
	        newsMessage.setToUserName(fromUserName);  
	        newsMessage.setFromUserName(toUserName);  
	        newsMessage.setCreateTime(new Date().getTime());  
	        newsMessage.setMsgType(MessageUtil.RESP_MESSAGE_TYPE_NEWS);  
	        newsMessage.setFuncFlag(0);
	        
	        Article article = new Article();
	        article.setTitle("成语接龙");
	        article.setDescription("成语接龙游戏规则成语接龙是中华民族传统的文字游戏。它已有悠久的历史,也有广泛的社会基础,是老少皆宜的民间文化娱乐活动!");
	        article.setPicUrl("http://flyingmemory-flyingmemory.stor.sinaapp.com/pictures/chengyujielong.jpg");
	        article.setUrl("http://flyingmemory.sinaapp.com/page/common/game/game_idiom.jsp");
	        
	        List<Article> articles = new ArrayList<Article>();
	        articles.add(article);
	        newsMessage.setArticles(articles);
	        newsMessage.setArticleCount(1);
	        
	        // 组织返回XML消息
	        respMessage = MessageUtil.newsMessageToXml(newsMessage);  
	    } catch (Exception e) {  
	        e.printStackTrace();  
	    }
	    return respMessage; 
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