package com.exam.service;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.exam.entity.Student;

import java.util.List;

public interface StudentService {

    List<Student> findAll();

    IPage<Student> findAll(Page<Student> page);

    Student findById(Integer studentId);

    int deleteById(Integer studentId);

    Student findByNumber(String number);

    int deleteByNumber(String number);

    int update(Student student);

    int updatePwd(Student student);

    int add(Student student);
}
