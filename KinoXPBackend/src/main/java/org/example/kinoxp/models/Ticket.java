package org.example.kinoxp.models;

import java.util.List;

// !!! This is what lombok does !!!
// If you don't want lombok, you can remove this import

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;


// Here we create setter and getter methods
@Setter
@Getter

// Here we create a constructor
@AllArgsConstructor
// Here we create a no-args constructor
// If needed, you can add this constructor
//@NoArgsConstructor
public class Ticket {
    private Long id;
    private String customerEmail;
    private String customerName;
    private String seat;
    private List<SnackOrder> snackOrders;
    private Showing showing;
}
