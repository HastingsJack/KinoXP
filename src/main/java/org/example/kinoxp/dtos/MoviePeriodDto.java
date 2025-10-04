package org.example.kinoxp.dtos;

import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;

@Setter
@Getter
public class MoviePeriodDto {
    private LocalDate startDate;
    private LocalDate endDate;

}
