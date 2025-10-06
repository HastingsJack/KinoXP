package org.example.kinoxp.services;

import jakarta.validation.Valid;
import org.example.kinoxp.dtos.userDto.LoginRequestDto;
import org.example.kinoxp.dtos.userDto.UserDto;
import org.example.kinoxp.exceptions.UserNotFoundException;
import org.example.kinoxp.mappers.UserMapper;
import org.example.kinoxp.models.User;
import org.example.kinoxp.repositories.UserRepository;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class UserService {
    private final UserMapper userMapper;
    private final PasswordEncoder passwordEncoder;
    private final UserRepository userRepository;

    public UserService(UserMapper userMapper, UserRepository userRepository, PasswordEncoder passwordEncoder) {
        this.userMapper = userMapper;
        this.passwordEncoder = passwordEncoder;
        this.userRepository = userRepository;
    }

    public UserDto createUser(UserDto userDto) {
        userDto.setPassword(passwordEncoder.encode(userDto.getPassword()));
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

    public UserDto getUser(Integer id) {
        var user = userRepository.findById(id).orElse(null);
        var userDto = userMapper.toUserDto(user);
        return userDto;
    }

    // Don't know if this is smart
    public Optional<User> checkCredentials(LoginRequestDto request){
        // I'll handle the optional in authentication service
        return userRepository.findUserByEmail(request.getEmail());
    }
}
