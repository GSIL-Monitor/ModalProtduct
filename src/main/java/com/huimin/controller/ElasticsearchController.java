package com.huimin.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.huimin.elasticsearch.StudentModel;
import com.huimin.elasticsearch.common.Model;
import com.huimin.elasticsearch.common.ModelRepository;

@RestController
@RequestMapping("/es")
public class ElasticsearchController {

	@Autowired
	private ModelRepository modelRepository;
	@PostMapping("/insert")
	public void insert(@RequestBody StudentModel studentModel) {
		modelRepository.insert(studentModel);
	}
	@PostMapping("/getById")
	public Model getById(@RequestBody StudentModel studentModel) {
		return modelRepository.getById(studentModel);
	}
	@PostMapping("/getByType")
	public List<? extends Model> getByType() {
		return modelRepository.getByType(new StudentModel());
	}
	@PostMapping("/update")
	public void update(@RequestBody StudentModel studentModel) {
		 modelRepository.update(studentModel);
	}
	@PostMapping("/delete")
	public void delete(@RequestBody StudentModel studentModel) {
		modelRepository.delete(studentModel);
	}
}
