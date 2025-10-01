package org.example.kinoxp.mappers;

import org.example.kinoxp.dto.UserDto;
import org.example.kinoxp.models.User;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface UserMapper {
    
    UserDto toUserDto(User user);

    User toUserModel(UserDto userDto);
}
