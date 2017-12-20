package com.huimin.service.impl;

import org.springframework.stereotype.Service;

import com.baomidou.mybatisplus.service.impl.ServiceImpl;
import com.huimin.entity.Student;
import com.huimin.mapper.StudentMapper;
import com.huimin.service.StudentService;

@Service
public class StudentServiceImpl extends ServiceImpl<StudentMapper, Student> implements StudentService{

}
