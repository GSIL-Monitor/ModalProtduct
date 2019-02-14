package com.huimin.entity;


import java.io.Serializable;
import java.util.Date;

/**
 * <p>
 * 
 * </p>
 *
 * @author zhuliang
 * @since 2019-02-13
 */
public class Cron implements Serializable {

    private static final long serialVersionUID = 1L;

	private Integer id;
    /**
     * 任务名称
     */
	private String jobName;
	/**
	 * 任务名称
	 */
	private String jobKey;
    /**
     * 石英表达式
     */
	private String cron;
    /**
     * 执行的类名
     */
	private String className;
    /**
     * 执行的方法名
     */
	private String methodName;
	private Date cerateTime;
	private Date updateTime;
    /**
     * 备注
     */
	private String remark;


	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getJobName() {
		return jobName;
	}

	public void setJobName(String jobName) {
		this.jobName = jobName;
	}

	public String getCron() {
		return cron;
	}

	public void setCron(String cron) {
		this.cron = cron;
	}

	public String getClassName() {
		return className;
	}

	public void setClassName(String className) {
		this.className = className;
	}

	public String getMethodName() {
		return methodName;
	}

	public void setMethodName(String methodName) {
		this.methodName = methodName;
	}

	public Date getCerateTime() {
		return cerateTime;
	}

	public void setCerateTime(Date cerateTime) {
		this.cerateTime = cerateTime;
	}

	public Date getUpdateTime() {
		return updateTime;
	}

	public void setUpdateTime(Date updateTime) {
		this.updateTime = updateTime;
	}

	public String getRemark() {
		return remark;
	}

	public void setRemark(String remark) {
		this.remark = remark;
	}

	public String getJobKey() {
		return jobKey;
	}

	public void setJobKey(String jobKey) {
		this.jobKey = jobKey;
	}

	public static final String ID = "id";

	public static final String JOB_NAME = "job_name";
	public static final String JOB_KEY = "job_key";

	public static final String CRON = "cron";

	public static final String CLASS_NAME = "class_name";

	public static final String METHOD_NAME = "method_name";

	public static final String CERATE_TIME = "cerate_time";

	public static final String UPDATE_TIME = "update_time";

	public static final String REMARK = "remark";

	@Override
	public String toString() {
		return "Cron{" +
			"id=" + id +
			", jobName=" + jobName +
			", cron=" + cron +
			", className=" + className +
			", methodName=" + methodName +
			", cerateTime=" + cerateTime +
			", updateTime=" + updateTime +
			", remark=" + remark +
			"}";
	}
}
