package org.example.kinoxp.models;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import org.example.kinoxp.models.enums.Genre;

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
//@NoArgsConstructor
public class Movie {
    private Long id;
    private String name;
    private Integer movieLength;
    private String movieImg;
    private Integer ageLimit;
    private String description;
    private Set<Genre> genres;
    private Set<Actor> actors;
    private Set<Showing> showings;
}
