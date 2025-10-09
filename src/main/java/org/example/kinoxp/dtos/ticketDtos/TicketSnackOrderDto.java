package org.example.kinoxp.dtos.ticketDtos;

import jakarta.persistence.Column;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToOne;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;
import org.example.kinoxp.models.Snack;
import org.example.kinoxp.models.Ticket;

import java.util.Set;

@Data
@Getter
@Setter
public class TicketSnackOrderDto {
    private Long id;
    private Integer quantity;
    private TicketSnackDto snack;
}
