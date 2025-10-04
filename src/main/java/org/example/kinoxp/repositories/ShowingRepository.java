package org.example.kinoxp.repositories;

import org.example.kinoxp.models.Showing;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ShowingRepository extends JpaRepository<Showing, Long> {

    List<Showing> findByMovieId(Long movieId);
}
