package org.example.kinoxp.models;

// !!! This is what lombok does !!!
// If you don't want lombok, you can remove this import

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Set;

// Here we create setter and getter methods
@Setter
@Getter

// Here we create a constructor
@AllArgsConstructor
// Here we create a no-args constructor
// If needed, you can add this constructor
@NoArgsConstructor
@Table(name = "screens")
@Entity
public class Screen {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Byte id;
    private String name;
    private Integer seatRows;
    private Integer seatColumns;
//    @OneToMany(mappedBy = "screen")
//    private Set<Showing> showings;
}
