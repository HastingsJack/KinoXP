package org.example.kinoxp.controllers;

import org.example.kinoxp.dtos.MoviePeriodDto;
import org.example.kinoxp.models.Movie;
import org.example.kinoxp.services.MovieService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin("*")
@RequestMapping("/movies")
public class MovieController {
    private final MovieService movieService;

    public MovieController(MovieService movieService) {
        this.movieService = movieService;
    }

    @PostMapping("/{id}")
    public ResponseEntity<Movie> fetchMovie(
            @PathVariable long id,
            @RequestBody MoviePeriodDto showingPeriod) {
        Movie movie = movieService.fetchAndSaveMovie(id, showingPeriod);
        if (movie == null) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(movie);
    }

    @GetMapping("/active")
    public List<Movie> fetchActiveMovies() {
        return movieService.getActiveMovies();
    }

    @GetMapping("/future")
    public List<Movie> fetchFutureMovies() {
        return movieService.getFutureMovies();
    }
}
