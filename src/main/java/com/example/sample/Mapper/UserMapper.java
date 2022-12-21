package com.example.sample.Mapper;

import com.example.sample.dto.UserDto;
import com.example.sample.entity.User;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class UserMapper {
    public static List<UserDto> userToUserDto(List<User> users){
        List<UserDto>userDtos=new ArrayList<>();
        users.forEach(u->{
           userDtos.add(new UserDto(u.getName(),u.getFamily(),u.getAge(),u.getNationalCode(),u.getBirthDate()));
        });
        return userDtos;
    }
    public static Optional<UserDto> userToUserDto1(Optional<User> user){

        Optional<UserDto>optionalUserDto= Optional.of(new UserDto(user.get().getName(), user.get().getFamily(), user.get().getAge(), user.get().getNationalCode(), user.get().getBirthDate()));
        return optionalUserDto;
    }
    public static User toEntity(UserDto userDto){
        return new User(null,userDto.getName(),userDto.getFamily(), userDto.getAge(),userDto.getNationalCode(),userDto.getBirthday());
    }
    public static UserDto userToUserDto2(User user){
        return new UserDto(user.getName(),user.getFamily(),user.getAge(),user.getNationalCode(),user.getBirthDate());
    }
}