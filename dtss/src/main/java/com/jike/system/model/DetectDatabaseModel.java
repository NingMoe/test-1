package com.jike.system.model;

import java.util.Date;

public class DetectDatabaseModel extends BaseModel {

	private static final long serialVersionUID = -4540419534768431917L;

	private String taskId;

    private String taskGroupId;

    private String dbDriver;

    private String dbUrl;

    private String dbUsername;

    private String dbPassword;

    private Integer frequency;

    private Integer thresholdValue;

    private Integer currentFailureNum;

    private String noticeLvl;

    private String noticeObject;

    private String state;

    private boolean currentIsNotice ;

    private Integer totalNoticeNum;

    private String createUser;

    private Date createTime;

    private String updateUser;

    private Date updateTime;

	public String getTaskId() {
		return taskId;
	}

	public void setTaskId(String taskId) {
		this.taskId = taskId;
	}

	public String getTaskGroupId() {
		return taskGroupId;
	}

	public void setTaskGroupId(String taskGroupId) {
		this.taskGroupId = taskGroupId;
	}

	public String getDbDriver() {
		return dbDriver;
	}

	public void setDbDriver(String dbDriver) {
		this.dbDriver = dbDriver;
	}

	public String getDbUrl() {
		return dbUrl;
	}

	public void setDbUrl(String dbUrl) {
		this.dbUrl = dbUrl;
	}

	public String getDbUsername() {
		return dbUsername;
	}

	public void setDbUsername(String dbUsername) {
		this.dbUsername = dbUsername;
	}

	public String getDbPassword() {
		return dbPassword;
	}

	public void setDbPassword(String dbPassword) {
		this.dbPassword = dbPassword;
	}

	public Integer getFrequency() {
		return frequency;
	}

	public void setFrequency(Integer frequency) {
		this.frequency = frequency;
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
		this.noticeLvl = noticeLvl;
	}

	public String getNoticeObject() {
		return noticeObject;
	}

	public void setNoticeObject(String noticeObject) {
		this.noticeObject = noticeObject;
	}

	public String getState() {
		return state;
	}

	public void setState(String state) {
		this.state = state;
	}

	public boolean isCurrentIsNotice() {
		return currentIsNotice;
	}

	public void setCurrentIsNotice(boolean currentIsNotice) {
		this.currentIsNotice = currentIsNotice;
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
		this.createUser = createUser;
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
		this.updateUser = updateUser;
	}

	public Date getUpdateTime() {
		return updateTime;
	}

	public void setUpdateTime(Date updateTime) {
		this.updateTime = updateTime;
	}
    
}

