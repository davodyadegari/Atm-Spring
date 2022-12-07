package com.example.sample.service.impl;

import com.example.sample.entity.User;
import com.example.sample.repository.UserRepository;
import com.example.sample.service.UserService;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImple implements UserService {
    private UserRepository userRepository;

    public UserServiceImple(UserRepository userRepository) {
        this.userRepository = userRepository;
    }
    @Override
    public void save(User user){
      userRepository.save(user);
    }
}