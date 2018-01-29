package com.huimin.java8;

/**
 * 音乐专辑中的曲目
 * @author ThinkPad
 *
 */
public class Track {
	private String name;

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	@Override
	public String toString() {
		return "Track [name=" + name + "]";
	}
	
}
