package com.victorman.webapi.link;

import com.victorman.webapi.link.dto.DeleteLinkRequest;
import com.victorman.webapi.link.dto.DeleteLinkResponse;
import com.victorman.webapi.link.dto.PostLinkRequest;
import com.victorman.webapi.link.dto.PostLinkResponse;
import com.victorman.webapi.user.User;
import com.victorman.webapi.user.UserStorageManager;
import com.victorman.webapi.user.error.AccessDeniedException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.sql.Timestamp;
import java.util.Objects;

@Service
public class LinkService {

    @Autowired
    private LinkStorageManager linkStorageManager;

    @Autowired
    private UserStorageManager userStorageManager;


    public PostLinkResponse postLink(PostLinkRequest request) {

        Long ownerId = null;
        if (request.getUserAccessData() != null) {
            // throws an exception if wrong accessData
            ownerId = userStorageManager
                            .getUserByAccessData(request.getUserAccessData())
                            .getId();
        }


        Link link = linkStorageManager.saveCreateLink(
                ownerId, request.getLink(),
                request.getPasscode(), null);

        if (request.getTimeExcision() != null) {
            link.setTimeExcision(new Timestamp(request.getTimeExcision()));
        }

        if (link.getTimeExcision() != null) {
            return new PostLinkResponse(link.getShortLink(), link.getTimeExcision().getTime());
        } else {
            return new PostLinkResponse(link.getShortLink(), null);
        }
    }


    public DeleteLinkResponse deleteLink(DeleteLinkRequest request) {
        if (request.getUserAccessData() == null) {
            throw new AccessDeniedException();
        }

        User givenLinkOwner = userStorageManager.getUserByAccessData(request.getUserAccessData());

        Link link = linkStorageManager.findByShorten(request.getShortLink());

        if (!link.getOwnerId().equals(givenLinkOwner.getId())) {
            throw new AccessDeniedException();
        }

        this.linkStorageManager.deleteById(link.getId());

        return new DeleteLinkResponse();
    }
}
