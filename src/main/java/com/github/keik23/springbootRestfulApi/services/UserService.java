package com.github.keik23.springbootRestfulApi.services;

import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;

import org.springframework.stereotype.Service;

import com.github.keik23.springbootRestfulApi.dtos.CreateUserDto;
import com.github.keik23.springbootRestfulApi.dtos.UserDto;
import com.github.keik23.springbootRestfulApi.entities.User;
import com.github.keik23.springbootRestfulApi.mapper.UserMapper;
import com.github.keik23.springbootRestfulApi.repository.UserRepository;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class UserService {
    private final UserRepository userRepository;
    private final UserMapper userMapper;

    public List<UserDto> getAllUsers() {
        return userRepository.findAll()
                .stream()
                .map(userMapper::toDto)
                .collect(Collectors.toList());
    }

    public UserDto getUserById(UUID id) {
        User user = userRepository.findById(id).orElseThrow(() -> new IllegalArgumentException("User not found"));
        return userMapper.toDto(user);
    }

    public UserDto createUser(CreateUserDto createUserDto) {
        if (userRepository.existsByEmail(createUserDto.getEmail())) {
            throw new IllegalArgumentException("Email already taken");
        }

        User user = userMapper.toEntity(createUserDto);

        return userMapper.toDto(userRepository.save(user));
    }

    public UserDto updateUserById(UUID id, CreateUserDto createUserDto) {
        User user = userRepository.findById(id).orElseThrow(() -> new IllegalArgumentException("User not found"));

        user.setUsername(createUserDto.getUsername());
        user.setEmail(createUserDto.getEmail());
        user.setPassword(createUserDto.getPassword());

        return userMapper.toDto(userRepository.save(user));
    }

    public void deleteUser(UUID id) {
        User user = userRepository.findById(id).orElseThrow(() -> new IllegalArgumentException("User not found"));

        userRepository.delete(user);
    }
}
