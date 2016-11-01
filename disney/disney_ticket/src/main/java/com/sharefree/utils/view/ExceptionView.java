package com.sharefree.utils.view;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.log4j.Logger;
import org.nutz.json.JsonFormat;
import org.nutz.mvc.Mvcs;
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

	private static Logger log = Logger.getLogger(ExceptionView.class);

	private JsonFormat format;

	private Object errorMsg;

	public ExceptionView(JsonFormat format) {
		this.format = format;
	}

	public ExceptionView(JsonFormat format, Object errorMsg) {
		this.format = format;
		this.errorMsg = errorMsg;
	}

	@Override
	public void render(HttpServletRequest req, HttpServletResponse resp, Object obj) throws Throwable {
		if (obj != null) {
			if (obj instanceof CommonException) {
				CommonException error = (CommonException) obj;
				obj = ResultRender.renderErrorResult("操作失败", error.getCustomMsg());
				log.error(error.getCustomMsg());
			} else if (obj instanceof Error) {
				Error error = (Error) obj;
				obj = ResultRender.renderErrorResult("操作失败", error.getMessage());
				log.error(error.getMessage());
			} else {
				Exception error = (Exception) obj;
				obj = ResultRender.renderErrorResult("操作失败", error.getMessage());
				log.error(error.getMessage());
			}
			Mvcs.write(resp, obj, format);
		} else if (errorMsg != null) {
			Mvcs.write(resp, ResultRender.renderErrorResult("操作失败", errorMsg), format);
		} else {
			Mvcs.write(resp, ResultRender.renderErrorResult("操作失败"), format);
		}
	}

}
