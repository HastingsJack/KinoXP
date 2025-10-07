package org.example.kinoxp.dtos.userDto;

import jakarta.validation.constraints.NotNull;
import lombok.Data;

@Data
public class LoginRequestDto {
    @NotNull(message = "Indtast et email")
    private String email;
    @NotNull(message = "Indtast et password")
    private String password;
}
