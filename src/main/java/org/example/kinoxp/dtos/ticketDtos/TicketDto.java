package org.example.kinoxp.dtos.ticketDtos;


import lombok.Data;
import lombok.Getter;
import lombok.Setter;
import org.example.kinoxp.dtos.showingDtos.ShowingDto;
import org.example.kinoxp.models.Showing;
import org.example.kinoxp.models.SnackOrder;

import java.util.List;
@Getter
@Setter
@Data
public class TicketDto {

    private Long id;
    private String customerEmail;
    private String customerName;
    private String seat;
    private List<TicketSnackOrderDto> snackOrders;
    private ShowingDto showing;

}
