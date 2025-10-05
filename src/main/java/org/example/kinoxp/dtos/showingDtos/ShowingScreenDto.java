package org.example.kinoxp.dtos.showingDtos;

import lombok.Data;

@Data
public class ShowingScreenDto {
    private Byte id;
    private String name;
    private Integer seatRows;
    private Integer seatColumns;
}
