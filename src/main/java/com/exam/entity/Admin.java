package com.exam.entity;

public class Admin extends User{
    public String getAdminName() {
        return getName();
    }
    public void setAdminName(String name) {
        setName(name);
    }
    public String getPwd() {
        return getPassword();
    }
    public void setPwd(String pwd) {
        setPassword(pwd);
    }
    public Integer getAdminId() {
        return getUserId();
    }
    public void setAdminId(Integer adminId) {
        setUserId(adminId);
    }
}