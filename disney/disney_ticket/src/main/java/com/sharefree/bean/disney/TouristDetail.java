package com.sharefree.bean.disney;

import java.io.Serializable;
import java.util.Date;

import org.nutz.dao.entity.annotation.Column;
import org.nutz.dao.entity.annotation.Id;
import org.nutz.dao.entity.annotation.Readonly;
import org.nutz.dao.entity.annotation.Table;

@Table(value = "tourist_detail")
public class TouristDetail implements Serializable {

	private static final long serialVersionUID = 1L;

	@Id
	private Long touristId;

	@Column
	private Long orderId;

	@Column
	private String orderNo;

	@Column
	private Date visitDate;

	@Column
	private String touristName;

	@Column
	private String idcType;

	@Column
	private String idcNo;

	@Column
	private String telephone;

	@Column
	private String email;

	@Column
	private String status;

	@Column
	private Date importTime;

	@Column
	private Long importOptId;

	@Column
	@Readonly
	private Integer ticketingNum;

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

	public Integer getTicketingNum() {
		return ticketingNum;
	}

	public void setTicketingNum(Integer ticketingNum) {
		this.ticketingNum = ticketingNum;
	}

}
