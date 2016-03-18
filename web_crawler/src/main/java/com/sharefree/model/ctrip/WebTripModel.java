package com.sharefree.model.ctrip;

import java.io.Serializable;
import java.util.List;

import com.sharefree.model.BaseModel;


public class WebTripModel extends BaseModel<Object, List<Object[]>> implements Serializable {

    private static final long serialVersionUID = 1L;
    
    private Integer tripid;

    private Integer taskid;

    private Integer tripindex;

    private Integer tripsequence;

    private Integer clickid;

    private String segment1;

    private String segment2;

    private String segment3;

    private String segment4;
    
    /*
     * 已排除的航班
     */
    private List<Integer> excludeTripid;
    
    /*
     * 航班仓位价格信息
     */
    private List<WebProductModel> products;

    public Integer getTripid() {
        return tripid;
    }

    public void setTripid(Integer tripid) {
        this.tripid = tripid;
    }

    public Integer getTaskid() {
        return taskid;
    }

    public void setTaskid(Integer taskid) {
        this.taskid = taskid;
    }

    public Integer getTripindex() {
        return tripindex;
    }

    public void setTripindex(Integer tripindex) {
        this.tripindex = tripindex;
    }

    public Integer getTripsequence() {
        return tripsequence;
    }

    public void setTripsequence(Integer tripsequence) {
        this.tripsequence = tripsequence;
    }

    public Integer getClickid() {
		return clickid;
	}

	public void setClickid(Integer clickid) {
		this.clickid = clickid;
	}

	public List<Integer> getExcludeTripid() {
		return excludeTripid;
	}

	public void setExcludeTripid(List<Integer> excludeTripid) {
		this.excludeTripid = excludeTripid;
	}

	public String getSegment1() {
        return segment1;
    }

    public void setSegment1(String segment1) {
        this.segment1 = segment1 == null ? null : segment1.trim();
    }

    public String getSegment2() {
        return segment2;
    }

    public void setSegment2(String segment2) {
        this.segment2 = segment2 == null ? null : segment2.trim();
    }

    public String getSegment3() {
        return segment3;
    }

    public void setSegment3(String segment3) {
        this.segment3 = segment3 == null ? null : segment3.trim();
    }

    public String getSegment4() {
        return segment4;
    }

    public void setSegment4(String segment4) {
        this.segment4 = segment4 == null ? null : segment4.trim();
    }

	public List<WebProductModel> getProducts() {
		return products;
	}

	public void setProducts(List<WebProductModel> products) {
		this.products = products;
	}
}