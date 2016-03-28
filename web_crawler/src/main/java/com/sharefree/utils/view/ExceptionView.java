package com.sharefree.utils.view;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.nutz.mvc.View;

import com.sharefree.common.CommonException;
import com.sharefree.model.ResultRender;


/**
 * Title: ExceptionView
 *
 * Description:
 *
 * Company: LuoPan
 *
 * @author pfxu
 *
 * @date Mar 18, 2016
 *
 */
public class ExceptionView implements View {

	@Override
	public void render(HttpServletRequest req, HttpServletResponse resp,
			Object obj) throws Throwable {
		if(com.sharefree.common.CommonException.class.equals(obj.getClass())){
			CommonException e = (CommonException) obj;
			if ("401".equals(e.getExceptionMsg())) {
				resp.setStatus(401);
			}
			obj = ResultRender.renderErrorResult(e);
		}
		
	}

}
