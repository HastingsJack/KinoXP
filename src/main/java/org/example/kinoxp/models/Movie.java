package org.example.kinoxp.models;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;
import java.util.Set;

// !!! This is what lombok does !!!
// If you don't want lombok, you can remove this import

// Here we create setter and getter methods
@Setter
@Getter

// Here we create a constructor
@AllArgsConstructor
// Here we create a no-args constructor
// If needed, you can add this constructor
@NoArgsConstructor
@Entity
public class Movie {
    @Id
    private Long id;

    private String title;

    @Column(length = 500)
    private String description;
    private Integer movieLength;
    private String movieImg;
    private String ageLimit;
    private LocalDate startDate;
    private LocalDate endDate;


    @ElementCollection
    private Set<String> genres;

    @ManyToMany
    @JoinTable(
            name = "movie_actor",
            joinColumns = @JoinColumn(name = "movie_id"),
            inverseJoinColumns = @JoinColumn(name = "actor_id")
    )
    private Set<Actor> actors;

    //private Set<Showing> showings;
}
