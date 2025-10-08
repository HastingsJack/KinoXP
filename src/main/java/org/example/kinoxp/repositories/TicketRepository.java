package org.example.kinoxp.repositories;

import org.example.kinoxp.models.Ticket;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface TicketRepository extends JpaRepository<Ticket, Long> {

    List<Ticket> findByShowingIdAndSeat(Long showingId, String seat);

}
