package com.victorman.webapi.user.dto;

public class UserAccessData {

    private String login;
    private String password;

    public UserAccessData(String userLogin, String password) {
        this.login = userLogin;
        this.password = password;
    }

    public String getLogin() {
        return login;
    }

    public String getPassword() {
        return password;
    }
}
