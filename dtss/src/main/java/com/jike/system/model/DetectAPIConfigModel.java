package com.jike.system.model;

import java.util.List;

/**
 * Title: DetectAPIConfigModel
 *
 * Description:
 *
 * Company: LuoPan
 *
 * @author pfxu
 *
 * @date Nov 9, 2015
 *
 */
public class DetectAPIConfigModel extends BaseModel {

	/**
	 * 
	 */
	private static final long serialVersionUID = -5304093122351963401L;

	private List<String> departCodes;

	// 从departCodes出发 或者 到达arriveCodes
	private List<String> arriveCodes;

	private Integer futureStartDate;

	private Integer futureEndDate;

	private Integer connectTimeOut;

	private Integer socketTimeOut;

	// connectTimeOut + socketTimeOut < timeOut
	private Long timeOut;

	public List<String> getDepartCodes() {
		return departCodes;
	}

	public void setDepartCodes(List<String> departCodes) {
		this.departCodes = departCodes;
	}

	public List<String> getArriveCodes() {
		return arriveCodes;
	}

	public void setArriveCodes(List<String> arriveCodes) {
		this.arriveCodes = arriveCodes;
	}

	public Integer getFutureStartDate() {
		return futureStartDate;
	}

	public void setFutureStartDate(Integer futureStartDate) {
		this.futureStartDate = futureStartDate;
	}

	public Integer getFutureEndDate() {
		return futureEndDate;
	}

	public void setFutureEndDate(Integer futureEndDate) {
		this.futureEndDate = futureEndDate;
	}

	public Integer getConnectTimeOut() {
		return connectTimeOut;
	}

	public void setConnectTimeOut(Integer connectTimeOut) {
		this.connectTimeOut = connectTimeOut;
	}

	public Integer getSocketTimeOut() {
		return socketTimeOut;
	}

	public void setSocketTimeOut(Integer socketTimeOut) {
		this.socketTimeOut = socketTimeOut;
	}

	public Long getTimeOut() {
		return timeOut;
	}

	public void setTimeOut(Long timeOut) {
		this.timeOut = timeOut;
	}

}
