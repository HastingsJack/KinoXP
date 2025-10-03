package org.example.kinoxp.controllers;

import jakarta.validation.Valid;
import org.example.kinoxp.dto.UserDto;
import org.example.kinoxp.services.UserService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/admin")
public class AdminController {


    private final UserService userService;

    public AdminController(UserService userService) {
        this.userService = userService;
    }

    @CrossOrigin
    @GetMapping("/users")
    public List<UserDto> getUsers() {
        var userDtos = userService.getAllUserDto();
        return userDtos;
    }

    @CrossOrigin
    @GetMapping("users/{id}")
    public UserDto getUser(@PathVariable Integer id) {
        var userDto = userService.getUser(id);
        return userDto;
    }


    @CrossOrigin(origins = "*")
    @PostMapping("/create")
    public ResponseEntity<UserDto> createUser(
            @Valid @RequestBody UserDto request) {


        var response = userService.createUser(request);
        return ResponseEntity.status(HttpStatus.CREATED).body(response);
    }

    @CrossOrigin(origins = "*")
    @PutMapping("/update/{id}")
    public ResponseEntity<UserDto> updateUser(
            @Valid @RequestBody UserDto request,
            @PathVariable Integer id) {

        var response = userService.updateUser(id, request);
        return ResponseEntity.ok( response);

    }

    @CrossOrigin(origins = "*")
    @DeleteMapping("delete/{id}")
    public ResponseEntity<UserDto> deleteUser(@PathVariable Integer id){
        var response = userService.deleteUser(id);
        return ResponseEntity.ok(( response));
    }


}
