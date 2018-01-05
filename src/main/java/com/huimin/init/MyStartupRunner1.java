package com.huimin.init;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import com.huimin.entity.Student;
import com.huimin.service.StudentService;

@Component
public class MyStartupRunner1 implements CommandLineRunner{

	public final static Map<Integer, Student> INIT = new HashMap<>();
	
	@Autowired
	private StudentService service;
	@Override
	public void run(String... args) throws Exception {
		List<Student> students = service.selectList(null);
		for (Student student : students) {
		   INIT.put(student.getId(), student);
		}
	}
   
	public  Student get(Integer key){
		return INIT.get(key);
	}
}
