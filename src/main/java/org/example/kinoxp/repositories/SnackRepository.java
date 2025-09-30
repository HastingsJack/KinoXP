package org.example.kinoxp.repositories;

import org.example.kinoxp.models.Snack;
import org.springframework.data.jpa.repository.JpaRepository;

public interface SnackRepository extends JpaRepository<Snack, Integer> {
}
