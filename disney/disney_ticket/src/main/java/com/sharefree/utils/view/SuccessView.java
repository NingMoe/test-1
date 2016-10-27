package com.sharefree.utils.view;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.nutz.json.JsonFormat;
import org.nutz.mvc.Mvcs;
import org.nutz.mvc.View;

import com.sharefree.model.JsonResult;
import com.sharefree.model.ResultRender;

/**
 * Title: SuccessView
 *
 * Desc:成功视图，与@Ok配对，目的在于简化control中返回值操作。
 * 例如，一个insert操作，返回值可以定义为void，操作成功的话，直接会默认帮忙封装提示消息“操作成功！”。
 * 如果想自定义返回结果，只要返回一个CtrlResult实例即可。
 *
 * Company: LuoPan
 *
 * @author pfxu
 *
 * @date Mar 18, 2016
 *
 */
public class SuccessView implements View {

	private JsonFormat format;

	public SuccessView(JsonFormat format) {
		this.format = format;
	}

	@Override
	public void render(HttpServletRequest req, HttpServletResponse resp,
			Object obj) throws Throwable {
		if (obj != null) {
			if (obj instanceof JsonResult)
				// 直接返回当前数据
				Mvcs.write(resp, obj, format);
			else
				Mvcs.write(resp, ResultRender.renderResult("操作成功", obj), format);
		} else {
			Mvcs.write(resp, ResultRender.renderResult("操作成功"), format);
		}
	}

	public JsonFormat getFormat() {
		return format;
	}

	public void setFormat(JsonFormat format) {
		this.format = format;
	}

}
