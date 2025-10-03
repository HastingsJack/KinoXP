package org.example.kinoxp.dto;

import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;

@Setter
@Getter
public class ShowingPeriodDto {
    private LocalDate startDate;
    private LocalDate endDate;

}
