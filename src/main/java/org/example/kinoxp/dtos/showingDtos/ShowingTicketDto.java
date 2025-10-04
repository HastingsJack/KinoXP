package org.example.kinoxp.dtos.showingDtos;

import lombok.Data;

@Data
public class ShowingTicketDto {
    private Long id;
    private String customerEmail;
    private String customerName;
    private String seat;
}
