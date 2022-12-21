package com.example.sample.Mapper;

import com.example.sample.dto.UserDto;
import com.example.sample.entity.User;
import org.mapstruct.Mapper;

import java.util.List;

@Mapper(componentModel="spring")
public interface UserMapStruct {
    UserDto toUserDto(User user);
    User toUser(UserDto userDto);
    List<User> toUser(List<UserDto> userDtos);
    List<UserDto> toUserDto(List<User>users);
}