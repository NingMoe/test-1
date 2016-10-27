package com.sharefree.model.disney;

import java.io.Serializable;
import java.util.Date;

import org.nutz.json.JsonField;

import com.sharefree.model.BaseModel;

public class TicketStockModel extends BaseModel implements Serializable {

	private static final long serialVersionUID = 1L;

	private Long stockId;

	@JsonField(dataFormat = "yyyy-MM-dd")
	private Date visitDate;

	private Integer stock;

	private Date checkTime;

	// 条件
	private Date visitDateF;

	private Date visitDateT;

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
		this.visitDateT = visitDateT;
	}

	public Long getStockId() {
		return stockId;
	}

	public void setStockId(Long stockId) {
		this.stockId = stockId;
	}

	public Date getVisitDate() {
		return visitDate;
	}

	public void setVisitDate(Date visitDate) {
		this.visitDate = visitDate;
	}

	public Integer getStock() {
		return stock;
	}

	public void setStock(Integer stock) {
		this.stock = stock;
	}

	public Date getCheckTime() {
		return checkTime;
	}

	public void setCheckTime(Date checkTime) {
		this.checkTime = checkTime;
	}

}