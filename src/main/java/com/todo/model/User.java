package com.todo.model;


/**
 * 存放用户的私密信息，一般不对外暴露
 */
public class User extends LoginUser {

    /**
     * Default constructor
     */
    public User() {
    }

    /**
     * 用户密码
     */
    private String pwd;

    /**
     * 
     */
    private String slat;

    /**
     * 
     */
    private String encrypt;

    /**
     * 
     */
    private String lastPwd;

    /**
     * 
     */
    private int pwdLength;

    public String getPwd() {
        return pwd;
    }

    public void setPwd(String pwd) {
        this.pwd = pwd;
    }

    public String getSlat() {
        return slat;
    }

    public void setSlat(String slat) {
        this.slat = slat;
    }

    public String getEncrypt() {
        return encrypt;
    }

    public void setEncrypt(String encrypt) {
        this.encrypt = encrypt;
    }

    public String getLastPwd() {
        return lastPwd;
    }

    public void setLastPwd(String lastPwd) {
        this.lastPwd = lastPwd;
    }

    public int getPwdLength() {
        return pwdLength;
    }

    public void setPwdLength(int pwdLength) {
        this.pwdLength = pwdLength;
    }
}