package com.sharefree.model.ctrip;

import java.io.Serializable;
import java.util.Date;

/**
 * 
 * @author Sun
 * @version 2015年10月26日
 */
public class PlaneODModel implements Serializable {

	private static final long serialVersionUID = 1L;

	// 出发城市
	private String departCityCode;

	// 到达城市
	private String arriveCityCode;

	// 出发时间
	private Date departTime;

	public String getDepartCityCode() {
		return departCityCode;
	}

	public void setDepartCityCode(String departCityCode) {
		this.departCityCode = departCityCode;
	}

	public String getArriveCityCode() {
		return arriveCityCode;
	}

	public void setArriveCityCode(String arriveCityCode) {
		this.arriveCityCode = arriveCityCode;
	}

	public Date getDepartTime() {
		return departTime;
	}

	public void setDepartTime(Date departTime) {
		this.departTime = departTime;
	}

}
