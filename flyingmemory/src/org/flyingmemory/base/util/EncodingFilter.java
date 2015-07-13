package org.flyingmemory.base.util;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;

/**
 * Title:字符集过滤器
 * 
 * Description:
 * 
 * Copyright: Copyright (c) 2010-3-8
 * 
 * @version 1.0
 */
public class EncodingFilter implements Filter {
	
	protected String encoding = null;
	protected FilterConfig filterConfig = null;
	
	public void init(FilterConfig filterConfig) throws ServletException {
		this.filterConfig = filterConfig;
	    this.encoding = filterConfig.getInitParameter("encoding");
	}

	
	public void doFilter(ServletRequest request, ServletResponse response,
			FilterChain chain) throws IOException, ServletException {
			request.setCharacterEncoding(encoding);
			response.setCharacterEncoding(encoding);
		chain.doFilter(request, response);
	}
	
	public void destroy() {
		this.encoding = null;
	    this.filterConfig = null;
	}
	
}
