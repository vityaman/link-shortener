package com.victorman.webapi.index;

import org.apache.coyote.Response;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.query.Param;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.view.RedirectView;

@Controller
public class IndexController {

    @Autowired
    private IndexService indexService;

    @GetMapping("s/{shortLink}")
    public RedirectView redirect(@PathVariable String shortLink,
                                 @RequestParam(required = false) String passcode) {
        return new RedirectView(indexService.getOriginalLinkByShorten(shortLink, passcode));
    }

    @GetMapping("signUp")
    public String signUp() {
        return "sign-up";
    }
}
