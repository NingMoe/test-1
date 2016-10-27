package com.sharefree.model.disney;

import java.util.Date;
import java.util.List;

import com.sharefree.model.BaseModel;

public class TicketDistributionModel extends BaseModel {

	private List<TouristOrderModel> orderNumSum;

	private List<TicketStockModel> stockNumSum;

	private List<OccupyDetailModel> occupyNumSum;

	private List<TouristTicketModel> ticketNumSum;

	// 条件
	// 显示订单总票数
	private Boolean showOrderNumSum;

	// 显示库存总票数
	private Boolean showStockNumSum;

	// 显示出票总票数
	private Boolean showTicketNumSum;

	// 显示占位总票数
	private Boolean showOccupyNumSum;

	private Date visitDateF;

	private Date visitDateT;

	public List<TouristOrderModel> getOrderNumSum() {
		return orderNumSum;
	}

	public void setOrderNumSum(List<TouristOrderModel> orderNumSum) {
		this.orderNumSum = orderNumSum;
	}

	public List<TicketStockModel> getStockNumSum() {
		return stockNumSum;
	}

	public void setStockNumSum(List<TicketStockModel> stockNumSum) {
		this.stockNumSum = stockNumSum;
	}

	public List<OccupyDetailModel> getOccupyNumSum() {
		return occupyNumSum;
	}

	public void setOccupyNumSum(List<OccupyDetailModel> occupyNumSum) {
		this.occupyNumSum = occupyNumSum;
	}

	public List<TouristTicketModel> getTicketNumSum() {
		return ticketNumSum;
	}

	public void setTicketNumSum(List<TouristTicketModel> ticketNumSum) {
		this.ticketNumSum = ticketNumSum;
	}

	public Boolean getShowOrderNumSum() {
		return showOrderNumSum;
	}

	public void setShowOrderNumSum(Boolean showOrderNumSum) {
		this.showOrderNumSum = showOrderNumSum;
	}

	public Boolean getShowStockNumSum() {
		return showStockNumSum;
	}

	public void setShowStockNumSum(Boolean showStockNumSum) {
		this.showStockNumSum = showStockNumSum;
	}

	public Boolean getShowTicketNumSum() {
		return showTicketNumSum;
	}

	public void setShowTicketNumSum(Boolean showTicketNumSum) {
		this.showTicketNumSum = showTicketNumSum;
	}

	public Boolean getShowOccupyNumSum() {
		return showOccupyNumSum;
	}

	public void setShowOccupyNumSum(Boolean showOccupyNumSum) {
		this.showOccupyNumSum = showOccupyNumSum;
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
		this.visitDateT = visitDateT;
	}

}