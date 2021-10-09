package com.victorman.webapi.user;

import com.victorman.webapi.user.dto.ChangeUserPasswordRequest;
import com.victorman.webapi.user.dto.ChangeUserPasswordResponse;
import com.victorman.webapi.user.dto.SignUpUserRequest;
import com.victorman.webapi.user.dto.SignUpUserResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("api/user")
public class UserController {

    @Autowired
    private UserService userService;

    @PostMapping("/signUp")
    @ResponseBody
    public ResponseEntity<SignUpUserResponse> signUp(@RequestBody SignUpUserRequest request) {
        return new ResponseEntity<>(
                userService.signUpUser(request),
                HttpStatus.OK);
    }

    @PutMapping("/changePassword")
    @ResponseBody
    public ResponseEntity<ChangeUserPasswordResponse> changePassword(@RequestBody ChangeUserPasswordRequest request) {
        return new ResponseEntity<>(
                userService.changeUserPassword(request),
                HttpStatus.OK
        );
    }
}
