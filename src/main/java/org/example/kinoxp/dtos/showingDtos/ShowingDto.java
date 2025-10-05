package org.example.kinoxp.dtos.showingDtos;

import lombok.Data;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.List;

@Data
public class ShowingDto {
    private Long id;
    private Double price;
    private LocalDate date;
    private LocalTime startTime;
    private LocalTime endTime;
    private ShowingMovieDto movie;
    private ShowingScreenDto screen;
    private List<ShowingTicketDto> tickets;
}
