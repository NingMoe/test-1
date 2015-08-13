package com.jike.system.bean;

import java.io.Serializable;
import java.util.Date;

public class DetectInterfaceLog implements Serializable {
    private String itfLogId;

    private Date detectTime;

    private String itfId;

    private String inputParams;

    private String detectResult;

    private String errorInfo;

    private static final long serialVersionUID = 1L;

    public String getItfLogId() {
        return itfLogId;
    }

    public void setItfLogId(String itfLogId) {
        this.itfLogId = itfLogId == null ? null : itfLogId.trim();
    }

    public Date getDetectTime() {
        return detectTime;
    }

    public void setDetectTime(Date detectTime) {
        this.detectTime = detectTime;
    }

    public String getItfId() {
        return itfId;
    }

    public void setItfId(String itfId) {
        this.itfId = itfId == null ? null : itfId.trim();
    }

    public String getInputParams() {
        return inputParams;
    }

    public void setInputParams(String inputParams) {
        this.inputParams = inputParams == null ? null : inputParams.trim();
    }

    public String getDetectResult() {
        return detectResult;
    }

    public void setDetectResult(String detectResult) {
        this.detectResult = detectResult == null ? null : detectResult.trim();
    }

    public String getErrorInfo() {
        return errorInfo;
    }

    public void setErrorInfo(String errorInfo) {
        this.errorInfo = errorInfo == null ? null : errorInfo.trim();
    }
}