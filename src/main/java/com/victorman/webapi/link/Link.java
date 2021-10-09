package com.victorman.webapi.link;

import javax.persistence.*;
import java.sql.Timestamp;


@Entity
@Table(name = "links")
public class Link {

    @Id
    @SequenceGenerator(name = "LinkIdSequence", sequenceName = "LinkIdSequence", allocationSize = 1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "LinkIdSequence")
    private Long id;

    @Column
    private String originalLink;

    @Column(unique = true)
    private String shortLink;

    @Column
    private Timestamp timeCreated;

    @Column
    private Timestamp timeExcision;

    @Column
    private String passcode;

    @Column
    private Long ownerId;

    public Link() {

    }

    public Link(Long id, String originalLink, String shortLink,
                Timestamp timeCreated, Timestamp timeExcision,
                String passcode, Long ownerId) {
        this.id = id;
        this.originalLink = originalLink;
        this.shortLink = shortLink;
        this.timeCreated = timeCreated;
        this.timeExcision = timeExcision;
        this.passcode = passcode;
        this.ownerId = ownerId;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getOriginalLink() {
        return originalLink;
    }

    public void setOriginalLink(String originalLink) {
        this.originalLink = originalLink;
    }

    public String getShortLink() {
        return shortLink;
    }

    public Long getOwnerId() {
        return ownerId;
    }

    public void setOwnerId(Long ownerId) {
        this.ownerId = ownerId;
    }

    public void setShortLink(String shortLink) {
        this.shortLink = shortLink;
    }

    public Timestamp getTimeCreated() {
        return timeCreated;
    }

    public void setTimeCreated(Timestamp timeCreated) {
        this.timeCreated = timeCreated;
    }

    public Timestamp getTimeExcision() {
        return timeExcision;
    }

    public void setTimeExcision(Timestamp timeExcision) {
        this.timeExcision = timeExcision;
    }

    public String getPasscode() {
        return passcode;
    }

    public void setPasscode(String passcode) {
        this.passcode = passcode;
    }
}
