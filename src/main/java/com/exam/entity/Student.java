package com.exam.entity;

public class Student extends User{
    private String grade;
    private String major;
    private String clazz;
    private String institute;

    public Integer getStudentId() {
        return getUserId();
    }

    public void setStudentId(Integer studentId) {
        setUserId(studentId);
    }

    public String getStudentName() {
        return getName();
    }

    public void setStudentName(String studentName) {
        setName(studentName);
    }

    public String getGrade() {
        return grade;
    }

    public void setGrade(String grade) {
        this.grade = grade == null ? null : grade.trim();
    }

    public String getMajor() {
        return major;
    }

    public void setMajor(String major) {
        this.major = major == null ? null : major.trim();
    }

    public String getClazz() {
        return clazz;
    }

    public void setClazz(String clazz) {
        this.clazz = clazz == null ? null : clazz.trim();
    }

    public String getInstitute() {
        return institute;
    }

    public void setInstitute(String institute) {
        this.institute = institute == null ? null : institute.trim();
    }

}