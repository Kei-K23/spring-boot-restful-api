package com.github.keik23.springbootRestfulApi.mapper;

import org.springframework.stereotype.Component;
import com.github.keik23.springbootRestfulApi.dtos.CreateUserDto;
import com.github.keik23.springbootRestfulApi.dtos.UserDto;
import com.github.keik23.springbootRestfulApi.entities.User;

@Component
public class UserMapper {
    public UserDto toDto(User user) {
        return UserDto.builder()
                .id(user.getId())
                .username(user.getUsername())
                .email(user.getEmail())
                .createdAt(user.getCreatedAt())
                .updatedAt(user.getUpdatedAt())
                .build();
    }

    public User toEntity(CreateUserDto userDto) {
        return User.builder()
                .username(userDto.getUsername())
                .email(userDto.getEmail())
                .password(userDto.getPassword())
                .build();
    }
}
