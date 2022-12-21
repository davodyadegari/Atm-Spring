package com.example.sample.service.impl;

import com.example.sample.Exeptions.AgeException;
import com.example.sample.Exeptions.InvalidInputException;
import com.example.sample.Exeptions.NotComplteRequest;
import com.example.sample.Exeptions.NotFoundException;
import com.example.sample.entity.User;
import com.example.sample.repository.UserRepository;
import com.example.sample.service.UserService;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;
import java.util.Objects;
import java.util.Optional;

@Service
public class UserServiceImple implements UserService {
    private final UserRepository userRepository;

    public UserServiceImple(UserRepository userRepository) {
        this.userRepository = userRepository;
    }
    @Override
    public Optional<User> findByNationalCode(String nationalCode){
        if(Objects.isNull(nationalCode)||Objects.equals(nationalCode,"")){
            throw new NotComplteRequest();
        }
       return userRepository.findByNationalCode(nationalCode);
    }
    @Override
    public Optional<User> findById(Long id){
        return userRepository.findById(id);
    }
    @Override
    public void deleteByName(String name){
        userRepository.deleteByName(name);
    }
    @Override
    public User createUser(Long id,String name, String family, String nationalCode, LocalDate birthDay) {


        if (userRepository.findByNationalCode(nationalCode).isPresent()){
            throw new InvalidInputException();
        }

        if (birthDay.getYear() < 18)
            throw new AgeException();
        User user = new User(id,name, family, nationalCode, birthDay);

        return userRepository.save(user);
    }
    @Override
    public User findAccountByNationalCode(String nationalCode) {

        return userRepository.findByNationalCode(nationalCode).orElseThrow(()->{throw new NotFoundException();
        }) ;
    }
    @Override
    public void save(User user){
      userRepository.save(user);
    }

    @Override
    public List<User> findAll() {
        return userRepository.findAll();
    }
}