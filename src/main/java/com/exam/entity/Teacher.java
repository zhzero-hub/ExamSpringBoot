package com.exam.entity;

import lombok.Data;

public class Teacher extends User{
    private String institute;
    private String type;

    public Integer getTeacherId() {
        return getUserId();
    }

    public void setTeacherId(Integer studentId) {
        setUserId(studentId);
    }

    public String getTeacherName() {
        return getName();
    }

    public void setTeacherName(String teacherName) {
        setName(teacherName);
    }

    public String getInstitute() {
        return institute;
    }

    public void setInstitute(String institute) {
        this.institute = institute;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }
}