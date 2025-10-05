package org.example.kinoxp.repositories;

import org.example.kinoxp.models.Movie;
import org.springframework.data.jpa.repository.JpaRepository;

import java.time.LocalDate;
import java.util.Set;

public interface MovieRepository extends JpaRepository<Movie, Long> {

    Set<Movie> findByEndDateAfter(LocalDate date);
}
