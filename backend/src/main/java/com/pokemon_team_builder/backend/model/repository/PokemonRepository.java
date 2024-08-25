package com.pokemon_team_builder.backend.model.repository;

import com.pokemon_team_builder.backend.model.Pokemon;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface PokemonRepository extends JpaRepository<Pokemon, Integer> {
    Optional<Pokemon> findPokemonByName(String name);
}