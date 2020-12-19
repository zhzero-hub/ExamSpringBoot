package com.exam.service;

import com.exam.entity.Admin;
import com.exam.entity.Student;
import com.exam.entity.Teacher;

public interface LoginService {

    /**
     * 管理员登录
     * @param username 用户名
     * @param password 密码
     * @return 验证成功时返回用户信息，失败返回null
     */
    Admin adminLogin(String username, String password);

    /**
     * 教室登录
     * @param username 用户名
     * @param password 密码
     * @return 验证成功时返回用户信息，失败返回null
     */
    Teacher teacherLogin(String username, String password);

    /**
     * 学生登录
     * @param username 用户名
     * @param password 密码
     * @return 验证成功时返回用户信息，失败返回null
     */
    Student studentLogin(String username, String password);
}
