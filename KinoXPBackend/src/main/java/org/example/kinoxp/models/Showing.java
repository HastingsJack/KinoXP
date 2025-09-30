package org.example.kinoxp.models;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.Set;

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

public class Showing {
    private Long id;
    private Double price;
    private LocalDateTime startTime;
    private LocalDateTime endTime;
    private LocalDate date;
    private Movie movie;
    private Screen screen;
    private Period period;
    private Set<Ticket> tickets;
}
