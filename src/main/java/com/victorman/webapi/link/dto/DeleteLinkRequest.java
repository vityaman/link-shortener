package com.victorman.webapi.link.dto;

import com.victorman.webapi.user.dto.UserAccessData;

public class DeleteLinkRequest {
    private UserAccessData userAccessData;
    private String shortLink;

    public DeleteLinkRequest() {}

    public UserAccessData getUserAccessData() {
        return userAccessData;
    }

    public void setUserAccessData(UserAccessData userAccessData) {
        this.userAccessData = userAccessData;
    }

    public String getShortLink() {
        return shortLink;
    }

    public void setShortLink(String shortLink) {
        this.shortLink = shortLink;
    }
}
