package com.pokemon_team_builder.backend.api.model;

import jakarta.validation.constraints.*;
import lombok.Getter;

@Getter
public class RegistrationBody {

    /** The username. */
    @NotNull
    @NotBlank
    @Size(min=3, max=255)
    private String username;

    /** The password. */
    @NotNull
    @NotBlank
    @Pattern(regexp = "^(?=.*[A-Za-z])(?=.*\\d)[A-Za-z\\d]{6,}$")
    @Size(min=6, max=32)
    private String password;

    /** The email. */
    @NotNull
    @NotBlank
    @Email
    private String email;

}