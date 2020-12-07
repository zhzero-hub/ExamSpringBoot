package com.exam.entity;

public class Admin extends User{
    public Integer getAdminId() {
        return getUserId();
    }
    public void setAdminId(Integer adminId) {
        setUserId(adminId);
    }
}