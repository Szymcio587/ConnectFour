package com.example.demo.api;

import com.example.demo.data.user.User;
import com.example.demo.data.user.UserDao;
import java.time.LocalDateTime;

public class UserService {
    private UserDao userDao = new UserDao();

    public void register(UserRegistration userRegistration) {
        User userToSave = UserMapper.map(userRegistration);
        userDao.saveUser(userToSave);
        userDao.saveUserRole(userToSave);
    }

    public boolean login(UserRegistration userRegistration) {
        User userToCheck = UserMapper.map(userRegistration);
        return userDao.checkUser(userToCheck);
    }

    private static class UserMapper {
        static User map(UserRegistration userRegistration) {
            return new User(
                    userRegistration.getUsername(),
                    userRegistration.getEmail(),
                    userRegistration.getPassword(),
                    LocalDateTime.now()
            );
        }
    }
}