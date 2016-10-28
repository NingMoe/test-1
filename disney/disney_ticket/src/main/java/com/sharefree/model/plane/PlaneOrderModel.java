package com.sharefree.model.plane;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

import com.sharefree.model.BaseModel;

/**
 * 机票订单
 * 
 * @author Sun
 * 
 */
public class PlaneOrderModel extends BaseModel implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private String pnr;

	private String bigPnr;

	private String priceCode;

	private List<PlaneODModel> ods;

	// 乘客
	private List<TicketPassengerModel> passengers;

	// 未出票PNR运价
	private List<PlanePriceModel> prices;

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

	public String getPriceCode() {
		return priceCode;
	}

	public void setPriceCode(String priceCode) {
		this.priceCode = priceCode;
	}

	public List<PlaneODModel> getOds() {
		return ods;
	}

	public void setOds(List<PlaneODModel> ods) {
		this.ods = ods;
	}

	public List<TicketPassengerModel> getPassengers() {
		return passengers;
	}

	public void setPassengers(List<TicketPassengerModel> passengers) {
		this.passengers = passengers;
	}

	public List<PlanePriceModel> getPrices() {
		return prices;
	}

	public void setPrices(List<PlanePriceModel> prices) {
		this.prices = prices;
	}

	/**
	 * 根据底价排序列表
	 * 
	 * @param list
	 * @param sort
	 */
	public void sort(List<PlanePriceModel> list, final String sort) {
		if (list != null && list.size() > 0) {
			Collections.sort(list, new Comparator<PlanePriceModel>() {
				public int compare(PlanePriceModel a, PlanePriceModel b) {
					BigDecimal price1 = a.getFacePrice();
					BigDecimal price2 = b.getFacePrice();
					int ret = 0;
					if (sort != null && "desc".equals(sort))
						// 倒序
						ret = price2.compareTo(price1);
					else
						// 正序
						ret = price1.compareTo(price2);
					return ret;
				}
			});
		}
	}

}
