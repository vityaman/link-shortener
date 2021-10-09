package com.victorman.webapi.user;

import com.victorman.webapi.user.dto.ChangeUserPasswordRequest;
import com.victorman.webapi.user.dto.ChangeUserPasswordResponse;
import com.victorman.webapi.user.dto.SignUpUserRequest;
import com.victorman.webapi.user.dto.SignUpUserResponse;
import com.victorman.webapi.user.error.AccessDeniedException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserService {

    @Autowired
    private UserStorageManager userStorageManager;

    public SignUpUserResponse signUpUser(SignUpUserRequest request) {
        User user = userStorageManager.saveCreateUser(
                request.getUsername(), request.getPassword());

        return new SignUpUserResponse(
                userStorageManager.getUserIdEncryptor().encrypt(user.getId())
        );
    }

    public ChangeUserPasswordResponse changeUserPassword(ChangeUserPasswordRequest request) {
        if (request.getUserAccessData() == null) {
            throw new AccessDeniedException();
        }

        User user = userStorageManager.getUserByAccessData(request.getUserAccessData());
        userStorageManager.updatePasswordById(user.getId(), request.getNewPassword());

        return new ChangeUserPasswordResponse();
    }
}
