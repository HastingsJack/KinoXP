package org.example.kinoxp.models;

import java.util.List;

// !!! This is what lombok does !!!
// If you don't want lombok, you can remove this import

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;


// Here we create setter and getter methods
@Setter
@Getter

// Here we create a constructor
@AllArgsConstructor
// Here we create a no-args constructor
// If needed, you can add this constructor
@NoArgsConstructor
@Table(name = "tickets")
@Entity
public class Ticket {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String customerEmail;
    private String customerName;
    private String seat;
    @OneToMany(mappedBy = "ticket")
    private List<SnackOrder> snackOrders;
    @ManyToOne
    private Showing showing;
}
