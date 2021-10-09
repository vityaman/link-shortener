package com.victorman.webapi.user.dto;

public class SignUpUserResponse {
    private String userLogin;

    public String getUserLogin() {
        return userLogin;
    }

    public SignUpUserResponse(String userLogin) {
        this.userLogin = userLogin;
    }
}
