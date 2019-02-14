package com.huimin.elasticsearch;

import com.huimin.elasticsearch.annotation.Document;
import com.huimin.elasticsearch.annotation.Id;
import com.huimin.elasticsearch.common.Model;

@Document(indexName = "zhuliang", type = "student")
public class StudentModel extends Model{

	private static final long serialVersionUID = 1L;

	@Id
    private Integer id;
	
	private String name;
	
	private Integer age;

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

	public Integer getAge() {
		return age;
	}

	public void setAge(Integer age) {
		this.age = age;
	}

	@Override
	public String toString() {
		return "StudentModel [id=" + id + ", name=" + name + ", age=" + age + "]";
	}
	
}
