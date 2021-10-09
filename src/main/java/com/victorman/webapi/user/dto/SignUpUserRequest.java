package com.victorman.webapi.user.dto;

public class SignUpUserRequest {
    private String username;
    private String password;

    public SignUpUserRequest(String username, String password) {
        this.username = username;
        this.password = password;
    }

    public String getUsername() {
        return username;
    }

    public String getPassword() {
        return password;
    }
}
