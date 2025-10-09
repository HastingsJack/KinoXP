package org.example.kinoxp.controllers;

import lombok.AllArgsConstructor;
import org.example.kinoxp.dtos.snackOrderDtos.RegisterSnackOrderDto;
import org.example.kinoxp.dtos.snackOrderDtos.SnackOrderDto;
import org.example.kinoxp.dtos.ticketDtos.RegisterTicketDto;
import org.example.kinoxp.dtos.ticketDtos.TicketDto;
import org.example.kinoxp.services.SnackOrderService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@AllArgsConstructor
@RequestMapping("/snackorders")
@CrossOrigin("*")
public class SnackOrderController {

    private final SnackOrderService snackOrderService;

    @PostMapping
    public ResponseEntity<SnackOrderDto> createSnackOrder(@RequestBody RegisterSnackOrderDto request){

        SnackOrderDto snackOrderDto = snackOrderService.createSnackOrder(request);

        return ResponseEntity.status(HttpStatus.CREATED).body(snackOrderDto);
    }

    @DeleteMapping("/by-movie/{movieId}")
    public boolean deleteByMovieId(@PathVariable(name = "movieId")  Long movieId){
        return false;
    }
}
