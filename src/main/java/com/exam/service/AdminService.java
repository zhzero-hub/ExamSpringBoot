package com.exam.service;

import com.exam.entity.Admin;

import java.util.List;

public interface AdminService{

    /**
     * @return 所有管理员
     */
    List<Admin> findAll();

    Admin findById(Integer adminId);

    int deleteById(int adminId);

    int update(Admin admin);

    int add(Admin admin);
}
