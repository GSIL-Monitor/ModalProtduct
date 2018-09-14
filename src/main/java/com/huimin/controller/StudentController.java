package com.huimin.controller;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import java.util.Random;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.baomidou.mybatisplus.plugins.Page;
import com.huimin.commen.Response;
import com.huimin.config.routingdatasource.TargetDataSource;
import com.huimin.entity.Student;
import com.huimin.entity.enums.Type;
import com.huimin.enun.Sex;
import com.huimin.result.annotation.ResultHandleNo;
import com.huimin.service.StudentService;

@RestController
@RequestMapping("/student")
@ResultHandleNo
public class StudentController {

	@Autowired
	private StudentService studentService;
	
	@GetMapping("/{id}")
	@TargetDataSource(name = "datasource1")
	public Response getById(@PathVariable("id") Integer id){
		Map<String, Object> map = new HashMap<>();
		map.put("id", 10);
		//String doPost = HttpClientUtils.doPost("http://127.0.0.1:8081/test", map);
	//	System.out.println(doPost);
		return Response.ok().setDataDetail(studentService.selectById(id)).build();
	}
	@GetMapping()
	@TargetDataSource(name = "datasource1")
	public Response page(){
		Page<Student> page = new Page<>(1, 10);
		page = studentService.selectPage(page);
		return Response.ok().setDataDetail(page).build();
	}
	@GetMapping("/create")
	public Response create(String name){
		Student student = new Student();
		student.setName(name);
		student.setAge(new Random().nextInt(100));
		student.setBrithday(new Date());
		student.setSchool("清华大学");
	//	student.setSex(Sex.MALE);
		student.setType(Type.ELEMENTARY_SCHOOL_STUDENT);
		return Response.ok().setDataDetail(studentService.insert(student)).build();
	}
	@GetMapping("/update")
	public Response update(Student student){
		student.setAge(new Random().nextInt(100));
		student.setBrithday(new Date());
		student.setSchool("清华大学");
		student.setSex(Sex.MALE);
		student.setType(Type.ELEMENTARY_SCHOOL_STUDENT);
		return Response.ok().setDataDetail(studentService.updateById(student)).build();
	}
}
