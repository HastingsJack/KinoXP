package org.example.kinoxp.controllers;

import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import org.example.kinoxp.dtos.SnackDto;
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
@CrossOrigin("*")
public class SnackController {
    private final SnackService snackService;

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
            // Adding name is optional but recommended.
            // Now the name is consistent with the name in the URL.
            @PathVariable(name = "id") Integer id,
            // @Valid is used to validate the request body.
            // From the annotation in SnackDto
            @Valid @RequestBody SnackDto request) {
        var response = snackService.updateSnack(id, request);

        return ResponseEntity.ok(response);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteSnack(
            // Adding name is optional but recommended.
            // Now the name is consistent with the name in the URL.
            @PathVariable(name = "id") Integer id){
        snackService.deleteSnack(id);
        return ResponseEntity.noContent().build();
    }

    // I create this locally because it's only this controller that needs it.
    @ExceptionHandler(SnackNotFoundException.class)
    public ResponseEntity<Map<String, String>> handleException(SnackNotFoundException e) {
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(
                Map.of("error", "Snack findes ikke")
        );
    }
}
