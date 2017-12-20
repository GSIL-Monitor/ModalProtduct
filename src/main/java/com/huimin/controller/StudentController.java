package com.huimin.controller;

import java.util.Date;
import java.util.Random;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.huimin.entity.Student;
import com.huimin.entity.enums.Type;
import com.huimin.enun.Sex;
import com.huimin.service.StudentService;

@Controller
@RequestMapping("/student")
public class StudentController {

	@Autowired
	private StudentService studentService;
	
	@GetMapping("/{id}")
	@ResponseBody
	public Student getById(@PathVariable("id") Integer id){
		return studentService.selectById(id);
	}
	@GetMapping("/create")
	@ResponseBody
	public Boolean create(String name){
		Student student = new Student();
		student.setName(name);
		student.setAge(new Random().nextInt(100));
		student.setBrithday(new Date());
		student.setSchool("清华大学");
		student.setSex(Sex.MALE);
		student.setType(Type.ELEMENTARY_SCHOOL_STUDENT);
		return studentService.insert(student);
	}
}
