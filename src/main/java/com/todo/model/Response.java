package com.todo.model;

/**
 * @author Lcy
 * @date 2018/12/26 19:03
 */
public class Response extends LoginUser {

    private String message;

    private String statusCode;

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public String getStatusCode() {
        return statusCode;
    }

    public void setStatusCode(String statusCode) {
        this.statusCode = statusCode;
    }
}
