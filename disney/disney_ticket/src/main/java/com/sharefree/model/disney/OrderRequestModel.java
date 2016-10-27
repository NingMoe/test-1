package com.sharefree.model.disney;

import java.io.Serializable;

import com.sharefree.constant.DisneyConst;
import com.sharefree.model.BaseModel;

public class OrderRequestModel extends BaseModel implements Serializable {

	private static final long serialVersionUID = 1L;

	// step 1
	private String pnr_name;

	private String freightNo;

	// step 2
	private String ticketPrice;

	private String totalTaxes;

	private String totalCosts;

	private String pNum;

	private String allTouristInfo;

	private String totalSaleNum;

	private String[] parkDate;

	private String contact_name;

	private String contact_mobile;

	private String contact_email;

	public OrderRequestModel() {
		this.freightNo = DisneyConst.CRAWLER_SERVICE_PATAM_FREIGHTNO;
		this.pNum = "3";
		this.totalSaleNum = "";
	}

	public String getPnr_name() {
		return pnr_name;
	}

	public void setPnr_name(String pnr_name) {
		this.pnr_name = pnr_name;
	}

	public String getFreightNo() {
		return freightNo;
	}

	public void setFreightNo(String freightNo) {
		this.freightNo = freightNo;
	}

	public String getTicketPrice() {
		return ticketPrice;
	}

	public void setTicketPrice(String ticketPrice) {
		this.ticketPrice = ticketPrice;
	}

	public String getTotalTaxes() {
		return totalTaxes;
	}

	public void setTotalTaxes(String totalTaxes) {
		this.totalTaxes = totalTaxes;
	}

	public String getTotalCosts() {
		return totalCosts;
	}

	public void setTotalCosts(String totalCosts) {
		this.totalCosts = totalCosts;
	}

	public String getpNum() {
		return pNum;
	}

	public void setpNum(String pNum) {
		this.pNum = pNum;
	}

	public String getAllTouristInfo() {
		return allTouristInfo;
	}

	public void setAllTouristInfo(String allTouristInfo) {
		this.allTouristInfo = allTouristInfo;
	}

	public String getTotalSaleNum() {
		return totalSaleNum;
	}

	public void setTotalSaleNum(String totalSaleNum) {
		this.totalSaleNum = totalSaleNum;
	}

	public String[] getParkDate() {
		return parkDate;
	}

	public void setParkDate(String[] parkDate) {
		this.parkDate = parkDate;
	}

	public String getContact_name() {
		return contact_name;
	}

	public void setContact_name(String contact_name) {
		this.contact_name = contact_name;
	}

	public String getContact_mobile() {
		return contact_mobile;
	}

	public void setContact_mobile(String contact_mobile) {
		this.contact_mobile = contact_mobile;
	}

	public String getContact_email() {
		return contact_email;
	}

	public void setContact_email(String contact_email) {
		this.contact_email = contact_email;
	}

}