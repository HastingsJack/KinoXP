package org.example.kinoxp.dto;

import lombok.Data;
import jakarta.validation.constraints.NotNull;
import org.example.kinoxp.models.enums.Role;


@Data
public class UserDto {

    private Long id;

    @NotNull(message = "Indtast et navn")
    private String name;

    @NotNull(message = "Indtast en email")
    private String email;

    @NotNull(message = "Indtast et password")
    private String password;

    @NotNull(message = "Indtast en alder")
    private Integer age;

    @NotNull(message = "Indtast en rolle")
    private Role role;


}
