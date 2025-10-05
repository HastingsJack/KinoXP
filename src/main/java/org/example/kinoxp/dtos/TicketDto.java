package org.example.kinoxp.dtos;


import jakarta.persistence.OneToMany;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;
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
    private List<SnackOrder> snackOrders;
    private Showing showing;

}
