package com.jike.system.model;

import com.jike.system.bean.DetectInterface;

public class DetectInterfaceModel extends DetectInterface {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = -905464811682872973L;

	public DetectInterfaceModel() {
		super();
	}
	
	private String jobGroupName; // 任务组名称

	public String getJobGroupName() {
		return jobGroupName;
	}

	public void setJobGroupName(String jobGroupName) {
		this.jobGroupName = jobGroupName;
	}
	
}

