package com.huimin.enun;

public enum Sex {

	MALE(1, "男"),
	FEMALE(2, "女");
	
	private Integer type;
	private String cn;
	
	private Sex(Integer type, String cn) {
		this.cn = cn;
		this.type = type;
	}

	public String getCn() {
		return cn;
	}

	public Integer getType() {
		return type;
	}
	
}
