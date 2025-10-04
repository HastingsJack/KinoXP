package org.example.kinoxp.dtos.showingDtos;

import lombok.Data;

// Substitute for MovieDto
// Only these attributes are needed.
@Data
public class ShowingMovieDto {
    private Long id;
    private String title;
    private Integer movieLength;
    private String movieImg;
    private String ageLimit;
}
