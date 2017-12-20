package com.huimin.entity.security;


import java.io.Serializable;

import com.baomidou.mybatisplus.annotations.TableId;
import com.baomidou.mybatisplus.annotations.TableName;
import com.baomidou.mybatisplus.enums.IdType;

/**
 * <p>
 * 
 * </p>
 *
 * @author zhuliang
 * @since 2017-12-20
 */
@TableName("permission")
public class Permission implements Serializable {

    private static final long serialVersionUID = 1L;

	@TableId(value="id", type= IdType.AUTO)
	private Integer id;
	private String name;
	private String url;


	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getUrl() {
		return url;
	}

	public void setUrl(String url) {
		this.url = url;
	}

	public static final String ID = "id";

	public static final String NAME = "name";

	public static final String URL = "url";

	@Override
	public String toString() {
		return "Permission{" +
			"id=" + id +
			", name=" + name +
			", url=" + url +
			"}";
	}
}
