package org.example.kinoxp.services;

import jakarta.validation.Valid;
import org.example.kinoxp.dto.UserDto;
import org.example.kinoxp.exceptions.UserNotFoundException;
import org.example.kinoxp.mappers.UserMapper;
import org.example.kinoxp.repositories.UserRepository;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class UserService {


    private final UserMapper userMapper;
    private final UserRepository userRepository;

    public UserService(UserMapper userMapper, UserRepository userRepository) {
        this.userMapper = userMapper;
        this.userRepository = userRepository;
    }

    public UserDto createUser(UserDto userDto) {
        var user = userMapper.toUserModel(userDto);
        var saved = userRepository.save(user);
        userRepository.save(user);
        userDto.setId(saved.getId());

        return userDto;
    }

    public UserDto updateUser(Integer id, @Valid UserDto request) {
        var user = userRepository.findById(id).orElse(null);
        if (user == null) {
            throw new UserNotFoundException("User not found");
        }
        request.setId(user.getId());
        userMapper.update(request,user);
        userRepository.save(user);

        return request;
    }

    public UserDto deleteUser(Integer id) {
        var user = userRepository.findById(id).orElse(null);
        if (user == null) {
            throw new UserNotFoundException("User not found");
        }
        userRepository.delete(user);
        return userMapper.toUserDto(user);
    }

    public List<UserDto> getAllUserDto() {
        var users = userRepository.findAll();
        var userDtos = new ArrayList<UserDto>();
        for (var user : users) {
            var userDtoTemp = userMapper.toUserDto(user);
            userDtos.add(userDtoTemp);
        }
        if (users.isEmpty()) {
            throw new UserNotFoundException("Users not found");
        }
        return userDtos;
    }
}
