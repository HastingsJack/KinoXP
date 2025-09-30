package org.example.kinoxp.mappers;

import org.example.kinoxp.dto.SnackDto;
import org.example.kinoxp.models.Snack;
import org.mapstruct.Mapper;
import org.mapstruct.MappingTarget;

@Mapper(componentModel = "spring")
public interface SnackMapper {

    SnackDto toDto(Snack snack);

    Snack toModel(SnackDto request);

    void update(SnackDto request, @MappingTarget Snack snack);
}
