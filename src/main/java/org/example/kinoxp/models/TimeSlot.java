package org.example.kinoxp.models;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;

@Setter
@Getter

@AllArgsConstructor
@NoArgsConstructor
public class TimeSlot {
    private Long id;
    private String startTime;
    // When showing is working and we got time. We can add this.
    //private String endTime;
    private LocalDate date;
    private Movie movie;
}
