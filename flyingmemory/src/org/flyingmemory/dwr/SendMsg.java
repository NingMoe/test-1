package org.flyingmemory.dwr;

import java.util.Collection;

import javax.servlet.http.HttpSession;

import org.directwebremoting.ScriptBuffer;
import org.directwebremoting.ScriptSession;
import org.directwebremoting.WebContext;
import org.directwebremoting.WebContextFactory;
import org.directwebremoting.proxy.dwr.Util;
import org.flyingmemory.base.Constants;
import org.flyingmemory.base.util.JSONBean;
import org.flyingmemory.beans.user.TblWeChatUser;
import org.flyingmemory.system.util.CommonUtil;

public class SendMsg {
	
	@SuppressWarnings("unchecked")
	public void sendMsg(String msg){
		
//		获得DWR上下文
		WebContext webContext = WebContextFactory.get();

//		获取当前页面的URL
		String currentPage = webContext.getCurrentPage();

//		当前脚本session
		HttpSession session = webContext.getSession();
		
		TblWeChatUser user = (TblWeChatUser) session.getAttribute(Constants.USER_INFO);
//		将数据封装
		JSONBean jsonBean = new JSONBean();
		jsonBean.addJSONElement(Constants.TIME_INFO, CommonUtil.getCurrentDateTimeZHCN());
		jsonBean.addJSONElement(Constants.USER_NAME, user.getUserName());
		jsonBean.addJSONElement(Constants.PROMPT_MSG, msg);
		
//		获取所有浏览但前页面的脚本session
		Collection<ScriptSession> sessions = webContext.getScriptSessionsByPage(currentPage);
		
		
		
//		封装所有要推送到的页面
		Util util = new Util(sessions);
		
//		下面是创建一个javascript脚本，相当于在页面脚本中添加了一句show(msg); 
		ScriptBuffer sb = new ScriptBuffer();
		sb.appendScript("show(");
		sb.appendData(jsonBean.toString());
		sb.appendScript(")");
		
//		推送
		util.addScript(sb);
	}
}

