package com.jike.system.bean;

import java.io.Serializable;
import java.util.Date;

public class DetectInterface implements Serializable {
    private String taskId;

    private String taskGroupId;

    private String belongTo;

    private String itfUrl;

    private String itfParams;

    private String requestMethod;

    private String checkValue1;

    private String checkValue2;

    private Integer frequency;

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

    private Integer totalNoticeNum;

    private String createUser;

    private Date createTime;

    private String updateUser;

    private Date updateTime;

    private String guid;

    private String detectMode;

    private String startTime;

    private String endTime;

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

    public String getBelongTo() {
        return belongTo;
    }

    public void setBelongTo(String belongTo) {
        this.belongTo = belongTo == null ? null : belongTo.trim();
    }

    public String getItfUrl() {
        return itfUrl;
    }

    public void setItfUrl(String itfUrl) {
        this.itfUrl = itfUrl == null ? null : itfUrl.trim();
    }

    public String getItfParams() {
        return itfParams;
    }

    public void setItfParams(String itfParams) {
        this.itfParams = itfParams == null ? null : itfParams.trim();
    }

    public String getRequestMethod() {
        return requestMethod;
    }

    public void setRequestMethod(String requestMethod) {
        this.requestMethod = requestMethod == null ? null : requestMethod.trim();
    }

    public String getCheckValue1() {
        return checkValue1;
    }

    public void setCheckValue1(String checkValue1) {
        this.checkValue1 = checkValue1 == null ? null : checkValue1.trim();
    }

    public String getCheckValue2() {
        return checkValue2;
    }

    public void setCheckValue2(String checkValue2) {
        this.checkValue2 = checkValue2 == null ? null : checkValue2.trim();
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
        this.noticeLvl = noticeLvl == null ? null : noticeLvl.trim();
    }

    public String getNoticeObject() {
        return noticeObject;
    }

    public void setNoticeObject(String noticeObject) {
        this.noticeObject = noticeObject == null ? null : noticeObject.trim();
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
        this.proxyIp = proxyIp == null ? null : proxyIp.trim();
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
        this.proxyUsername = proxyUsername == null ? null : proxyUsername.trim();
    }

    public String getProxyPassword() {
        return proxyPassword;
    }

    public void setProxyPassword(String proxyPassword) {
        this.proxyPassword = proxyPassword == null ? null : proxyPassword.trim();
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

    public String getDetectMode() {
        return detectMode;
    }

    public void setDetectMode(String detectMode) {
        this.detectMode = detectMode == null ? null : detectMode.trim();
    }

    public String getStartTime() {
        return startTime;
    }

    public void setStartTime(String startTime) {
        this.startTime = startTime == null ? null : startTime.trim();
    }

    public String getEndTime() {
        return endTime;
    }

    public void setEndTime(String endTime) {
        this.endTime = endTime == null ? null : endTime.trim();
    }
}