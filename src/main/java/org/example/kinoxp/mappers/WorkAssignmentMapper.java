package org.example.kinoxp.mappers;

import org.example.kinoxp.dtos.workAssignmentDtos.WorkAssignmentDto;
import org.example.kinoxp.models.WorkAssignment;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface WorkAssignmentMapper {

    WorkAssignmentDto toDto(WorkAssignment workAssignment);

    WorkAssignment toModel(WorkAssignmentDto dto);

}
