package com.victorman.webapi.user.error;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(code = HttpStatus.FORBIDDEN, reason = "Access denied")
public class AccessDeniedException extends RuntimeException {
    public AccessDeniedException(Throwable cause) {
        super("Access denied", cause);
    }
    public AccessDeniedException() {
        super("Access denied");
    }
}
