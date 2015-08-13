package com.jike.system.bean;

import java.io.Serializable;
import java.util.Date;

public class DetectInterface implements Serializable {
    private String itfId;

    private String belongTo;

    private String itfUrl;

    private String itfParams;

    private String requestMethod;

    private String checkKey;

    private String checkValue;

    private Integer detectFrequency;

    private Short thresholdValue;

    private Short currentFailureNum;

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

    private static final long serialVersionUID = 1L;

    public String getItfId() {
        return itfId;
    }

    public void setItfId(String itfId) {
        this.itfId = itfId == null ? null : itfId.trim();
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

    public String getCheckKey() {
        return checkKey;
    }

    public void setCheckKey(String checkKey) {
        this.checkKey = checkKey == null ? null : checkKey.trim();
    }

    public String getCheckValue() {
        return checkValue;
    }

    public void setCheckValue(String checkValue) {
        this.checkValue = checkValue == null ? null : checkValue.trim();
    }

    public Integer getDetectFrequency() {
        return detectFrequency;
    }

    public void setDetectFrequency(Integer detectFrequency) {
        this.detectFrequency = detectFrequency;
    }

    public Short getThresholdValue() {
        return thresholdValue;
    }

    public void setThresholdValue(Short thresholdValue) {
        this.thresholdValue = thresholdValue;
    }

    public Short getCurrentFailureNum() {
        return currentFailureNum;
    }

    public void setCurrentFailureNum(Short currentFailureNum) {
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
}