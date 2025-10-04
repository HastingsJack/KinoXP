package org.example.kinoxp.controllers;

import lombok.AllArgsConstructor;
import org.example.kinoxp.dtos.showingDtos.RegisterShowingDto;
import org.example.kinoxp.dtos.showingDtos.ShowingDto;
import org.example.kinoxp.exceptions.MovieNotFoundException;
import org.example.kinoxp.exceptions.ScreenNotFoundException;
import org.example.kinoxp.exceptions.ShowingNotFoundException;
import org.example.kinoxp.services.ShowingService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@CrossOrigin("*")
@AllArgsConstructor
@RestController
@RequestMapping("/showings")
public class ShowingController {
    private final ShowingService showingService;

    // This can take a movieId as a request param, but it is not required.
    // If we need to filter by movieId, we can add a query parameter.
    // Can be used for all showings or by filtering on movieId.
    // Example with movieId: http://localhost:8080/showings?movieId=1
    @GetMapping
    public List<ShowingDto> getAll(
            @RequestParam(required = false, name = "movieId") Long movieId) {
        return showingService.getAll(movieId);
    }

    @PostMapping
    public ResponseEntity<ShowingDto> createShowing(@RequestBody RegisterShowingDto request) {
        var showingDto = showingService.createShowing(request);

        return ResponseEntity.status(HttpStatus.CREATED).body(showingDto);
    }

    @PutMapping("{id}")
    public ResponseEntity<ShowingDto> updateShowing(
            // Adding name is optional but recommended.
            // Now the name is consistent with the name in the URL.
            @PathVariable(name = "id") Long id,
            @RequestBody RegisterShowingDto request) {
        var showingDto = showingService.updateShowing(id, request);

        return ResponseEntity.ok(showingDto);
    }

    @ExceptionHandler(ShowingNotFoundException.class)
    public ResponseEntity<Map<String, String>> handleException(ShowingNotFoundException e) {
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(
                Map.of("error", e.getMessage())
        );
    }

    @ExceptionHandler(MovieNotFoundException.class)
    public ResponseEntity<Map<String, String>> handleException(MovieNotFoundException e) {
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(
                Map.of("error", e.getMessage())
        );
    }

    @ExceptionHandler(ScreenNotFoundException.class)
    public ResponseEntity<Map<String, String>> handleException(ScreenNotFoundException e) {
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(
                Map.of("error", e.getMessage())
        );
    }
}
