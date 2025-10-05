package org.example.kinoxp.controllers;


import lombok.AllArgsConstructor;
import org.example.kinoxp.dtos.TicketDto;
import org.example.kinoxp.services.TicketService;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@AllArgsConstructor
@RestController
@RequestMapping("/tickets")
@CrossOrigin("*")
public class TicketController {

    private final TicketService ticketService;

    @GetMapping
    public List<TicketDto> getAll(){
        return null;
    }
}
