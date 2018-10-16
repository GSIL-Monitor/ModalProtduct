package com.huimin.entity.bo;

import java.util.ArrayList;
import java.util.List;

import com.alibaba.fastjson.annotation.JSONField;

public class BasicTree<T> {
	//当前前节点id
	private Integer id;
   //当前节点 名称
	private String title;

	//父节点id
	@JSONField(serialize = false)
	private Integer parentId;
    //父节点名称
	@JSONField(serialize = false)
	private String parentName;
    //当前节点的子节点
	private List<T> children = new ArrayList<>();

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public Integer getParentId() {
		return parentId;
	}

	public void setParentId(Integer parentId) {
		this.parentId = parentId;
	}

	public String getParentName() {
		return parentName;
	}

	public void setParentName(String parentName) {
		this.parentName = parentName;
	}

	public List<T> getChildren() {
		return children;
	}

	public void setChildren(List<T> children) {
		this.children = children;
	}
	
}
