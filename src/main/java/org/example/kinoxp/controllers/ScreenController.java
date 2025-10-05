package org.example.kinoxp.controllers;

import lombok.AllArgsConstructor;
import org.example.kinoxp.dtos.ScreenDto;
import org.example.kinoxp.services.ScreenService;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@AllArgsConstructor

@CrossOrigin("*")
@RestController
@RequestMapping("/screens")
public class ScreenController {
    private final ScreenService screenService;

    @GetMapping
    public List<ScreenDto> getAll(){
        return screenService.getAll();
    }
}
