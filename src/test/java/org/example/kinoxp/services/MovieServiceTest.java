package org.example.kinoxp.services;

import org.example.kinoxp.dtos.MoviePeriodDto;
import org.example.kinoxp.models.Movie;
import org.example.kinoxp.repositories.MovieRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

import java.time.LocalDate;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

@ExtendWith(MockitoExtension.class)
public class MovieServiceTest {

    @Mock
    MovieRepository movieRepository;

    @InjectMocks
    MovieService movieService;

    private Movie movie;
    private MoviePeriodDto dto;

    @BeforeEach
    void setUp() {
        dto = new MoviePeriodDto();
        dto.setStartDate(LocalDate.now());
        dto.setEndDate(LocalDate.now().plusDays(15));
        movie = new Movie();
        movie.setTitle("Test");
    }

    @Test
    void getActiveMoviesTest() throws Exception {
        Mockito.when(movieRepository.findByStartDateLessThanEqualAndEndDateGreaterThanEqual(LocalDate.now(), LocalDate.now()))
                .thenReturn(List.of(movie));

        List<Movie> active = movieService.getActiveMovies();

        assertEquals(1,active.size());
        assertEquals("Test",active.getFirst().getTitle());
        Mockito.verify(movieRepository).findByStartDateLessThanEqualAndEndDateGreaterThanEqual(LocalDate.now(), LocalDate.now());
    }

}
