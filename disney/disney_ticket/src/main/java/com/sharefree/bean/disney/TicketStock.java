package com.sharefree.bean.disney;

import java.io.Serializable;
import java.util.Date;

import org.nutz.dao.entity.annotation.Column;
import org.nutz.dao.entity.annotation.Id;
import org.nutz.dao.entity.annotation.Table;

@Table(value = "ticket_stock")
public class TicketStock implements Serializable {

    private static final long serialVersionUID = 1L;
    
    @Id
    private Long stockId;
    
    @Column
    private Date visitDate;

	@Column
    private Integer stock;

	@Column
    private Date checkTime;

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
