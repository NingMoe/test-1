package com.sharefree.model.ctrip;

import java.io.Serializable;
import java.util.List;

import com.sharefree.model.BaseModel;

public class CtripQueryFlightModel extends BaseModel<Object, List<Object[]>> implements Serializable {

    private static final long serialVersionUID = 1L;

    // 请求id（第1次请求服务端返回，第1次不需要，第2次及后续异步请求需要）
    private Integer taskId;
    
    // 航班类型（国内:1，国际:2）
    private String flightType;

    // 行程类型（单程:1，往返:2，多程:3）
    private String tripType;

    // 行程信息：
	//    [
	//		{
	//		出发城市三字码
	//		到达城市三字码
	//		出发时间
	//		}，
	//		{
	//		出发城市三字码
	//		到达城市三字码
	//		出发时间
	//		}
	//		.
	//		.
	//		.
	//	]
    private List<PlaneODModel> podms;

    // 航司(二字码)
    private String airlinecode;

    // 舱位等级
    private String cabinclass;

    // 成人机票数
    private Integer adtNum;

    // 儿童机票数
    private Integer chdNum;

    // 婴儿机票数
    private Integer infNum;

    // 点击类型
    private String clickType;
    
    // 携程数据异步查询token（实际为点击任务id:clickId）
    private Integer asyncToken;

    // 行程序列
    private Integer tripSequence;

    // 产品id
    private Integer productId;

	public Integer getTaskId() {
		return taskId;
	}

	public void setTaskId(Integer taskId) {
		this.taskId = taskId;
	}

	public String getFlightType() {
		return flightType;
	}

	public void setFlightType(String flightType) {
		this.flightType = flightType;
	}

	public String getTripType() {
		return tripType;
	}

	public void setTripType(String tripType) {
		this.tripType = tripType;
	}

	public List<PlaneODModel> getPodms() {
		return podms;
	}

	public void setPodms(List<PlaneODModel> podms) {
		this.podms = podms;
	}

	public String getAirlinecode() {
		return airlinecode;
	}

	public void setAirlinecode(String airlinecode) {
		this.airlinecode = airlinecode;
	}

	public String getCabinclass() {
		return cabinclass;
	}

	public void setCabinclass(String cabinclass) {
		this.cabinclass = cabinclass;
	}

	public Integer getAdtNum() {
		return adtNum;
	}

	public void setAdtNum(Integer adtNum) {
		this.adtNum = adtNum;
	}

	public Integer getChdNum() {
		return chdNum;
	}

	public void setChdNum(Integer chdNum) {
		this.chdNum = chdNum;
	}

	public Integer getInfNum() {
		return infNum;
	}

	public void setInfNum(Integer infNum) {
		this.infNum = infNum;
	}

	public String getClickType() {
		return clickType;
	}

	public void setClickType(String clickType) {
		this.clickType = clickType;
	}

	public Integer getAsyncToken() {
		return asyncToken;
	}

	public void setAsyncToken(Integer asyncToken) {
		this.asyncToken = asyncToken;
	}

	public Integer getTripSequence() {
		return tripSequence;
	}

	public void setTripSequence(Integer tripSequence) {
		this.tripSequence = tripSequence;
	}

	public Integer getProductId() {
		return productId;
	}

	public void setProductId(Integer productId) {
		this.productId = productId;
	}
    
}