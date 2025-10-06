package org.example.kinoxp.dtos.ticketDtos;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;
import org.example.kinoxp.models.Showing;
import org.example.kinoxp.models.SnackOrder;

import java.util.List;

@Getter
@Setter
@Data
public class RegisterTicketDto {
    private Long id;
    private String customerEmail;
    private String customerName;
    private String seat;
    //add snack order functionality later
    //private List<SnackOrder> snackOrders;
    private Showing showing;
}
