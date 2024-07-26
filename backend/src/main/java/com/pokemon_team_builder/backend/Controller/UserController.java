package com.pokemon_team_builder.backend.Controller;


import com.pokemon_team_builder.backend.model.LocalUser;
import com.pokemon_team_builder.backend.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin(origins = "http://localhost:3000", allowCredentials = "true")
@RestController
public class UserController {
    @Autowired
    private UserService userService;

    @GetMapping("/api/get/LocalUser/{localUserEmail}")
    public ResponseEntity<LocalUser> getLocalUser(@PathVariable("localUserEmail") String targetEmail){
        try{
            LocalUser savedUser = userService.getUserByEmail(targetEmail);
            return ResponseEntity.ok(savedUser);
        }catch(RuntimeException e){
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
        }
    }
    @GetMapping("/api/get/LocalUser/{localUserEmail}/verifyLogin/{password}")
    public Boolean verifyLogin(@PathVariable("localUserEmail") String localUserEmail, @PathVariable("password") String password){
        try{
            LocalUser savedUser = userService.getUserByEmail(localUserEmail);
            return savedUser.getEmail() != null && savedUser.getPassword().equals(password);
        }catch(RuntimeException e){
            System.out.println(ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build());
            return false;
        }
    }
    @GetMapping("/api/get/LocalUser/{localUserEmail}/userExists/{localUserUsername}")
    public Boolean userExists(@PathVariable("localUserEmail") String targetEmail, @PathVariable("localUserUsername")String targetUsername){
        try{
            LocalUser savedUser = userService.getUserByEmail(targetEmail);
            LocalUser savedUser2 = userService.getUserByUsername(targetUsername);
            return !(savedUser.getEmail() == null && savedUser2 == null);
        }catch(RuntimeException e){
            System.out.println(ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build());
            return false;
        }
    }

    @PostMapping("/api/post/LocalUser/insertLocalUser")
    public ResponseEntity<LocalUser> postLocalUser(@RequestBody LocalUser localUser){
        try{
            LocalUser savedUser = userService.saveUser(localUser);
            return ResponseEntity.ok(savedUser);
        }catch(RuntimeException e){
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
        }
    }

}