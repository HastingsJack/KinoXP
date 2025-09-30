package org.example.kinoxp.models;

// !!! This is what lombok does !!!
// If you don't want lombok, you can remove this import

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import org.example.kinoxp.models.enums.Role;

import java.util.List;

// Here we create setter and getter methods
@Setter
@Getter

// Here we create a constructor
@AllArgsConstructor
// Here we create a no-args constructor
// If needed, you can add this constructor
//@NoArgsConstructor

public class Snack {
    private Integer id;
    private String name;
    private String size;
    private Double price;
    private String snackImg;
    private String description;
    private SnackOrder snackOrders;
}
