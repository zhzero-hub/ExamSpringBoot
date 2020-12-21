package com.exam.mapper;

import com.exam.entity.Admin;
import com.exam.entity.Student;
import com.exam.entity.Teacher;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Service;

@Mapper
@Service
public interface LoginMapper {

    @Select("select * from admin where adminId = #{username} and pwd = #{password}")
    Admin adminLogin(String username, String password);

    @Select("select * from teacher where teacherId = #{username} and pwd = #{password}")
    Teacher teacherLogin(String username, String password);

    @Select("select * from student where studentNumber = #{username} and pwd = #{password}")
    Student studentLogin(String username, String password);
}
