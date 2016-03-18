package com.sharefree.bean.ctrip;

import java.io.Serializable;

import org.nutz.dao.entity.annotation.Column;
import org.nutz.dao.entity.annotation.Id;
import org.nutz.dao.entity.annotation.Table;

@Table(value = "")
public class WebTrip implements Serializable {

    private static final long serialVersionUID = 1L;

	@Id
	@Column
    private Integer tripid;

	@Column
    private Integer taskid;

	@Column
    private Integer tripindex;

	@Column
    private Integer tripsequence;

	@Column
    private Integer clickid;

	@Column
    private String segment1;

	@Column
    private String segment2;

	@Column
    private String segment3;

	@Column
    private String segment4;

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
}