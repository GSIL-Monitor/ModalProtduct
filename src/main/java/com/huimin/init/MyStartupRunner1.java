package com.huimin.init;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.core.env.Environment;
import org.springframework.stereotype.Component;

import com.huimin.config.routingdatasource.DynamicDataSource;
import com.huimin.entity.Student;
import com.huimin.service.StudentService;
import com.zaxxer.hikari.HikariDataSource;

@Component
public class MyStartupRunner1 implements CommandLineRunner{

	public final static Map<Integer, Student> INIT = new HashMap<>();
	
	@Autowired
	private StudentService service;
	
	@Autowired
	private DynamicDataSource dataSource;
	@Autowired
	private Environment environment;
	
	@Autowired
	private Student student1;
	@Autowired
	private Student student2;
	@Override
	public void run(String... args) throws Exception {
		String[] activeProfiles = environment.getActiveProfiles();
		for (String str : activeProfiles) {
			System.out.println(str);
		}
		String property = environment.getProperty("test.mydatasource.name");
		System.out.println(property);
		List<Student> students = service.selectList(null);
		for (Student student : students) {
		   INIT.put(student.getId(), student);
		}
		HikariDataSource source = (HikariDataSource) dataSource.determineTargetDataSource();
		System.out.println(source);
		System.out.println(source.getIdleTimeout());
		System.out.println(source.getConnectionTimeout());
		System.out.println(source.getMaximumPoolSize());
		System.out.println(source.getDataSourceProperties());
		System.out.println("-----------------------------------------");
		System.out.println(student1);
		System.out.println(student2);
	}
   
	public  Student get(Integer key){
		return INIT.get(key);
	}
}
