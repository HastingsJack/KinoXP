package org.example.kinoxp.mappers;

import jakarta.validation.Valid;
import org.example.kinoxp.dto.UserDto;
import org.example.kinoxp.models.User;
import org.mapstruct.Mapper;
import org.mapstruct.MappingTarget;

@Mapper(componentModel = "spring")
public interface UserMapper {
    
    UserDto toUserDto(User user);

    User toUserModel(UserDto userDto);

    void update(UserDto request, @MappingTarget User user);
}
