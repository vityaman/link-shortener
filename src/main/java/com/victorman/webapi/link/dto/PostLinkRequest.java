package com.victorman.webapi.link.dto;


import com.victorman.webapi.user.dto.UserAccessData;


public class PostLinkRequest {

    private UserAccessData userAccessData;
    private String link;
    private String passcode;
    private Long timeExcision;

    public PostLinkRequest(UserAccessData userAccessData,
                           String link,
                           String passcode, Long timeExcision) {
        this.userAccessData = userAccessData;
        this.link = link;
        this.passcode = passcode;
        this.timeExcision = timeExcision;
    }

    public UserAccessData getUserAccessData() {
        return userAccessData;
    }

    public void setUserAccessData(UserAccessData userAccessData) {
        this.userAccessData = userAccessData;
    }

    public String getLink() {
        return link;
    }

    public void setLink(String link) {
        this.link = link;
    }

    public String getPasscode() {
        return passcode;
    }

    public void setPasscode(String passcode) {
        this.passcode = passcode;
    }

    public Long getTimeExcision() {
        return timeExcision;
    }

    public void setTimeExcision(Long timeExcision) {
        this.timeExcision = timeExcision;
    }
}
