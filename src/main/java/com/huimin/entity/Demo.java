package com.huimin.entity;


import java.io.Serializable;

import com.baomidou.mybatisplus.annotations.TableId;
import com.baomidou.mybatisplus.enums.IdType;

/**
 * <p>
 * 
 * </p>
 *
 * @author zhuliang
 * @since 2018-09-27
 */
public class Demo implements Serializable {

    private static final long serialVersionUID = 1L;

	@TableId(value="id", type= IdType.AUTO)
	private Integer id;
	private Integer age;
	private String name;


	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Integer getAge() {
		return age;
	}

	public void setAge(Integer age) {
		this.age = age;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public static final String ID = "id";

	public static final String AGE = "age";

	public static final String NAME = "name";

	@Override
	public String toString() {
		return "Demo{" +
			"id=" + id +
			", age=" + age +
			", name=" + name +
			"}";
	}
}
