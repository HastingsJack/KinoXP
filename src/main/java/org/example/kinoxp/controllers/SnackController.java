package org.example.kinoxp.controllers;

import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import org.example.kinoxp.dto.SnackDto;
import org.example.kinoxp.exceptions.SnackNotFoundException;
import org.example.kinoxp.services.SnackService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@AllArgsConstructor
@RestController
@RequestMapping("/snacks")
public class SnackController {
    SnackService snackService;

    @GetMapping
    public List<SnackDto> getAll() {
        return snackService.getAllSnacks();
    }

    @PostMapping
    public ResponseEntity<SnackDto> createSnack(
            // @Valid is used to validate the request body.
            // From the annotation in SnackDto
            @Valid @RequestBody SnackDto request) {
        var response = snackService.createSnacks(request);
        return ResponseEntity.status(HttpStatus.CREATED).body(response);
    }

    @PutMapping("/{id}")
    public ResponseEntity<SnackDto> updateSnack(
            @PathVariable Integer id,
            // @Valid is used to validate the request body.
            // From the annotation in SnackDto
            @Valid @RequestBody SnackDto request) {
        var response = snackService.updateSnack(id, request);

        return ResponseEntity.ok(response);
    }

    // I create this locally because it's only this controller that needs it.
    @ExceptionHandler(SnackNotFoundException.class)
    public ResponseEntity<Map<String, String>> handleException(SnackNotFoundException e) {
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(
                Map.of("error", "Snack findes ikke")
        );
    }
}
