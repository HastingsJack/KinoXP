package org.example.kinoxp.models;

import java.time.LocalDate;
import java.time.LocalDateTime;
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

@Entity
@NoArgsConstructor
public class Showing {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private Double price;
    private LocalDateTime startTime;
    private LocalDateTime endTime;
    private LocalDate date;
    @ManyToOne
    @JoinColumn(name = "movie_id")
    private Movie movie;
    @ManyToOne
    @JoinColumn(name = "screen_id")
    private Screen screen;
    @ManyToOne
    @JoinColumn(name = "period_id")
    private Period period;
    @OneToMany(mappedBy = "showing", cascade = CascadeType.ALL, orphanRemoval = true)
    private Set<Ticket> tickets;

}
