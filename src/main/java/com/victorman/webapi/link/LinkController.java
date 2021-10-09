package com.victorman.webapi.link;

import com.victorman.webapi.link.dto.DeleteLinkRequest;
import com.victorman.webapi.link.dto.DeleteLinkResponse;
import com.victorman.webapi.link.dto.PostLinkRequest;
import com.victorman.webapi.link.dto.PostLinkResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("api/link")
public class LinkController {

    @Autowired
    private LinkService linkService;

    @PostMapping("/post")
    @ResponseBody
    public ResponseEntity<PostLinkResponse> post(@RequestBody PostLinkRequest request) {
        return new ResponseEntity<>(
                linkService.postLink(request),
                HttpStatus.OK);
    }

    @DeleteMapping("/delete")
    @ResponseBody
    public ResponseEntity<DeleteLinkResponse> delete(@RequestBody DeleteLinkRequest request) {
        return new ResponseEntity<>(
                linkService.deleteLink(request),
                HttpStatus.OK);
    }
}
