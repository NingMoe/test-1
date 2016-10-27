package com.sharefree.model.plane;

import java.io.Serializable;
import java.math.BigDecimal;

import com.sharefree.model.BaseModel;

/**
 * 
 * @author Sun
 * @version 2015年10月26日
 */
public class PlanePriceModel extends BaseModel implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	// 票面价
	private BigDecimal facePrice;

	// 机建费
	private BigDecimal airportCstFee;

	// 燃油附加费
	private BigDecimal fuelFee;

	public BigDecimal getFacePrice() {
		return facePrice;
	}

	public void setFacePrice(BigDecimal facePrice) {
		this.facePrice = facePrice;
	}

	public BigDecimal getAirportCstFee() {
		return airportCstFee;
	}

	public void setAirportCstFee(BigDecimal airportCstFee) {
		this.airportCstFee = airportCstFee;
	}

	public BigDecimal getFuelFee() {
		return fuelFee;
	}

	public void setFuelFee(BigDecimal fuelFee) {
		this.fuelFee = fuelFee;
	}

}
