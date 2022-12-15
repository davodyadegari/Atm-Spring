package com.example.sample.controller;

import com.example.sample.Mapper.UserMapper;
import com.example.sample.dto.UserDto;
import com.example.sample.entity.User;
import com.example.sample.service.UserService;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
public class UserController {
    private final UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }
    @GetMapping("/users")
    public List<UserDto>findAll(){
        return UserMapper.userToUserDto(userService.findAll());
    }
    @GetMapping("/user")
    public Optional<UserDto> findByName(@RequestParam("full_name") String nationalCode){
return UserMapper.userToUserDto1  (userService.findByNationalCode(nationalCode));
    }
    @PostMapping("/user//")
    public void save(@RequestBody UserDto userDto){
        userService.save( UserMapper.toEntity((userDto)));
    }
}