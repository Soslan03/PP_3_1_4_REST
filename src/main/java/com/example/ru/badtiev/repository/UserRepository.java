package com.example.ru.badtiev.repository;

import com.example.ru.badtiev.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface UserRepository extends JpaRepository<User, Long> {
    @Query("select u from User u JOIN FETCH u.roles where u.email = :email")
    User findByEmail(String email);
}
