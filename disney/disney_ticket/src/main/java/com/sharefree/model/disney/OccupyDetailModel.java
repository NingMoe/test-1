package com.sharefree.model.disney;

import java.io.Serializable;
import java.util.Date;

import org.nutz.json.JsonField;

import com.sharefree.model.BaseModel;
import com.sharefree.utils.DateUtil;

public class OccupyDetailModel extends BaseModel implements Serializable {

	private static final long serialVersionUID = 1L;

	private Long occupyId;

	private String pnr;

	// 航司大编码
	private String bigPnr;

	private Long orderId;

	private String orderNo;

	@JsonField(dataFormat = "yyyy-MM-dd")
	private Date visitDate;

	private String occupyName;

	private String idcType;

	private String idcNo;

	private String telephone;

	private String email;

	private String contactName;

	private String contactTel;

	private String contactEmail;

	private Integer occupyNum;

	private String status;

	private String platOrderNo;

	private Date occupyTime;

	private Date cancelTime;

	// 条件
	private Date visitDateF;

	private Date visitDateT;

	private String[] statusIn;

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

	public String[] getStatusIn() {
		return statusIn;
	}

	public void setStatusIn(String[] statusIn) {
		this.statusIn = statusIn;
	}

	public Long getOccupyId() {
		return occupyId;
	}

	public void setOccupyId(Long occupyId) {
		this.occupyId = occupyId;
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

	public String getOccupyName() {
		return occupyName;
	}

	public void setOccupyName(String occupyName) {
		this.occupyName = occupyName;
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

	public Integer getOccupyNum() {
		return occupyNum;
	}

	public void setOccupyNum(Integer occupyNum) {
		this.occupyNum = occupyNum;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public String getPlatOrderNo() {
		return platOrderNo;
	}

	public void setPlatOrderNo(String platOrderNo) {
		this.platOrderNo = platOrderNo;
	}

	public Date getOccupyTime() {
		return occupyTime;
	}

	public void setOccupyTime(Date occupyTime) {
		this.occupyTime = occupyTime;
	}

	public Date getCancelTime() {
		return cancelTime;
	}

	public void setCancelTime(Date cancelTime) {
		this.cancelTime = cancelTime;
	}

}