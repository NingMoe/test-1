package org.flyingmemory.message.req;

/**
 * Title:地理位置消息 
 * 
 * Description:
 * 
 * Copyright: Copyright (c) 2013-12-01
 * 
 * Company: Shanghai allinfinance Co., Ltd.
 * 
 * author: 徐鹏飞
 *  
 * time: 2015年3月3日下午4:21:17
 * 
 * version: 1.0
 */
public class LocationMessage extends BaseMessage {
	// 地理位置维度
	private String Location_X;
	// 地理位置经度
	private String Location_Y;
	// 地图缩放大小
	private String Scale;
	// 地理位置信息
	private String Label;

	public String getLocation_X() {
		return Location_X;
	}

	public void setLocation_X(String location_X) {
		Location_X = location_X;
	}

	public String getLocation_Y() {
		return Location_Y;
	}

	public void setLocation_Y(String location_Y) {
		Location_Y = location_Y;
	}

	public String getScale() {
		return Scale;
	}

	public void setScale(String scale) {
		Scale = scale;
	}

	public String getLabel() {
		return Label;
	}

	public void setLabel(String label) {
		Label = label;
	}
} 
