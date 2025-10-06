package org.example.kinoxp.repositories;

import org.example.kinoxp.models.Movie;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.context.ActiveProfiles;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

@DataJpaTest
@ActiveProfiles("test")
public class MovieRepositoryTest {

    @Autowired
    MovieRepository movieRepository;

    @BeforeEach
    void setUp() {
        Movie movie = new Movie();
        movie.setId(1L);
        movie.setTitle("test");
        movieRepository.save(movie);
    }

    @Test
    void testOneMovie() {
        List<Movie> movies = movieRepository.findAll();
        assertEquals(1, movies.size());
    }
}
