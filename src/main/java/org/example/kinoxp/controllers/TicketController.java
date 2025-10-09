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
        return ticketService.getAll();
    }

    @GetMapping("/of-showing")
    public List<TicketDto> getByShowing(@RequestParam(name = "showing") Long showing){
        return ticketService.getByShowingId(showing);
    }

    @PostMapping
    public ResponseEntity<TicketDto> createTicket(@RequestBody RegisterTicketDto request){

        TicketDto ticketDto = ticketService.createTicket(request);
        if (ticketDto == null) {
            return ResponseEntity
                    .status(HttpStatus.BAD_REQUEST)
                    .build(); // or include an error message
        }

        return ResponseEntity
                .status(HttpStatus.CREATED)
                .body(ticketDto);
    }



    @PutMapping
    public ResponseEntity<TicketDto> updateTicket(@RequestBody RegisterTicketDto request){
        return null;
    }

    @DeleteMapping("/{id}")
    public boolean deleteTicket(@PathVariable(name = "id") Long id){
        return ticketService.deleteTicket(id);
    }
}
