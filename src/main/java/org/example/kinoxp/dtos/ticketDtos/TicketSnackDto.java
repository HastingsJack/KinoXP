package org.example.kinoxp.dtos.ticketDtos;

import jakarta.validation.constraints.NotNull;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

@Data
@Getter
@Setter
public class TicketSnackDto {
    private Integer id;
    private String name;
    private String size;
    private Double price;
    private String snackImg;
    private String description;
}
