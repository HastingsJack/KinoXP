package org.example.kinoxp.dtos;

import lombok.Data;
import jakarta.validation.constraints.NotNull;

@Data
public class SnackDto {
    private Integer id;
    // @NotNull databinding validation
    // If Null, then the message will be shown.
    @NotNull(message = "Indtast et navn")
    private String name;
    // @NotNull databinding validation.
    // If Null, then the message will be shown.
    @NotNull(message = "Indtast en størrelse")
    private String size;
    // @NotNull databinding validation.
    // If Null, then the message will be shown.
    @NotNull(message = "Indtast en pris")
    private Double price;
    private String snackImg;
    private String description;
}
