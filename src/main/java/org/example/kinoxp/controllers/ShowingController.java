package org.example.kinoxp.controllers;

import lombok.AllArgsConstructor;
import org.example.kinoxp.dtos.showingDtos.RegisterShowingDto;
import org.example.kinoxp.dtos.showingDtos.ShowingDto;
import org.example.kinoxp.services.ShowingService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin("*")
@AllArgsConstructor
@RestController
@RequestMapping("/showings")
public class ShowingController {
    private final ShowingService showingService;

    // This can take a movieId as a path variable, but it is not required.
    // If we need to filter by movieId, we can add a query parameter.
    // Can be used for Showing search all booking or filter by movieId.
    // Example with movieId: http://localhost:8080/showings?movieId=1
    @GetMapping
    public List<ShowingDto> getAll(
            @RequestParam(required = false, name = "movieId") Long movieId){
        return showingService.getAll(movieId);
    }

    @PostMapping
    public ResponseEntity<ShowingDto> createShowing(@RequestBody RegisterShowingDto request){
        var showingDto = showingService.createShowing(request);

        return ResponseEntity.status(HttpStatus.CREATED).body(showingDto);
    }
}
