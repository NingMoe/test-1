package com.sharefree.bean.ctrip;

import java.io.Serializable;
import java.util.Date;

import org.nutz.dao.entity.annotation.Column;
import org.nutz.dao.entity.annotation.Id;
import org.nutz.dao.entity.annotation.Table;

@Table(value = "web_query_flight")
public class WebQueryFlight implements Serializable {

    private static final long serialVersionUID = 1L;
	
	@Id
	@Column
    private Integer taskid;

	@Column
    private Date tasktime;

	@Column
    private String tasktype;

	@Column
    private String datasource;

	@Column
    private String flighttype;

	@Column
    private String triptype;

	@Column
    private String tripcode;

	@Column
    private String tripdate;

	@Column
    private String airlinecode;

	@Column
    private String cabinclass;

	@Column
    private Integer adtnum;

	@Column
    private Integer chdnum;

	@Column
    private Integer infnum;

	@Column
    private Integer status;

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