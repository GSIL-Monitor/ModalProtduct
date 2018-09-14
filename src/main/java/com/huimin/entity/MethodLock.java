package com.huimin.entity;


import java.io.Serializable;
import java.util.Date;

import com.baomidou.mybatisplus.annotations.TableId;
import com.baomidou.mybatisplus.annotations.TableName;
import com.baomidou.mybatisplus.enums.IdType;

/**
 * <p>
 * 锁定中的方法
 * </p>
 *
 * @author zhuliang
 * @since 2018-07-10
 */
@TableName("method_lock")
public class MethodLock implements Serializable {

    private static final long serialVersionUID = 1L;

    /**
     * 主键
     */
	@TableId(value="id", type= IdType.AUTO)
	private Integer id;
    /**
     * 锁定的方法名
     */
	private String methodName;
    /**
     * 备注信息
     */
	private String desc;
	private Date updateTime;
    /**
     * 唯一标识
     */
	private String uuid;


	public MethodLock() {
	}
	public MethodLock(String methodName) {
		this.methodName = methodName;
		this.uuid = java.util.UUID.randomUUID().toString();
	}
	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getMethodName() {
		return methodName;
	}

	public void setMethodName(String methodName) {
		this.methodName = methodName;
	}

	public String getDesc() {
		return desc;
	}

	public void setDesc(String desc) {
		this.desc = desc;
	}

	public Date getUpdateTime() {
		return updateTime;
	}

	public void setUpdateTime(Date updateTime) {
		this.updateTime = updateTime;
	}

	public String getUuid() {
		return uuid;
	}

	public void setUuid(String uuid) {
		this.uuid = uuid;
	}

	public static final String ID = "id";

	public static final String METHOD_NAME = "method_name";

	public static final String DESC = "desc";

	public static final String UPDATE_TIME = "update_time";

	public static final String UUID = "uuid";

	@Override
	public String toString() {
		return "MethodLock{" +
			"id=" + id +
			", methodName=" + methodName +
			", desc=" + desc +
			", updateTime=" + updateTime +
			", uuid=" + uuid +
			"}";
	}
}
