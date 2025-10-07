package org.example.kinoxp.controllers;

import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import org.example.kinoxp.dtos.userDto.LoginRequestDto;
import org.example.kinoxp.dtos.userDto.LoginResponseDto;
import org.example.kinoxp.exceptions.AuthWrongCredentialsException;
import org.example.kinoxp.exceptions.UserNotFoundException;
import org.example.kinoxp.services.AuthService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

@AllArgsConstructor

@CrossOrigin("*")
@RestController
@RequestMapping("auth")
public class AuthController {
    private final AuthService authService;

    @PostMapping("login")
    public ResponseEntity<LoginResponseDto> login(
            @Valid @RequestBody LoginRequestDto request){
        var user = authService.checkCredentials(request);
        return ResponseEntity.ok(user);
    }


    @ExceptionHandler(AuthWrongCredentialsException.class)
    public ResponseEntity<Map<String,String>> handleException(AuthWrongCredentialsException e) {
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(
                Map.of("error", "Wrong username or password")
        );
    }
}
