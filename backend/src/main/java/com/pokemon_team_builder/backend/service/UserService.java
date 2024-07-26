package com.pokemon_team_builder.backend.service;

import com.pokemon_team_builder.backend.Repository.UserRepo;
import com.pokemon_team_builder.backend.exception.UserAlreadyExistsException;
import com.pokemon_team_builder.backend.model.LocalUser;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class UserService {

    @Autowired
    private UserRepo userRepo;
    public LocalUser saveUser(LocalUser localuser) {
        try {
            return userRepo.save(localuser);
        } catch (Exception e) {
            // Handle other unexpected exceptions
            throw new RuntimeException("Failed to save user: " + e.getMessage());
        }
    }

    public LocalUser getUserByEmail(String targetEmail){
        try{
            return userRepo.findLocalUserByEmail(targetEmail);
        }catch(Exception e){
            throw new RuntimeException("Failed to save user: " + e.getMessage());
        }
    }
    public LocalUser getUserByUsername(String targetUsername){
        try{
            return userRepo.findLocalUserByUsername(targetUsername);
        }catch(Exception e){
            throw new RuntimeException("Failed to save user: " + e.getMessage());
        }
    }

}
