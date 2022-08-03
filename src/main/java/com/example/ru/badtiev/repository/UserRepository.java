package com.example.ru.badtiev.repository;

import com.example.ru.badtiev.model.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Long> {
}
