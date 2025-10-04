package org.example.kinoxp.dto;


import jakarta.persistence.Column;
import lombok.Data;

import java.time.LocalDate;
import java.time.LocalDateTime;

@Data
public class ShowingDto {
    private Long id;
    private Double price;
    private LocalDateTime startTime;
    private LocalDateTime endTime;

    //Movie data
    private Long movieId;
    private String movieTitle;
    private String movieDescription;
    private Integer movieLength;
    private String movieImg;
    private String movieAgeLimit;

    //Screen data
    private Byte screenId;
    private String screenName;
    private Integer seatRows;
    private Integer seatColumns;

    //Period data
    private Long periodId;
    private LocalDate periodStartDate;
    private Boolean periodOngoing;

}
