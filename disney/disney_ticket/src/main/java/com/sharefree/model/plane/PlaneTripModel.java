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

	// 出发机场
	private String departAirportCode;

	// 到达机场
	private String arriveAirportCode;

	// 出发到达时间
	private Long takeOffTime;

	private Long departTime;

	private Long arriveTime;

	private String flightNo;// 航班号

	private String airlineCode;

	// 共享航班信息
	private String cabin;

	public String getDepartAirportCode() {
		return departAirportCode;
	}

	public void setDepartAirportCode(String departAirportCode) {
		this.departAirportCode = departAirportCode;
	}

	public String getArriveAirportCode() {
		return arriveAirportCode;
	}

	public void setArriveAirportCode(String arriveAirportCode) {
		this.arriveAirportCode = arriveAirportCode;
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
