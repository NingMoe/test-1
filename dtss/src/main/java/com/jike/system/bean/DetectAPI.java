package com.jike.system.bean;

import java.io.Serializable;
import java.util.Date;

public class DetectAPI implements Serializable {
    private String taskId;

    private Date taskRunTime;

    private String departCode;

    private String arriveCode;

    private Date departDate;

    private Long taskTimeCost;

    private String resultType;

    private String token;

    private static final long serialVersionUID = 1L;

    public String getTaskId() {
        return taskId;
    }

    public void setTaskId(String taskId) {
        this.taskId = taskId == null ? null : taskId.trim();
    }

    public Date getTaskRunTime() {
        return taskRunTime;
    }

    public void setTaskRunTime(Date taskRunTime) {
        this.taskRunTime = taskRunTime;
    }

    public String getDepartCode() {
        return departCode;
    }

    public void setDepartCode(String departCode) {
        this.departCode = departCode == null ? null : departCode.trim();
    }

    public String getArriveCode() {
        return arriveCode;
    }

    public void setArriveCode(String arriveCode) {
        this.arriveCode = arriveCode == null ? null : arriveCode.trim();
    }

    public Date getDepartDate() {
        return departDate;
    }

    public void setDepartDate(Date departDate) {
        this.departDate = departDate;
    }

    public Long getTaskTimeCost() {
        return taskTimeCost;
    }

    public void setTaskTimeCost(Long taskTimeCost) {
        this.taskTimeCost = taskTimeCost;
    }

    public String getResultType() {
        return resultType;
    }

    public void setResultType(String resultType) {
        this.resultType = resultType == null ? null : resultType.trim();
    }

    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token == null ? null : token.trim();
    }
}