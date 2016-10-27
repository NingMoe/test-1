package com.sharefree.bean.disney;

import java.io.Serializable;
import java.util.Date;

import org.nutz.dao.entity.annotation.Column;
import org.nutz.dao.entity.annotation.Id;
import org.nutz.dao.entity.annotation.Name;
import org.nutz.dao.entity.annotation.Table;

@Table(value = "occupy_detail")
public class OccupyDetail implements Serializable {

	private static final long serialVersionUID = 1L;

	@Id
	private Long occupyId;

	@Name
	private String pnr;

	@Column
	private String bigPnr;

	@Column
	private Long orderId;

	@Column
	private String orderNo;

	@Column
	private Date visitDate;

	@Column
	private String occupyName;

	@Column
	private String idcType;

	@Column
	private String idcNo;

	@Column
	private String telephone;

	@Column
	private String email;

	@Column
	private String contactName;

	@Column
	private String contactTel;

	@Column
	private String contactEmail;

	@Column
	private Integer occupyNum;

	@Column
	private String status;

	@Column
	private String platOrderNo;

	@Column
	private Date occupyTime;

	@Column
	private Date cancelTime;

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
