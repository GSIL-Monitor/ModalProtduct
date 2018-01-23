package com.huimin.effective;

import java.util.Date;

public class BuilderTest implements Cloneable{

	private Integer age;
	private String name;
	private Integer id;
	private Date brithday;
	
	public static Builder create() {
		return new Builder();
	}
	public static class Builder{
		private Integer age;
		private String name;
		private Integer id;
		private Date brithday;
		private Builder() {
		}
		
		public Builder age(Integer age) {
			this.age = age;
			return this;
		}
		public Builder name(String name) {
			this.name = name;
			return this;
		}
		public Builder id(Integer id) {
			this.id = id;
			return this;
		}
		public Builder brithday(Date brithday) {
			this.brithday = brithday;
			return this;
		}
		public BuilderTest builder() {
			return new BuilderTest(this);
		}
	}
	private BuilderTest(Builder builder) {
		this.age = builder.age;
		this.brithday = builder.brithday;
		this.id = builder.id;
		this.name = builder.name;
	}
	
	public void setAge(Integer age) {
		this.age = age;
	}

	public void setName(String name) {
		this.name = name;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public void setBrithday(Date brithday) {
		this.brithday = brithday;
	}

	public Integer getAge() {
		return age;
	}
	public String getName() {
		return name;
	}
	public Integer getId() {
		return id;
	}
	public Date getBrithday() {
		return brithday;
	}
	
	@Override
	public BuilderTest clone() throws CloneNotSupportedException {
		return (BuilderTest) super.clone();
	}
}
