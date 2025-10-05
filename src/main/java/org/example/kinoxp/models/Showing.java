package org.example.kinoxp.models;

import java.time.LocalDate;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.util.Set;

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
@Table(name = "showings")
@Entity
public class Showing {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private Double price;
    private LocalDate date;
    private LocalTime startTime;
    private LocalTime endTime;
    // Using merge, when the data already exists, it will be updated.
    // Using persist, when the data is new, it will be created.
    @ManyToOne(cascade = CascadeType.MERGE)
    private Movie movie;
    // Using merge, when the data already exists, it will be updated.
    // Using persist, when the data is new, it will be created.
    @ManyToOne(cascade = CascadeType.MERGE)
    private Screen screen;
    @OneToMany(mappedBy = "showing")
    private Set<Ticket> tickets;

    //
    public void setStartTime(LocalTime startTime) {
        this.startTime = LocalTime.parse(startTime.format(DateTimeFormatter.ofPattern("HH:mm")));
    }

    public void setEndTime(LocalTime endTime) {
        this.endTime = LocalTime.parse(endTime.format(DateTimeFormatter.ofPattern("HH:mm")));
    }

}
