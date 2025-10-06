package org.example.kinoxp.repositories;

import org.example.kinoxp.models.Ticket;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TicketRepository extends JpaRepository<Ticket, Long> {
}
