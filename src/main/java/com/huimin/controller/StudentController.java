package com.huimin.controller;

import java.util.Date;
import java.util.Random;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.huimin.commen.Response;
import com.huimin.config.routingdatasource.TargetDataSource;
import com.huimin.entity.Student;
import com.huimin.entity.enums.Type;
import com.huimin.enun.Sex;
import com.huimin.service.StudentService;

@RestController
@RequestMapping("/student")
public class StudentController {

	@Autowired
	private StudentService studentService;
	
	@GetMapping("/{id}")
	@TargetDataSource(name = "datasource1")
	public Response getById(@PathVariable("id") Integer id){
		return Response.ok().setDataDetail(studentService.selectById(id)).build();
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
