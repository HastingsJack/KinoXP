package org.example.kinoxp.models;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;
import java.util.Set;

// !!! This is what lombok does !!!
// If you don't want lombok, you can remove this import

import jakarta.persistence.ManyToOne;
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

public class Showing {
    private Long id;
    private Double price;
    private LocalDate date;
    private LocalDateTime startTime;
    private LocalDateTime endTime;
    @ManyToOne
    private Movie movie;
    private Screen screen;
    private Set<Ticket> tickets;
}
