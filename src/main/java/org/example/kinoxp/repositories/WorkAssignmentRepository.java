package org.example.kinoxp.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.example.kinoxp.models.WorkAssignment;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;
import java.util.List;


@Repository
public interface WorkAssignmentRepository extends JpaRepository<WorkAssignment, Long> {


    List<WorkAssignment> findByDateBetween(LocalDate start, LocalDate end) ;


    List<WorkAssignment> findByDateGreaterThanEqual(LocalDate start);

    List<WorkAssignment> findByDateLessThanEqual(LocalDate end);


}
