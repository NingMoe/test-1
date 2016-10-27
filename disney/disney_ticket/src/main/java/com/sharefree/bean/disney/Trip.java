package com.sharefree.bean.disney;

import java.io.Serializable;

import org.nutz.dao.entity.annotation.Column;
import org.nutz.dao.entity.annotation.Id;
import org.nutz.dao.entity.annotation.Table;

@Table(value = "trip")
public class Trip implements Serializable {

	private static final long serialVersionUID = 1L;

	@Id
	private Long tripId;

	@Column
	private String departAirportCode;

	@Column
	private String arriveAirportCode;

	@Column
	private String airlineCode;

	@Column
	private String flightNo;

	@Column
	private String DepartTime;

	@Column
	private String ArriveTime;

	@Column
	private String cabinArray;

	public Long getTripId() {
		return tripId;
	}

	public void setTripId(Long tripId) {
		this.tripId = tripId;
	}

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

	public String getAirlineCode() {
		return airlineCode;
	}

	public void setAirlineCode(String airlineCode) {
		this.airlineCode = airlineCode;
	}

	public String getFlightNo() {
		return flightNo;
	}

	public void setFlightNo(String flightNo) {
		this.flightNo = flightNo;
	}

	public String getDepartTime() {
		return DepartTime;
	}

	public void setDepartTime(String departTime) {
		DepartTime = departTime;
	}

	public String getArriveTime() {
		return ArriveTime;
	}

	public void setArriveTime(String arriveTime) {
		ArriveTime = arriveTime;
	}

	public String getCabinArray() {
		return cabinArray;
	}

	public void setCabinArray(String cabinArray) {
		this.cabinArray = cabinArray;
	}

}