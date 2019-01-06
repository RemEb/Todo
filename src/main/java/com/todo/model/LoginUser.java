package com.todo.model;

import java.util.*;

/**
 * 登录用户模型，封装用户的基础信息
 */
public class LoginUser {

    /**
     * Default constructor
     */
    public LoginUser() {
    }

    /**
     *
     */
    public String userId;

    /**
     *
     */
    public String email;

    /**
     *
     */
    public Date regTime;

    /**
     *
     */
    public boolean gender;

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Date getRegTime() {
        return regTime;
    }

    public void setRegTime(Date regTime) {
        this.regTime = regTime;
    }

    public boolean isGender() {
        return gender;
    }

    public void setGender(boolean gender) {
        this.gender = gender;
    }

    public Date getBirthday() {
        return birthday;
    }

    public void setBirthday(Date birthday) {
        this.birthday = birthday;
    }

    public String getNickName() {
        return nickName;
    }

    public void setNickName(String nickName) {
        this.nickName = nickName;
    }

    public String getAvatar() {
        return avatar;
    }

    public void setAvatar(String avatar) {
        this.avatar = avatar;
    }

    public String getSlogan() {
        return slogan;
    }

    public void setSlogan(String slogan) {
        this.slogan = slogan;
    }

    /**
     *
     */
    public Date birthday;

    /**
     *
     */
    public String nickName;

    /**
     *
     */
    public String avatar;

    /**
     *
     */
    public String slogan;

}