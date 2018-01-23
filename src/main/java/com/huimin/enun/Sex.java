package com.huimin.enun;

public enum Sex {

	MALE(1, "男"){
		public  String getSql(String table) {
			return "select * from " + table + ";";
		}},
	FEMALE(2, "女"){
		public  String getSql(String table) {
			return "select * from " + table + ";";
		}
	};
	
	private Integer type;
	private String cn;
	
	public abstract String getSql(String table);
	
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
