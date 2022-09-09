package com.example.ru.badtiev.service;

import com.example.ru.badtiev.model.Role;

import java.util.Set;

public interface RoleService {

    Set<Role> findAll();

    Role findByName(String name);

    void save(Role role);

    Role findById(Long id);

}