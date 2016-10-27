package com.sharefree.utils.view;

import org.nutz.ioc.Ioc;
import org.nutz.json.Json;
import org.nutz.json.JsonFormat;
import org.nutz.mvc.View;
import org.nutz.mvc.ViewMaker;

import com.sharefree.utils.StringUtil;

/**
 * Desc:自定义视图的Maker类
 * 
 * @author luopan
 *
 */
public class ResultViewMaker implements ViewMaker {

	/** 异常视图 */
	public static final String VIEW_TYPE_EXCEPTION = "exception";

	/** 成功视图 */
	public static final String VIEW_TYPE_SUCCESS = "success";

	/** Json默认输出的格式 */
	public static JsonFormat format = Json.fromJson(JsonFormat.class, "{quoteName:true, ignoreNull:true}");

	@Override
	public View make(Ioc ioc, String type, String value) {
		// 设置Json默认输出格式
		JsonFormat currentFormat = format;
		
		if (StringUtil.isNotEmpty(value)){	// 自定义Json输出格式
			// 保证格式化数据
			value = Json.toJson(value);
			currentFormat = Json.fromJson(JsonFormat.class, value);
		}
		// 选择视图
		type = type.toLowerCase();
		if (VIEW_TYPE_EXCEPTION.equals(type)) // 异常
			return new ExceptionView(currentFormat);
		else if (VIEW_TYPE_SUCCESS.equals(type)) // 成功
			return new SuccessView(currentFormat);
		return null;
	}
}
