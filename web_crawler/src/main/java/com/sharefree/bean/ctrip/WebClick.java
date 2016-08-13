package com.sharefree.bean.ctrip;

import java.io.Serializable;

import org.nutz.dao.entity.annotation.Column;
import org.nutz.dao.entity.annotation.Id;
import org.nutz.dao.entity.annotation.Table;

@Table(value = "web_click")
public class WebClick implements Serializable {

    private static final long serialVersionUID = 1L;
    
    @Id
    @Column
    private Integer clickid;

    @Column
    private String clicktype;

    @Column
    private Integer taskid;

	@Column
    private String tasktype;

    @Column
    private Integer tripsequence;

    @Column
    private Integer tripid;

    @Column
    private Integer productid;

    @Column
    private Integer status;

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
        this.tasktype = tasktype == null ? null : tasktype.trim();
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