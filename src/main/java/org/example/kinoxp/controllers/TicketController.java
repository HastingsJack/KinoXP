package org.example.kinoxp.controllers;


import lombok.AllArgsConstructor;
import org.example.kinoxp.dtos.ticketDtos.RegisterTicketDto;
import org.example.kinoxp.dtos.ticketDtos.TicketDto;
import org.example.kinoxp.services.TicketService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

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

    @PostMapping
    public ResponseEntity<TicketDto> createTicket(@RequestBody RegisterTicketDto request){

        TicketDto ticketDto = ticketService.createTicket(request);

        return ResponseEntity.status(HttpStatus.CREATED).body(ticketDto);
    }
}
