package org.example.kinoxp.services;

import lombok.AllArgsConstructor;
import org.example.kinoxp.dtos.userDto.LoginRequestDto;
import org.example.kinoxp.dtos.userDto.LoginResponseDto;
import org.example.kinoxp.exceptions.AuthWrongCredentialsException;
import org.example.kinoxp.mappers.UserMapper;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@AllArgsConstructor

@Service
public class AuthService {
    private final PasswordEncoder passwordEncoder;
    private final UserService userService;
    private final UserMapper userMapper;

    public LoginResponseDto checkCredentials(LoginRequestDto request) {
        var user = userService.checkCredentials(request).orElse(null);
        if(user == null) throw new AuthWrongCredentialsException();

        var passwordCheck = passwordEncoder.matches(request.getPassword(), user.getPassword());
        if(!passwordCheck) throw new AuthWrongCredentialsException();

        return userMapper.toLoginUserResponseDto(user);
    }
}
