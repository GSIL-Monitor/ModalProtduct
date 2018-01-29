package com.huimin.java8;

import java.util.List;
/**
 * 创作音乐的个人或团队
 * @author ThinkPad
 *
 */
public class Artist {

	private String name;//姓名
	private String origin;//籍贯
	private List<Artist> members;//成员
	private Integer age;
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getOrigin() {
		return origin;
	}
	public void setOrigin(String origin) {
		this.origin = origin;
	}
	public List<Artist> getMembers() {
		return members;
	}
	public void setMembers(List<Artist> members) {
		this.members = members;
	}
	
	public Integer getAge() {
		return age;
	}
	public void setAge(Integer age) {
		this.age = age;
	}
	@Override
	public String toString() {
		return "Artist [name=" + name + ", origin=" + origin  + ", age=" + age + "]";
	}
	
	
	
}
