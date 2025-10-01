package org.example.kinoxp.controllers;

import jakarta.validation.Valid;
import org.example.kinoxp.dto.UserDto;
import org.example.kinoxp.services.UserService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/admin")
public class AdminController {


    private final UserService userService;

    public AdminController(UserService userService) {
        this.userService = userService;
    }

    @PostMapping("/create")
    public ResponseEntity<UserDto> createUser(
            @Valid @RequestBody UserDto request) {


        var response = userService.createUser(request);
        return ResponseEntity.status(HttpStatus.CREATED).body(response);
    }

    @PutMapping("/update/{id}")
    public ResponseEntity<UserDto> updateUser(
            @Valid @RequestBody UserDto request,
            @PathVariable Integer id) {

        var response = userService.updateUser(id, request);
        return ResponseEntity.ok( response);

    }

    @DeleteMapping("delete/{id}")
    public ResponseEntity<UserDto> deleteUser(@PathVariable Integer id){
        var response = userService.deleteUser(id);
        return ResponseEntity.ok(( response));
    }


}
