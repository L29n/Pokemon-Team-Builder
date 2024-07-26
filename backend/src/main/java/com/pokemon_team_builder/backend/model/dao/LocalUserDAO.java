package com.pokemon_team_builder.backend.model.dao;

import com.pokemon_team_builder.backend.model.LocalUser;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface LocalUserDAO extends JpaRepository<LocalUser, Long> {

    Optional<LocalUser> findByEmailIgnoreCase(String email);

    Optional<LocalUser> findByUsernameIgnoreCase(String username);

}
