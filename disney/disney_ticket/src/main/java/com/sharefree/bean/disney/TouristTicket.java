package com.sharefree.bean.disney;

import java.io.Serializable;
import java.util.Date;

import org.nutz.dao.entity.annotation.Column;
import org.nutz.dao.entity.annotation.Id;
import org.nutz.dao.entity.annotation.Readonly;
import org.nutz.dao.entity.annotation.Table;

@Table(value = "tourist_ticket")
public class TouristTicket implements Serializable {

	private static final long serialVersionUID = 1L;

	@Id
	private Long ticketId;

	@Column
	private Long orderId;

	@Column
	private String orderNo;

	@Column
	private Date visitDate;

	@Column
	private Long touristId;

	@Column
	private String contactName;

	@Column
	private String contactTel;

	@Column
	private String contactEmail;

	@Column
	private String pnr;

	@Column
	private String bigPnr;

	@Column
	private String platOrderNo;

	@Column
	private String planeTicketNo;

	@Column
	private Date ticketingTime;

	@Column
	private Long ticketingOptId;

	@Column
	private String glaCode;

	@Column
	private String status;

	@Column
	private Date createTime;

	@Column
	private Long createOptId;

	@Column
	@Readonly
	private Integer visitNum;

	public Long getTicketId() {
		return ticketId;
	}

	public void setTicketId(Long ticketId) {
		this.ticketId = ticketId;
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

	public Long getTouristId() {
		return touristId;
	}

	public void setTouristId(Long touristId) {
		this.touristId = touristId;
	}

	public String getContactName() {
		return contactName;
	}

	public void setContactName(String contactName) {
		this.contactName = contactName;
	}

	public String getContactTel() {
		return contactTel;
	}

	public void setContactTel(String contactTel) {
		this.contactTel = contactTel;
	}

	public String getContactEmail() {
		return contactEmail;
	}

	public void setContactEmail(String contactEmail) {
		this.contactEmail = contactEmail;
	}

	public String getPnr() {
		return pnr;
	}

	public void setPnr(String pnr) {
		this.pnr = pnr;
	}

	public String getBigPnr() {
		return bigPnr;
	}

	public void setBigPnr(String bigPnr) {
		this.bigPnr = bigPnr;
	}

	public String getPlatOrderNo() {
		return platOrderNo;
	}

	public void setPlatOrderNo(String platOrderNo) {
		this.platOrderNo = platOrderNo;
	}

	public String getPlaneTicketNo() {
		return planeTicketNo;
	}

	public void setPlaneTicketNo(String planeTicketNo) {
		this.planeTicketNo = planeTicketNo;
	}

	public Date getTicketingTime() {
		return ticketingTime;
	}

	public void setTicketingTime(Date ticketingTime) {
		this.ticketingTime = ticketingTime;
	}

	public Long getTicketingOptId() {
		return ticketingOptId;
	}

	public void setTicketingOptId(Long ticketingOptId) {
		this.ticketingOptId = ticketingOptId;
	}

	public String getGlaCode() {
		return glaCode;
	}

	public void setGlaCode(String glaCode) {
		this.glaCode = glaCode;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public Date getCreateTime() {
		return createTime;
	}

	public void setCreateTime(Date createTime) {
		this.createTime = createTime;
	}

	public Long getCreateOptId() {
		return createOptId;
	}

	public void setCreateOptId(Long createOptId) {
		this.createOptId = createOptId;
	}

	public Integer getVisitNum() {
		return visitNum;
	}

	public void setVisitNum(Integer visitNum) {
		this.visitNum = visitNum;
	}

}