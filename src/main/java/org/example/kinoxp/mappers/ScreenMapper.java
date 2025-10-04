package org.example.kinoxp.mappers;

import org.example.kinoxp.dtos.ScreenDto;
import org.example.kinoxp.models.Screen;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface ScreenMapper {
    ScreenDto toDto(Screen screen);
}
