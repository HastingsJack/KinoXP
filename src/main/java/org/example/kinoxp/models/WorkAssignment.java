package org.example.kinoxp.models;

import java.time.LocalDate;
import java.time.LocalTime;

// !!! This is what lombok does !!!
// If you don't want lombok, you can remove this import

import com.fasterxml.jackson.annotation.JsonBackReference;
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
@Entity
public class WorkAssignment {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private LocalTime startTime;
    private LocalTime endTime;
    private LocalDate date;

    @ManyToOne
    @JoinColumn(name = "user_id")
    @JsonBackReference
    private User user;
}
