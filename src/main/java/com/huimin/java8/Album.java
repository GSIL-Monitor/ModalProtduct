package com.huimin.java8;


import java.util.List;
/**
 * 
 * @author zhuliang
 *
 * @Date 2018年1月24日下午1:55:54
 */
public class Album {

	private String name;//专辑名称
	private List<Track> tracks;//专辑列表
	private List<Artist> musicians;//专辑创作人
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public List<Track> getTracks() {
		return tracks;
	}
	public void setTracks(List<Track> tracks) {
		this.tracks = tracks;
	}
	public List<Artist> getMusicians() {
		return musicians;
	}
	public void setMusicians(List<Artist> musicians) {
		this.musicians = musicians;
	}
	@Override
	public String toString() {
		return "Album [name=" + name + ", tracks=" + tracks + ", musicians=" + musicians + "]";
	}
	
}
