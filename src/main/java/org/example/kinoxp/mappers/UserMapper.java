package org.example.kinoxp.mappers;

import org.example.kinoxp.dtos.userDto.LoginResponseDto;
import org.example.kinoxp.dtos.userDto.UserDto;
import org.example.kinoxp.models.User;
import org.mapstruct.Mapper;
import org.mapstruct.MappingTarget;

@Mapper(componentModel = "spring")
public interface UserMapper {
    
    UserDto toUserDto(User user);

    LoginResponseDto toLoginUserResponseDto(User user);

    User toUserModel(UserDto userDto);

    void update(UserDto request, @MappingTarget User user);
}
