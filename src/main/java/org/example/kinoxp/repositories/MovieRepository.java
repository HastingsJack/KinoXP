package org.example.kinoxp.repositories;

import org.example.kinoxp.models.Movie;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MovieRepository extends JpaRepository<Movie, Long> {
}
