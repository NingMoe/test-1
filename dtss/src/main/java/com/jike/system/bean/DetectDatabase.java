package com.jike.system.bean;

import java.io.Serializable;
import java.util.Date;

public class DetectDatabase implements Serializable {
    private String taskId;

    private String taskGroupId;

    private String dbDriver;

    private String dbUrl;

    private String dbUsername;

    private String dbPassword;

    private String cronExpression;

    private Integer thresholdValue;

    private Integer currentFailureNum;

    private String noticeLvl;

    private String noticeObject;

    private String state;

    private Integer totalNoticeNum;

    private String createUser;

    private Date createTime;

    private String updateUser;

    private Date updateTime;

    private String guid;

    private static final long serialVersionUID = 1L;

    public String getTaskId() {
        return taskId;
    }

    public void setTaskId(String taskId) {
        this.taskId = taskId == null ? null : taskId.trim();
    }

    public String getTaskGroupId() {
        return taskGroupId;
    }

    public void setTaskGroupId(String taskGroupId) {
        this.taskGroupId = taskGroupId == null ? null : taskGroupId.trim();
    }

    public String getDbDriver() {
        return dbDriver;
    }

    public void setDbDriver(String dbDriver) {
        this.dbDriver = dbDriver == null ? null : dbDriver.trim();
    }

    public String getDbUrl() {
        return dbUrl;
    }

    public void setDbUrl(String dbUrl) {
        this.dbUrl = dbUrl == null ? null : dbUrl.trim();
    }

    public String getDbUsername() {
        return dbUsername;
    }

    public void setDbUsername(String dbUsername) {
        this.dbUsername = dbUsername == null ? null : dbUsername.trim();
    }

    public String getDbPassword() {
        return dbPassword;
    }

    public void setDbPassword(String dbPassword) {
        this.dbPassword = dbPassword == null ? null : dbPassword.trim();
    }

    public String getCronExpression() {
        return cronExpression;
    }

    public void setCronExpression(String cronExpression) {
        this.cronExpression = cronExpression == null ? null : cronExpression.trim();
    }

    public Integer getThresholdValue() {
        return thresholdValue;
    }

    public void setThresholdValue(Integer thresholdValue) {
        this.thresholdValue = thresholdValue;
    }

    public Integer getCurrentFailureNum() {
        return currentFailureNum;
    }

    public void setCurrentFailureNum(Integer currentFailureNum) {
        this.currentFailureNum = currentFailureNum;
    }

    public String getNoticeLvl() {
        return noticeLvl;
    }

    public void setNoticeLvl(String noticeLvl) {
        this.noticeLvl = noticeLvl == null ? null : noticeLvl.trim();
    }

    public String getNoticeObject() {
        return noticeObject;
    }

    public void setNoticeObject(String noticeObject) {
        this.noticeObject = noticeObject == null ? null : noticeObject.trim();
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state == null ? null : state.trim();
    }

    public Integer getTotalNoticeNum() {
        return totalNoticeNum;
    }

    public void setTotalNoticeNum(Integer totalNoticeNum) {
        this.totalNoticeNum = totalNoticeNum;
    }

    public String getCreateUser() {
        return createUser;
    }

    public void setCreateUser(String createUser) {
        this.createUser = createUser == null ? null : createUser.trim();
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    public String getUpdateUser() {
        return updateUser;
    }

    public void setUpdateUser(String updateUser) {
        this.updateUser = updateUser == null ? null : updateUser.trim();
    }

    public Date getUpdateTime() {
        return updateTime;
    }

    public void setUpdateTime(Date updateTime) {
        this.updateTime = updateTime;
    }

    public String getGuid() {
        return guid;
    }

    public void setGuid(String guid) {
        this.guid = guid == null ? null : guid.trim();
    }
}