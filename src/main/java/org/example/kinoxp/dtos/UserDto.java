package org.example.kinoxp.dtos;

import lombok.AllArgsConstructor;
import lombok.Data;
import jakarta.validation.constraints.NotNull;
import lombok.NoArgsConstructor;
import org.example.kinoxp.models.enums.Role;


@Data
@AllArgsConstructor
@NoArgsConstructor
public class UserDto {

    private Integer id;

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
