package com.zenggang.service;

import com.zenggang.model.User;

import java.util.List;

public interface UserService {
    List<User> findAll();

    User get(int id);

    int add(User user);

    int update(User user);

    int delete(int id);
}
