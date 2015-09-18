package com.jike.system.model;

import java.util.Date;

import org.springframework.format.annotation.DateTimeFormat;

public class DetectInterfaceModel extends BaseModel {
	
	private static final long serialVersionUID = -905464811682872973L;

	private String taskId;

    private String taskGroupId;
    
    private Boolean taskGroupFlag;

    private String belongTo;

    private String itfUrl;

    private String itfParams;

    private String requestMethod;

    private String checkValue1;

    private String checkValue2;

    private String detectMode;

    private Integer frequency;

    private String startTime;

    private String endTime;

    private Integer thresholdValue;

    private Integer currentFailureNum;

    private String noticeLvl;

    private String noticeObject;

    private Boolean byProxy;

    private String proxyIp;

    private Integer proxyPort;

    private String proxyUsername;

    private String proxyPassword;

    private String state;

    private String toState;

    private Boolean currentIsNotice ;

    private Integer totalNoticeNum;

    private String createUser;

    private Date createTime;

	@DateTimeFormat(pattern = "yyyy-MM-dd")
    private Date createStartTime;

	@DateTimeFormat(pattern = "yyyy-MM-dd")
    private Date createEndTime;

    private String updateUser;

    private Date updateTime;

	@DateTimeFormat(pattern = "yyyy-MM-dd")
    private Date updateStartTime;

	@DateTimeFormat(pattern = "yyyy-MM-dd")
    private Date updateEndTime;

    private String guid;

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

	public Boolean getTaskGroupFlag() {
		return taskGroupFlag;
	}

	public void setTaskGroupFlag(Boolean taskGroupFlag) {
		this.taskGroupFlag = taskGroupFlag;
	}

	public String getBelongTo() {
		return belongTo;
	}

	public void setBelongTo(String belongTo) {
		this.belongTo = belongTo;
	}

	public String getItfUrl() {
		return itfUrl;
	}

	public void setItfUrl(String itfUrl) {
		this.itfUrl = itfUrl;
	}

	public String getItfParams() {
		return itfParams;
	}

	public void setItfParams(String itfParams) {
		this.itfParams = itfParams;
	}

	public String getRequestMethod() {
		return requestMethod;
	}

	public void setRequestMethod(String requestMethod) {
		this.requestMethod = requestMethod;
	}

	public String getCheckValue1() {
		return checkValue1;
	}

	public void setCheckValue1(String checkValue1) {
		this.checkValue1 = checkValue1;
	}

	public String getCheckValue2() {
		return checkValue2;
	}

	public void setCheckValue2(String checkValue2) {
		this.checkValue2 = checkValue2;
	}

	public String getDetectMode() {
		return detectMode;
	}

	public void setDetectMode(String detectMode) {
		this.detectMode = detectMode;
	}

	public Integer getFrequency() {
		return frequency;
	}

	public void setFrequency(Integer frequency) {
		this.frequency = frequency;
	}

	public String getStartTime() {
		return startTime;
	}

	public void setStartTime(String startTime) {
		this.startTime = startTime;
	}

	public String getEndTime() {
		return endTime;
	}

	public void setEndTime(String endTime) {
		this.endTime = endTime;
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

	public Boolean getByProxy() {
		return byProxy;
	}

	public void setByProxy(Boolean byProxy) {
		this.byProxy = byProxy;
	}

	public String getProxyIp() {
		return proxyIp;
	}

	public void setProxyIp(String proxyIp) {
		this.proxyIp = proxyIp;
	}

	public Integer getProxyPort() {
		return proxyPort;
	}

	public void setProxyPort(Integer proxyPort) {
		this.proxyPort = proxyPort;
	}

	public String getProxyUsername() {
		return proxyUsername;
	}

	public void setProxyUsername(String proxyUsername) {
		this.proxyUsername = proxyUsername;
	}

	public String getProxyPassword() {
		return proxyPassword;
	}

	public void setProxyPassword(String proxyPassword) {
		this.proxyPassword = proxyPassword;
	}

	public String getState() {
		return state;
	}

	public void setState(String state) {
		this.state = state;
	}

	public String getToState() {
		return toState;
	}

	public void setToState(String toState) {
		this.toState = toState;
	}

	public Boolean getCurrentIsNotice() {
		return currentIsNotice;
	}

	public void setCurrentIsNotice(Boolean currentIsNotice) {
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

	public Date getCreateStartTime() {
		return createStartTime;
	}

	public void setCreateStartTime(Date createStartTime) {
		this.createStartTime = createStartTime;
	}

	public Date getCreateEndTime() {
		return createEndTime;
	}

	public void setCreateEndTime(Date createEndTime) {
		this.createEndTime = createEndTime;
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

	public Date getUpdateStartTime() {
		return updateStartTime;
	}

	public void setUpdateStartTime(Date updateStartTime) {
		this.updateStartTime = updateStartTime;
	}

	public Date getUpdateEndTime() {
		return updateEndTime;
	}

	public void setUpdateEndTime(Date updateEndTime) {
		this.updateEndTime = updateEndTime;
	}

	public String getGuid() {
		return guid;
	}

	public void setGuid(String guid) {
		this.guid = guid;
	}
    
	
}

