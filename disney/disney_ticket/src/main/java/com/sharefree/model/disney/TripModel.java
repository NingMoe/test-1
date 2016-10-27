package com.sharefree.model.disney;

import java.io.Serializable;

import com.sharefree.model.BaseModel;

public class TripModel extends BaseModel implements Serializable {

	private static final long serialVersionUID = 1L;

	private Long tripId;

	private String departAirportCode;

	private String arriveAirportCode;

	private String airlineCode;

	private String flightNo;

	private String DepartTime;

	private String ArriveTime;

	private String cabinArray;

	// 条件
	private Long rowId;

	public Long getRowId() {
		return rowId;
	}

	public void setRowId(Long rowId) {
		this.rowId = rowId;
	}

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