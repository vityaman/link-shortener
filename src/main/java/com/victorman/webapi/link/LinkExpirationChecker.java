package com.victorman.webapi.link;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;


@EnableScheduling
@Component
public class LinkExpirationChecker {

    private static final long CHECKING_RATE = 1000 * 60 * 60;

    @Autowired
    private LinkRepository linkRepository;

    //

    @Scheduled(fixedRate = CHECKING_RATE)
    public int deleteExpiredLinks() {
        // TODO: delete debug info
        System.out.println("===== Let's delete expired links! =====");
        return linkRepository.deleteAllExpired();
    }
}
