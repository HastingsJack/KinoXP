package org.example.kinoxp.dto;

import lombok.Data;
import jakarta.validation.constraints.NotNull;

@Data
public class SnackDto {
    private Integer id;
    @NotNull(message = "Indtast et navn")
    private String name;
    @NotNull(message = "Indtast en størrelse")
    private String size;
    @NotNull(message = "Indtast en pris")
    private Double price;
    private String snackImg;
    private String description;
}
