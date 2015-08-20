package com.jike.system.core;

/**
 * Title: Job
 *
 * Description: Job的相关信息
 *
 * Company: LuoPan
 *
 * @author pfxu
 *
 * @date Aug 20, 2015
 *
 */
public class Job {
	
	private String jobName;
	
	private String jobGroupName;
	
	private String triggerName;
	
	private String triggerGroupName;

	private int failureTime;

	private int jobState;

	public String getJobName() {
		return jobName;
	}

	public void setJobName(String jobName) {
		this.jobName = jobName;
	}

	public String getJobGroupName() {
		return jobGroupName;
	}

	public void setJobGroupName(String jobGroupName) {
		this.jobGroupName = jobGroupName;
	}

	public String getTriggerName() {
		return triggerName;
	}

	public void setTriggerName(String triggerName) {
		this.triggerName = triggerName;
	}

	public String getTriggerGroupName() {
		return triggerGroupName;
	}

	public void setTriggerGroupName(String triggerGroupName) {
		this.triggerGroupName = triggerGroupName;
	}

	public int getFailureTime() {
		return failureTime;
	}

	public void setFailureTime(int failureTime) {
		this.failureTime = failureTime;
	}

	public int getJobState() {
		return jobState;
	}

	public void setJobState(int jobState) {
		this.jobState = jobState;
	}

}
