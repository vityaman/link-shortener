package com.victorman.webapi.user.dto;

public class ChangeUserPasswordRequest {
    private UserAccessData userAccessData;
    private String newPassword;

    public ChangeUserPasswordRequest(UserAccessData userAccessData, String newPassword) {
        this.userAccessData = userAccessData;
        this.newPassword = newPassword;
    }

    public UserAccessData getUserAccessData() {
        return userAccessData;
    }

    public void setUserAccessData(UserAccessData userAccessData) {
        this.userAccessData = userAccessData;
    }

    public String getNewPassword() {
        return newPassword;
    }

    public void setNewPassword(String newPassword) {
        this.newPassword = newPassword;
    }
}
