package com.victorman.webapi.link.error;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(code = HttpStatus.BAD_REQUEST, reason = "Invalid excision time")
public class LinkInvalidTimeExcision extends RuntimeException { }
