package com.example.demo.data.api;

import com.example.demo.data.UserDao;
import com.example.demo.data.User;

import java.util.List;
import java.util.stream.Collectors;

public class UserService {
    private final UserDao userDao = new UserDao();

    public List<UserBasicInfo> findAll() {
        return userDao.findAll()
                .stream().map(UserMapper::map)
                .collect(Collectors.toList());
    }

    private static class UserMapper {
        static UserBasicInfo map(User d) {
            return new UserBasicInfo(
                    d.getUsername(),
                    d.getPassword(),
                    d.getEmail(),
                    d.getRegistrationDate()
            );
        }
    }
}