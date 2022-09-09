package com.example.ru.badtiev.service;

import com.example.ru.badtiev.model.Role;
import com.example.ru.badtiev.repository.RoleRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.HashSet;
import java.util.Set;

@Service
public class RoleServiceImpl implements RoleService {

    private final RoleRepository roleRepository;

    public RoleServiceImpl(RoleRepository roleRepository) {
        this.roleRepository = roleRepository;
    }

    public Set<Role> findAll() {
        return new HashSet<>(roleRepository.findAll());
    }

    public Role findByName(String name) {
        return roleRepository.findByName(name);
    }
    @Transactional
    public void save(Role role) {
        roleRepository.saveAndFlush(role);
    }

    @Override
    public Role findById(Long id) {
        return roleRepository.findById(Math.toIntExact(id)).orElse(null);
    }
}
