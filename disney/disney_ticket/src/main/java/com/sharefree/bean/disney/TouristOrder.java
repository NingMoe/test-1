package com.sharefree.bean.disney;

import java.io.Serializable;
import java.util.Date;

import org.nutz.dao.entity.annotation.Column;
import org.nutz.dao.entity.annotation.Id;
import org.nutz.dao.entity.annotation.Name;
import org.nutz.dao.entity.annotation.Readonly;
import org.nutz.dao.entity.annotation.Table;

@Table(value = "tourist_order")
public class TouristOrder implements Serializable {

	private static final long serialVersionUID = 1L;

	@Id
	private Long orderId;

	@Name
	private String orderNo;

	@Column
	private Long customerId;

	@Column
	private String customerName;

	@Column
	private Date visitDate;

	@Column
	private Integer visitNum;

	@Column
	private Boolean isNeedOccupy;

	@Column
	private Integer needOccupyNum;

	@Column
	private Integer priority;

	@Column
	@Readonly
	private Integer occupyNum;

	@Column
	private Date crtTime;

	@Column
	private Long crtOptId;

	@Column
	private Date importTime;

	@Column
	private Long importOptId;

	@Column
	@Readonly
	private Integer ticketingNum;

	@Column
	private String status;

	@Column
	@Readonly
	private String showStatus;

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

	public Long getCustomerId() {
		return customerId;
	}

	public void setCustomerId(Long customerId) {
		this.customerId = customerId;
	}

	public String getCustomerName() {
		return customerName;
	}

	public void setCustomerName(String customerName) {
		this.customerName = customerName;
	}

	public Date getVisitDate() {
		return visitDate;
	}

	public void setVisitDate(Date visitDate) {
		this.visitDate = visitDate;
	}

	public Integer getVisitNum() {
		return visitNum;
	}

	public void setVisitNum(Integer visitNum) {
		this.visitNum = visitNum;
	}

	public Boolean getIsNeedOccupy() {
		return isNeedOccupy;
	}

	public void setIsNeedOccupy(Boolean isNeedOccupy) {
		this.isNeedOccupy = isNeedOccupy;
	}

	public Integer getNeedOccupyNum() {
		return needOccupyNum;
	}

	public void setNeedOccupyNum(Integer needOccupyNum) {
		this.needOccupyNum = needOccupyNum;
	}

	public Integer getPriority() {
		return priority;
	}

	public void setPriority(Integer priority) {
		this.priority = priority;
	}

	public Integer getOccupyNum() {
		return occupyNum;
	}

	public void setOccupyNum(Integer occupyNum) {
		this.occupyNum = occupyNum;
	}

	public Date getCrtTime() {
		return crtTime;
	}

	public void setCrtTime(Date crtTime) {
		this.crtTime = crtTime;
	}

	public Long getCrtOptId() {
		return crtOptId;
	}

	public void setCrtOptId(Long crtOptId) {
		this.crtOptId = crtOptId;
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

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public String getShowStatus() {
		return showStatus;
	}

	public void setShowStatus(String showStatus) {
		this.showStatus = showStatus;
	}

}
