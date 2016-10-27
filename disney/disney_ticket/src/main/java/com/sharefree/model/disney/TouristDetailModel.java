package com.sharefree.model.disney;

import java.io.Serializable;
import java.util.Date;

import org.nutz.json.JsonField;

import com.sharefree.constant.DisneyConst;
import com.sharefree.model.BaseModel;

public class TouristDetailModel extends BaseModel implements Serializable {

	private static final long serialVersionUID = 1L;

	private Long touristId;

	private Long orderId;

	private String orderNo;

	@JsonField(dataFormat = "yyyy-MM-dd")
	private Date visitDate;

	private String touristName;

	private String idcType;

	private String idcNo;

	private String telephone;

	private String email;

	private String status;

	private Date importTime;

	private Long importOptId;

	// 增量数据
	private Integer ticketingNum;

	private Integer ticketLeftNum;

	public Integer getTicketingNum() {
		return ticketingNum;
	}

	public void setTicketingNum(Integer ticketingNum) {
		this.ticketingNum = ticketingNum;
		this.ticketLeftNum = DisneyConst.TICKET_NUM_MAX - ticketingNum;
	}

	public Integer getTicketLeftNum() {
		return ticketLeftNum;
	}

	public void setTicketLeftNum(Integer ticketLeftNum) {
		this.ticketLeftNum = ticketLeftNum;
		this.ticketingNum = DisneyConst.TICKET_NUM_MAX - ticketLeftNum;
		;
	}

	public Long getTouristId() {
		return touristId;
	}

	public void setTouristId(Long touristId) {
		this.touristId = touristId;
	}

	public Long getOrderId() {
		return orderId;
	}

	public void setOrderId(Long orderId) {
		this.orderId = orderId;
	}

	public String getOrderNo() {
		return orderNo;
	}

	public void setOrderNo(String orderNo) {
		this.orderNo = orderNo;
	}

	public Date getVisitDate() {
		return visitDate;
	}

	public void setVisitDate(Date visitDate) {
		this.visitDate = visitDate;
	}

	public String getTouristName() {
		return touristName;
	}

	public void setTouristName(String touristName) {
		this.touristName = touristName;
	}

	public String getIdcType() {
		return idcType;
	}

	public void setIdcType(String idcType) {
		this.idcType = idcType;
	}

	public String getIdcNo() {
		return idcNo;
	}

	public void setIdcNo(String idcNo) {
		this.idcNo = idcNo;
	}

	public String getTelephone() {
		return telephone;
	}

	public void setTelephone(String telephone) {
		this.telephone = telephone;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public Date getImportTime() {
		return importTime;
	}

	public void setImportTime(Date importTime) {
		this.importTime = importTime;
	}

	public Long getImportOptId() {
		return importOptId;
	}

	public void setImportOptId(Long importOptId) {
		this.importOptId = importOptId;
	}

}