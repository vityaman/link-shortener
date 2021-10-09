package com.victorman.webapi.user;

import com.victorman.webapi.user.dto.UserAccessData;
import com.victorman.webapi.user.error.AccessDeniedException;
import com.victorman.webapi.user.error.UserNotFoundException;
import com.victorman.webapi.util.NumberEncryptor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.lang.NonNull;
import org.springframework.stereotype.Component;

@Component
public class UserStorageManager {

    private static final Long USER_ID_ENCRYPTION_SECRET_KEY = 0x43758348L;

    @Autowired
    private UserRepository userRepository;

    private PasswordEncryptor passwordEncryptor;
    private NumberEncryptor userIdEncryptor;

    public UserStorageManager() {
        this.passwordEncryptor = new PasswordEncryptor();
        this.userIdEncryptor = new NumberEncryptor(USER_ID_ENCRYPTION_SECRET_KEY);
    }

    public User saveCreateUser(String username, String password) {

        User user = new User();
        user.setName(username);
        user.setPasswordHash(passwordEncryptor.encrypt(password));

        return userRepository.save(user);
    }

    public NumberEncryptor getUserIdEncryptor() {
        return userIdEncryptor;
    }

    public User getUserByAccessData(@NonNull UserAccessData accessData) {
        Long userId = userIdEncryptor.decrypt(accessData.getLogin());
        String givenPassword = accessData.getPassword();

        User user = userRepository.findById(userId)
                .orElseThrow(() -> new UserNotFoundException());

        if (!passwordEncryptor.checkPassword(givenPassword, user.getPasswordHash())) {
            throw new AccessDeniedException();
        }

        return user;
    }

    public void updatePasswordById(Long userId, String newPassword) {
        userRepository.setPasswordHashById(
                userId,
                passwordEncryptor.encrypt(newPassword));
    }
}
