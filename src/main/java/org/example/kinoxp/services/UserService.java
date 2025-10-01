package org.example.kinoxp.services;

import org.example.kinoxp.dto.UserDto;
import org.example.kinoxp.mappers.UserMapper;
import org.example.kinoxp.repositories.UserRepository;
import org.springframework.stereotype.Service;

@Service
public class UserService {


    private final UserMapper userMapper;
    private final UserRepository userRepository;

    public UserService(UserMapper userMapper, UserRepository userRepository) {
        this.userMapper = userMapper;
        this.userRepository = userRepository;
    }

    public UserDto createUser(UserDto userDto){
        var user = userMapper.toUserModel(userDto);
        userRepository.save(user);
        userDto.setId(user.getId());

        return userDto;
    }
}
