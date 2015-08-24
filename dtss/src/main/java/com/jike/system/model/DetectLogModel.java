package com.jike.system.model;

import java.util.Date;

import org.springframework.format.annotation.DateTimeFormat;

public class DetectLogModel extends BaseModel {

	private static final long serialVersionUID = -3350855951695412358L;

	private String logId;

    private Date logTime;

    private String logType;

    private String taskId;

    private String inputParams;

    private String detectResult;

    private String errorInfo;

	@DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private Date logStartTime;

	@DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private Date logEndTime;

	public String getLogId() {
		return logId;
	}

	public void setLogId(String logId) {
		this.logId = logId;
	}

	public Date getLogTime() {
		return logTime;
	}

	public void setLogTime(Date logTime) {
		this.logTime = logTime;
	}

	public String getLogType() {
		return logType;
	}

	public void setLogType(String logType) {
		this.logType = logType;
	}

	public String getTaskId() {
		return taskId;
	}

	public void setTaskId(String taskId) {
		this.taskId = taskId;
	}

	public String getInputParams() {
		return inputParams;
	}

	public void setInputParams(String inputParams) {
		this.inputParams = inputParams;
	}

	public String getDetectResult() {
		return detectResult;
	}

	public void setDetectResult(String detectResult) {
		this.detectResult = detectResult;
	}

	public String getErrorInfo() {
		return errorInfo;
	}

	public void setErrorInfo(String errorInfo) {
		this.errorInfo = errorInfo;
	}

	public Date getLogStartTime() {
		return logStartTime;
	}

	public void setLogStartTime(Date logStartTime) {
		this.logStartTime = logStartTime;
	}

	public Date getLogEndTime() {
		return logEndTime;
	}

	public void setLogEndTime(Date logEndTime) {
		this.logEndTime = logEndTime;
	}
    
}

