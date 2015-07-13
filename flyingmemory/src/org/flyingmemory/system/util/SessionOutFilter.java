package org.flyingmemory.system.util;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.flyingmemory.base.Constants;
import org.flyingmemory.beans.user.TblWeChatUser;

/**
 * Title:
 * 
 * Description:
 * 
 * Copyright: Copyright (c) 2014-2-8
 * 
 * 
 * @version 1.0
 */
public class SessionOutFilter implements Filter{

	/* (non-Javadoc)
	 * @see javax.servlet.Filter#destroy()
	 */
	@Override
	public void destroy() {
		// TODO Auto-generated method stub
		
	}

	/* (non-Javadoc)
	 * @see javax.servlet.Filter#doFilter(javax.servlet.ServletRequest, javax.servlet.ServletResponse, javax.servlet.FilterChain)
	 */
	@Override
	public void doFilter(ServletRequest arg0, ServletResponse arg1,
			FilterChain arg2) throws IOException, ServletException {
		// TODO Auto-generated method stub
		HttpServletRequest request = (HttpServletRequest)arg0;
		HttpServletResponse response = (HttpServletResponse)arg1;
		TblWeChatUser user = (TblWeChatUser) request.getSession().getAttribute(Constants.USER_INFO);

		if(user==null){
			System.out.println("************ Filter: sessionOutFilter ***********");
			//如果是session超时，在此处做处理
			response.sendRedirect(request.getContextPath());
			return;
		}
		arg2.doFilter(request, response);
	}

	/* (non-Javadoc)
	 * @see javax.servlet.Filter#init(javax.servlet.FilterConfig)
	 */
	@Override
	public void init(FilterConfig arg0) throws ServletException {
		// TODO Auto-generated method stub
		
	}

}
