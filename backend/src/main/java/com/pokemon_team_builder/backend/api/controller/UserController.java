package com.pokemon_team_builder.backend.api.controller;

import com.pokemon_team_builder.backend.api.model.LoginBody;
import com.pokemon_team_builder.backend.api.model.LoginResponse;
import com.pokemon_team_builder.backend.api.model.RegistrationBody;
import com.pokemon_team_builder.backend.api.model.RegistrationResponse;
import com.pokemon_team_builder.backend.exception.UserAlreadyExistsException;
import com.pokemon_team_builder.backend.model.LocalUser;
import com.pokemon_team_builder.backend.service.UserService;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.web.bind.annotation.*;

@CrossOrigin(origins = "http://localhost:3000", allowCredentials = "true")
@RestController
@RequestMapping("/api")
public class UserController {

    private UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }

    @PostMapping("/post/register")
    ResponseEntity<RegistrationResponse> registerUser(@Valid @RequestBody RegistrationBody registrationBody) {
        try {
            userService.registerUser(registrationBody);
            RegistrationResponse registrationResponse = new RegistrationResponse();
            registrationResponse.setResponse("Registration success!");
            return ResponseEntity.ok(registrationResponse);
        } catch (UserAlreadyExistsException ex) {
            return ResponseEntity.status(HttpStatus.CONFLICT).build();
        }
    }

    @PostMapping("/post/login")
    ResponseEntity<LoginResponse> loginUser(@Valid @RequestBody LoginBody loginBody) {
        String jwt = userService.loginUser(loginBody);
        if(jwt == null){
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).build();
        } else {
            LoginResponse loginResponse = new LoginResponse();
            loginResponse.setJwt(jwt);
            return ResponseEntity.ok(loginResponse);
        }
    }

    @GetMapping("/get/me")
    public LocalUser getLoggedInUserProfile(@AuthenticationPrincipal LocalUser user) {
        return user;
    }
}