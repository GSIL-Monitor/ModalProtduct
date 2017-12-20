package com.huimin.entity.enums;

import java.io.Serializable;

import com.baomidou.mybatisplus.enums.IEnum;

public enum Type implements IEnum {
	MIDDLE_SCHOOL_STUDENT(2, "中学生"),
    ELEMENTARY_SCHOOL_STUDENT(1, "小学生");

	private Integer type;
	private String cn;
	
	private Type(Integer type, String cn) {
		this.cn = cn;
		this.type = type;
	}
	@Override
	public Serializable getValue() {
		return type;
	}
	public Integer getType() {
		return type;
	}
	public String getCn() {
		return cn;
	}

	
	
}
