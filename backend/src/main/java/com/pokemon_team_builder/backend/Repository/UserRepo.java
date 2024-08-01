package com.pokemon_team_builder.backend.Repository;

import com.pokemon_team_builder.backend.model.LocalUser;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepo extends JpaRepository <LocalUser,Integer>{
    LocalUser findLocalUserByEmail(String email);
    LocalUser findLocalUserByUsername(String username);
    LocalUser findById(Long id);
}
