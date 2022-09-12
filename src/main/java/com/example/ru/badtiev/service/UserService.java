package com.example.ru.badtiev.service;

import com.example.ru.badtiev.model.User;

import java.util.List;

public interface UserService {
    List<User> findAll();
    void saveUser(User user);
    void deleteById(Long id);

    User findById(Long id);

    void updateUser(User user);

}
