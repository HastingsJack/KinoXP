package org.example.kinoxp.dtos.workAssignmentDtos;

import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.example.kinoxp.models.User;

import java.time.LocalDate;
import java.time.LocalTime;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class WorkAssignmentDto {

    private Integer id;

    @NotNull(message = "Indtast start tid")
    private LocalTime startTime;

    @NotNull(message = "Indtast slut tid")
    private LocalTime endTime;

    @NotNull(message = "Indtast dato")
    private LocalDate date;

    @NotNull(message = "Vælg bruger")
    private User user;

}
