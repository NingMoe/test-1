package com.sharefree.model.plane;

import java.io.Serializable;
import java.util.List;

import com.sharefree.model.BaseModel;

/**
 * 
 * @author Sun
 * @version 2015年10月26日
 */
public class PlaneODModel extends BaseModel implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	// 行程下的航班
	private List<PlaneTripModel> segments;

	// 行程所对应的价格
	// private List<PlanePriceModel> prices;

	public List<PlaneTripModel> getSegments() {
		return segments;
	}

	public void setSegments(List<PlaneTripModel> segments) {
		this.segments = segments;
	}

}
