package com.exam.entity;

/**
 * @author Z_HAO
 */
public abstract class User {
    private Integer UserId;
    private String password;
    private String name;
    private String sex;
    private String tel;
    private String email;
    private String cardId;
    private String role;

    public Integer getUserId() {
        return UserId;
    }

    public void setUserId(Integer userId) {
        UserId = userId;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password == null? null: password.trim();
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name == null? null: name.trim();
    }

    public String getSex() {
        return sex;
    }

    public void setSex(String sex) {
        this.sex = sex == null? null: sex.trim();
    }

    public String getTel() {
        return tel;
    }

    public void setTel(String tel) {
        this.tel = tel == null? null: tel.trim();
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email == null? null: email.trim();
    }

    public String getCardId() {
        return cardId;
    }

    public void setCardId(String cardId) {
        this.cardId = cardId == null? null: cardId.trim();
    }

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role == null? null: role.trim();
    }
}
