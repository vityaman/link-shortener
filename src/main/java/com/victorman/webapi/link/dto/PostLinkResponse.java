package com.victorman.webapi.link.dto;


public class PostLinkResponse {

    private String shortLink;
    private Long timeExcision;

    public PostLinkResponse(String shortLink, Long timeExcision) {
        this.shortLink = shortLink;
        this.timeExcision = timeExcision;
    }

    public PostLinkResponse() {

    }

    public PostLinkResponse(Integer status) {
        this.shortLink = null;
    }

    public void setShortLink(String shortLink) {
        this.shortLink = shortLink;
    }

    public Long getTimeExcision() {
        return timeExcision;
    }

    public void setTimeExcision(Long timeExcision) {
        this.timeExcision = timeExcision;
    }

    public String getShortLink() {
        return shortLink;
    }
}
