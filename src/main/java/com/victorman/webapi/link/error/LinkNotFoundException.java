package com.victorman.webapi.link.error;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;


@ResponseStatus(code = HttpStatus.NOT_FOUND, reason = "Link not found")
public class LinkNotFoundException extends RuntimeException { }
