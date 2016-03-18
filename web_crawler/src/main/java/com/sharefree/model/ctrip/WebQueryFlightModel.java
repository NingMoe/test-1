package com.sharefree.model.ctrip;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

import com.sharefree.model.BaseModel;

public class WebQueryFlightModel extends BaseModel<Object, List<Object[]>> implements Serializable {

    private static final long serialVersionUID = 1L;
    
    private Integer taskid;

    private Date tasktime;

    private String tasktype;

    private String datasource;

    private String flighttype;

    private String triptype;

    private String tripcode;

    private String tripdate;

    private String airlinecode;

    private String cabinclass;

    private Integer adtnum;

    private Integer chdnum;

    private Integer infnum;

    private Integer status;
    
    /**
     * 默认构造方法
     */
	public WebQueryFlightModel() {

	}
    
    /**
     * 新建航班查询请求
     */
	public WebQueryFlightModel(Date tasktime, String tasktype, String datasource,
			String flighttype, String triptype, String tripcode,
			String tripdate, String airlinecode, String cabinclass,
			Integer adtnum, Integer chdnum, Integer infnum, Integer status) {
		this.tasktime = tasktime;
		this.tasktype = tasktype;
		this.datasource = datasource;
		this.flighttype = flighttype;
		this.triptype = triptype;
		this.tripcode = tripcode;
		this.tripdate = tripdate;
		this.airlinecode = airlinecode;
		this.cabinclass = cabinclass;
		this.adtnum = adtnum == null?1:adtnum;
		this.chdnum = chdnum == null?0:chdnum;
		this.infnum = infnum == null?0:infnum;
		this.status = status;
	}

    public Integer getTaskid() {
        return taskid;
    }

    public void setTaskid(Integer taskid) {
        this.taskid = taskid;
    }

    public Date getTasktime() {
        return tasktime;
    }

    public void setTasktime(Date tasktime) {
        this.tasktime = tasktime;
    }

    public String getTasktype() {
		return tasktype;
	}

	public void setTasktype(String tasktype) {
		this.tasktype = tasktype;
	}

	public String getDatasource() {
        return datasource;
    }

    public void setDatasource(String datasource) {
        this.datasource = datasource == null ? null : datasource.trim();
    }

    public String getFlighttype() {
        return flighttype;
    }

    public void setFlighttype(String flighttype) {
        this.flighttype = flighttype == null ? null : flighttype.trim();
    }

    public String getTriptype() {
        return triptype;
    }

    public void setTriptype(String triptype) {
        this.triptype = triptype == null ? null : triptype.trim();
    }

    public String getTripcode() {
        return tripcode;
    }

    public void setTripcode(String tripcode) {
        this.tripcode = tripcode == null ? null : tripcode.trim();
    }

    public String getTripdate() {
        return tripdate;
    }

    public void setTripdate(String tripdate) {
        this.tripdate = tripdate == null ? null : tripdate.trim();
    }

    public String getAirlinecode() {
        return airlinecode;
    }

    public void setAirlinecode(String airlinecode) {
        this.airlinecode = airlinecode == null ? null : airlinecode.trim();
    }

    public String getCabinclass() {
        return cabinclass;
    }

    public void setCabinclass(String cabinclass) {
        this.cabinclass = cabinclass == null ? null : cabinclass.trim();
    }

    public Integer getAdtnum() {
        return adtnum;
    }

    public void setAdtnum(Integer adtnum) {
        this.adtnum = adtnum;
    }

    public Integer getChdnum() {
        return chdnum;
    }

    public void setChdnum(Integer chdnum) {
        this.chdnum = chdnum;
    }

    public Integer getInfnum() {
        return infnum;
    }

    public void setInfnum(Integer infnum) {
        this.infnum = infnum;
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }
}