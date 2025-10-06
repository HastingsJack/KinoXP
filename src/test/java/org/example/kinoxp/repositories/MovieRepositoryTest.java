package org.example.kinoxp.repositories;

import org.example.kinoxp.models.Actor;
import org.example.kinoxp.models.Movie;
import org.example.kinoxp.models.Showing;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.context.ActiveProfiles;

import java.io.IOException;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

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

//    @Test
//    public void testOkHttpOnActiveMovies() throws IOException {
//        okhttp3.OkHttpClient client = new okhttp3.OkHttpClient();
//        okhttp3.Request request = new okhttp3.Request.Builder().url("http://localhost:8080/active").build();
//        okhttp3.Response response = client.newCall(request).execute();
//        System.out.println(response.body());
//    }
}
