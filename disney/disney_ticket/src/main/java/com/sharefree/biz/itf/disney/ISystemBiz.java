package com.sharefree.biz.itf.disney;

import java.util.List;

import com.sharefree.common.CommonException;
import com.sharefree.jobs.disney.JobInfo;
import com.sharefree.model.disney.ConstModel;
import com.sharefree.model.disney.TicketDistributionModel;

public interface ISystemBiz {

	/**
	 * 获取门票分布情况
	 * 
	 * @param model
	 * @return
	 * @throws CommonException
	 */
	TicketDistributionModel getTicketDistribution(TicketDistributionModel model) throws CommonException;

	/**
	 * 获取静态数据
	 * 
	 * @throws CommonException
	 */
	List<ConstModel> getConst() throws CommonException;

	/**
	 * 修改静态数据
	 * 
	 * @param models
	 * @throws CommonException
	 */
	void updateConst(List<ConstModel> models) throws CommonException;

	/**
	 * 获取任务列表
	 * 
	 * @throws CommonException
	 */
	List<JobInfo> getJobs() throws CommonException;

	/**
	 * 修改任务
	 * 
	 * @throws CommonException
	 */
	JobInfo updateJob(JobInfo job) throws CommonException;

}
