package org.example.kinoxp.dtos.snackOrderDtos;

import lombok.Data;
import org.example.kinoxp.models.Snack;
import org.example.kinoxp.models.Ticket;

@Data
public class SnackOrderDto {
    private Long id;
    private Integer quantity;
    private Snack snack;
    private Ticket ticket;
}
