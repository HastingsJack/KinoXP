package org.example.kinoxp.dtos.showingDtos;

import jakarta.validation.constraints.NotNull;
import lombok.Data;

import java.time.LocalDate;
import java.time.LocalTime;

@Data
public class RegisterShowingDto {
    private Long id;
    @NotNull(message = "Indtast en pris")
    private Double price;
    @NotNull(message = "Indtast en dato")
    private LocalDate date;
    @NotNull(message = "Indtast en starttidspunkt")
    private LocalTime startTime;
    @NotNull(message = "Indtast en sluttidspunkt")
    private LocalTime endTime;
    @NotNull(message = "Vælg en film")
    private ShowingMovieDto movie;
    @NotNull(message = "Vælg en sal")
    private ShowingScreenDto screen;
}
