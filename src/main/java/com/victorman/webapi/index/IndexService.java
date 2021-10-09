package com.victorman.webapi.index;

import com.victorman.webapi.link.Link;
import com.victorman.webapi.link.LinkStorageManager;
import com.victorman.webapi.user.error.AccessDeniedException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class IndexService {

    @Autowired
    public LinkStorageManager linkStorageManager;

    public String getOriginalLinkByShorten(String shortLink, String passcode) {
        Link link = linkStorageManager.findByShorten(shortLink);
        if (!link.getPasscode().equals(passcode)) {
            throw new AccessDeniedException();
        }
        return link.getOriginalLink();
    }

}
