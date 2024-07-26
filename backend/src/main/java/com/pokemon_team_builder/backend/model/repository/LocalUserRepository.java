package com.pokemon_team_builder.backend.model.repository;

import com.pokemon_team_builder.backend.model.LocalUser;
import org.springframework.data.repository.CrudRepository;

import java.util.Optional;

public interface LocalUserRepository extends CrudRepository<LocalUser, Long> {

    Optional<LocalUser> findByEmailIgnoreCase(String email);

    Optional<LocalUser> findByUsernameIgnoreCase(String username);

}
