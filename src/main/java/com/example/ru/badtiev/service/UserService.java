package com.example.ru.badtiev.service;

import com.example.ru.badtiev.model.User;
import com.example.ru.badtiev.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class UserService implements UserDetailsService {
    private final UserRepository userRepository;
    private final BCryptPasswordEncoder encoder = new BCryptPasswordEncoder(12);

    @Autowired
    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }
    public User findByEmail(String email){
        return userRepository.findByEmail(email);
    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        User user = findByEmail(username);
        if (user == null) {
            throw new UsernameNotFoundException(String.format("User '%s' not found", username));
        }
        return new org.springframework.security.core.userdetails.User(user.getUsername(),user.getPassword(),user.getAuthorities());
    }
    public User findById(Long id){
        return userRepository.findById(id).orElse(null);
    }

    public List<User> findAll(){
        return userRepository.findAll();
    }
    @Transactional
    public User saveUser(User user){
        user.setPassword(encoder.encode(user.getPassword()));
        return userRepository.save(user);
    }
    @Transactional
    public void deleteById(Long id){
        userRepository.deleteById(id);
    }
//    @Transactional
//    public void updateUser(User user) {
//        User userFromDb = userRepository.findById(user.getId()).orElse(null);
//        if (!userFromDb.getPassword().equals(user.getPassword())) {
//            user.setPassword(encoder.encode(user.getPassword()));
//        }
//        userRepository.save(user);
//    }
}
