package com.sharefree.model.ctrip;

import java.io.Serializable;
import java.util.List;

import com.sharefree.model.BaseModel;

public class WebClickModel extends BaseModel<Object, List<Object[]>> implements Serializable {

    private static final long serialVersionUID = 1L;
	
    private Integer clickid;

    private String clicktype;

    private Integer taskid;

    private String tasktype;

    private Integer tripsequence;

    private Integer tripid;

    private Integer productid;

    private Integer status;
    
    public WebClickModel(){}
    
    public WebClickModel(String clicktype, Integer taskid, String tasktype, Integer tripsequence, Integer tripid, Integer productid, Integer status){
    	this.clicktype = clicktype;
    	this.taskid = taskid;
    	this.tasktype = tasktype;
    	this.tripsequence = tripsequence;
    	this.tripid = tripid;
    	this.productid = productid;
    	this.status = status==null?0:status;
    }

    public Integer getClickid() {
        return clickid;
    }

    public void setClickid(Integer clickid) {
        this.clickid = clickid;
    }

    public String getClicktype() {
        return clicktype;
    }

    public void setClicktype(String clicktype) {
        this.clicktype = clicktype == null ? null : clicktype.trim();
    }

    public Integer getTaskid() {
        return taskid;
    }

    public void setTaskid(Integer taskid) {
        this.taskid = taskid;
    }

    public String getTasktype() {
		return tasktype;
	}

	public void setTasktype(String tasktype) {
		this.tasktype = tasktype;
	}

	public Integer getTripsequence() {
        return tripsequence;
    }

    public void setTripsequence(Integer tripsequence) {
        this.tripsequence = tripsequence;
    }

    public Integer getTripid() {
        return tripid;
    }

    public void setTripid(Integer tripid) {
        this.tripid = tripid;
    }

    public Integer getProductid() {
        return productid;
    }

    public void setProductid(Integer productid) {
        this.productid = productid;
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }
}