package com.jike.system.model;

import java.util.Date;

import org.springframework.format.annotation.DateTimeFormat;

/**
 * Title: DetectAPIModel
 *
 * Description:
 *
 * Company: LuoPan
 *
 * @author pfxu
 *
 * @date Nov 6, 2015
 *
 */
public class DetectAPIModel extends BaseModel {

	/**
	 * 
	 */
	private static final long serialVersionUID = -5280782115550725675L;

	private String taskId;

	private Date taskRunTime;

	private String departCode;

	private String arriveCode;

	private Date departDate;

	private Long taskTimeCost;

	private String resultType;

	// 启动定时任务时附带的查询速度

	private Integer requestSpeed;

	private String token;

	@DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
	private Date taskRunStartTime;

	@DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
	private Date taskRunEndTime;

	public String getTaskId() {
		return taskId;
	}

	public void setTaskId(String taskId) {
		this.taskId = taskId;
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
		this.departCode = departCode;
	}

	public String getArriveCode() {
		return arriveCode;
	}

	public void setArriveCode(String arriveCode) {
		this.arriveCode = arriveCode;
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
		this.resultType = resultType;
	}

	public Integer getRequestSpeed() {
		return requestSpeed;
	}

	public void setRequestSpeed(Integer requestSpeed) {
		this.requestSpeed = requestSpeed;
	}

	public String getToken() {
		return token;
	}

	public void setToken(String token) {
		this.token = token == null ? null : token.trim();
	}

	public Date getTaskRunStartTime() {
		return taskRunStartTime;
	}

	public void setTaskRunStartTime(Date taskRunStartTime) {
		this.taskRunStartTime = taskRunStartTime;
	}

	public Date getTaskRunEndTime() {
		return taskRunEndTime;
	}

	public void setTaskRunEndTime(Date taskRunEndTime) {
		this.taskRunEndTime = taskRunEndTime;
	}

	public String toString() {
		return "{\"任务ID\":\"" + taskId + "\",\"任务启动时间\":\"" + taskRunTime
				+ "\",\"出发城市三字码\":\"" + departCode + "\",\"到达城市三字码\":\""
				+ arriveCode + "\",\"出发日期\":\"" + departDate + "\",\"查询耗时\":"
				+ taskTimeCost + ",\"结果类型\":\"" + resultType
				+ "\",\"Token值\":\"" + token + "\"}";
	}

}
