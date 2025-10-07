package org.example.kinoxp.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.example.kinoxp.models.WorkAssignment;
import org.springframework.stereotype.Repository;


@Repository
public interface WorkAssignmentRepository extends JpaRepository<WorkAssignment, Integer> {





}
