package com.sharefree.model.plane;

import java.io.Serializable;

import com.sharefree.model.BaseModel;

/**
 * 机票行程
 * 
 * @author Sun
 * @version 2015年10月26日
 */
public class PlaneTripModel extends BaseModel implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	// 出发城市
	private String departCityCode;

	private String departCityName;

	// 出发机场
	private String departAirportCode;

	private String departAirportName;

	// 到达城市
	private Long arriveCity;

	private String arriveCityName;

	// 到达机场
	private String arriveAirportCode;

	private String arriveAirportName;

	// 出发到达航站楼
	private String departAirportTower;

	private String arriveAirportTower;

	// 出发到达时间
	private Long takeOffTime;

	private Long departTime;

	private Long arriveTime;

	// 航班号
	private String flightNo;

	// 航司二字码
	private String airlineCode;

	// 舱位信息
	private String cabin;

	public String getDepartCityCode() {
		return departCityCode;
	}

	public void setDepartCityCode(String departCityCode) {
		this.departCityCode = departCityCode;
	}

	public String getDepartCityName() {
		return departCityName;
	}

	public void setDepartCityName(String departCityName) {
		this.departCityName = departCityName;
	}

	public String getDepartAirportCode() {
		return departAirportCode;
	}

	public void setDepartAirportCode(String departAirportCode) {
		this.departAirportCode = departAirportCode;
	}

	public String getDepartAirportName() {
		return departAirportName;
	}

	public void setDepartAirportName(String departAirportName) {
		this.departAirportName = departAirportName;
	}

	public Long getArriveCity() {
		return arriveCity;
	}

	public void setArriveCity(Long arriveCity) {
		this.arriveCity = arriveCity;
	}

	public String getArriveCityName() {
		return arriveCityName;
	}

	public void setArriveCityName(String arriveCityName) {
		this.arriveCityName = arriveCityName;
	}

	public String getArriveAirportCode() {
		return arriveAirportCode;
	}

	public void setArriveAirportCode(String arriveAirportCode) {
		this.arriveAirportCode = arriveAirportCode;
	}

	public String getArriveAirportName() {
		return arriveAirportName;
	}

	public void setArriveAirportName(String arriveAirportName) {
		this.arriveAirportName = arriveAirportName;
	}

	public String getDepartAirportTower() {
		return departAirportTower;
	}

	public void setDepartAirportTower(String departAirportTower) {
		this.departAirportTower = departAirportTower;
	}

	public String getArriveAirportTower() {
		return arriveAirportTower;
	}

	public void setArriveAirportTower(String arriveAirportTower) {
		this.arriveAirportTower = arriveAirportTower;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

	public Long getTakeOffTime() {
		return takeOffTime;
	}

	public void setTakeOffTime(Long takeOffTime) {
		this.takeOffTime = takeOffTime;
	}

	public Long getDepartTime() {
		return departTime;
	}

	public void setDepartTime(Long departTime) {
		this.departTime = departTime;
	}

	public Long getArriveTime() {
		return arriveTime;
	}

	public void setArriveTime(Long arriveTime) {
		this.arriveTime = arriveTime;
	}

	public String getFlightNo() {
		return flightNo;
	}

	public void setFlightNo(String flightNo) {
		this.flightNo = flightNo;
	}

	public String getAirlineCode() {
		return airlineCode;
	}

	public void setAirlineCode(String airlineCode) {
		this.airlineCode = airlineCode;
	}

	public String getCabin() {
		return cabin;
	}

	public void setCabin(String cabin) {
		this.cabin = cabin;
	}

}
