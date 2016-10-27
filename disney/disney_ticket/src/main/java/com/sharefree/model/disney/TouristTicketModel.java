package com.sharefree.model.disney;

import java.io.Serializable;
import java.util.Date;

import org.nutz.json.JsonField;

import com.sharefree.model.BaseModel;
import com.sharefree.utils.DateUtil;

public class TouristTicketModel extends BaseModel implements Serializable {

	private static final long serialVersionUID = 1L;

	private Long ticketId;

	private Long orderId;

	private String orderNo;

	@JsonField(dataFormat = "yyyy-MM-dd")
	private Date visitDate;

	private Long touristId;

	private String contactName;

	private String contactTel;

	private String contactEmail;

	private String pnr;

	private String bigPnr;

	private String platOrderNo;

	private String planeTicketNo;

	private Date ticketingTime;

	private Long ticketingOptId;

	private String glaCode;

	private String status;

	private Date createTime;

	private Long createOptId;

	// 条件
	private Date visitDateF;

	private Date visitDateT;

	private Integer visitNum;

	private String[] statusIn;

	public String[] getStatusIn() {
		return statusIn;
	}

	public void setStatusIn(String[] statusIn) {
		this.statusIn = statusIn;
	}

	public Integer getVisitNum() {
		return visitNum;
	}

	public void setVisitNum(Integer visitNum) {
		this.visitNum = visitNum;
	}

	public Date getVisitDateF() {
		return visitDateF;
	}

	public void setVisitDateF(Date visitDateF) {
		this.visitDateF = visitDateF;
	}

	public Date getVisitDateT() {
		return visitDateT;
	}

	public void setVisitDateT(Date visitDateT) {
		this.visitDateT = DateUtil.addOneDay(visitDateT);
	}

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

}