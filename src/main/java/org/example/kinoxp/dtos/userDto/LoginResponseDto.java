package org.example.kinoxp.dtos.userDto;

import lombok.Data;
import org.example.kinoxp.models.enums.Role;

@Data
public class LoginResponseDto {
    private Integer id;
    private Role role;
}
