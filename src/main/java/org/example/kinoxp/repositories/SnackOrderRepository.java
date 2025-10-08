package org.example.kinoxp.repositories;


import org.example.kinoxp.models.Snack;
import org.example.kinoxp.models.SnackOrder;
import org.springframework.data.jpa.repository.JpaRepository;

public interface SnackOrderRepository extends JpaRepository<SnackOrder, Integer> {
    SnackOrder snack(Snack snack);
}
