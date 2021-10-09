package com.victorman.webapi.link;

import com.victorman.webapi.link.error.LinkInvalidTimeExcision;
import com.victorman.webapi.link.error.LinkNotFoundException;
import com.victorman.webapi.util.NumberEncryptor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.sql.Timestamp;
import java.time.LocalDateTime;

@Component
public class LinkStorageManager {

    private final long LINK_ENCRYPTION_SECRET_KEY = 0x3676356756L;

    private NumberEncryptor linkEncryptor;

    @Autowired
    private LinkRepository linkRepository;

    public LinkStorageManager() {
        this.linkEncryptor = new NumberEncryptor(LINK_ENCRYPTION_SECRET_KEY);
    }

    public Link saveCreateLink(Long ownerId, String originalLink,
                               String passcode,
                               Timestamp timestampExcision) {

        // Create link
        Link link = new Link();

        link.setOriginalLink(originalLink);
        link.setTimeCreated(Timestamp.valueOf(LocalDateTime.now()));
        link.setPasscode(passcode);
        link.setTimeExcision(timestampExcision);
        link.setOwnerId(ownerId);

        // Verify link
        if(link.getTimeExcision() != null && link.getTimeExcision().compareTo(link.getTimeCreated()) < 0) {
            throw new LinkInvalidTimeExcision();
        }

        Long nextLinkId = getNextLinkId();

        // Encode link
        link.setShortLink(linkEncryptor.encrypt(nextLinkId));

        link = linkRepository.save(link);
        // Note: should be link.id == nextLinkId
        return link;
    }

    public Link findByShorten(String shortLink) {
        return linkRepository.findById(
                linkEncryptor.decrypt(shortLink)
                ).orElseThrow(() -> new LinkNotFoundException());
    }

    public void deleteById(Long id) {
        this.linkRepository.deleteById(id);
    }

    public Long getNextLinkId() {
        return linkRepository.getNextLinkId() + 1;
    }
}
