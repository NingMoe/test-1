package com.sharefree.jobs.disney;

import com.sharefree.common.CommonException;
import com.sharefree.utils.QuartzManager;

/**
 * Title: JobInfo
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
public class JobInfo {

	public static enum JobStateOpt {
		RUN, STOP, RESTART
	}

	public static final String jobName = "检查库存";

	private static JobStateOpt jobState;

	private static Integer frequency = 30;

	private JobStateOpt toState;

	public JobInfo() {
	}

	public JobInfo(JobStateOpt toState) {
		this.toState = toState;
	}

	public static JobStateOpt getJobState() {
		return jobState;
	}

	public static void setJobState(JobStateOpt jobState) {
		JobInfo.jobState = jobState;
	}

	public JobStateOpt getToState() {
		return toState;
	}

	public void setToState(JobStateOpt toState) {
		this.toState = toState;
	}

	public Integer getFrequency() {
		return frequency;
	}

	public void setFrequency(Integer frequency) {
		JobInfo.frequency = frequency;
	}

	public static synchronized JobInfo updateJob(JobInfo job) throws CommonException {
		// 当前任务状态
		JobStateOpt currentState = jobState;
		JobStateOpt toState = job.getToState();
		if (toState != null && !toState.equals(currentState) && job.getFrequency() != null) {
			switch (toState) {
			case RUN:
				QuartzManager.addSimpleJob("testJob", "testJobGroup", "testTrigger", "testTriggerGroup", CheckTicketStockJob.class, null, null, -1, 10, null);
				JobInfo.jobState = toState;
				break;
			case STOP:
				QuartzManager.removeJob(jobName, null, null, null, null);
				JobInfo.jobState = toState;
				break;
			case RESTART:
				QuartzManager.updateSimpleJob(jobName, null, job.getFrequency(), null);
				JobInfo.jobState = toState;
				break;
			default:
				break;
			}
		}
		return job;
	}

}
