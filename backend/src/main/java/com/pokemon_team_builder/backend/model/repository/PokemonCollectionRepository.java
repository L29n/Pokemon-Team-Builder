package com.pokemon_team_builder.backend.model.repository;


import com.pokemon_team_builder.backend.model.PokemonCollection;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface PokemonCollectionRepository extends JpaRepository<PokemonCollection, Integer> {
    Optional<PokemonCollection> findPokemonCollectionByPokemonId(long id);
    Optional<PokemonCollection> findPokemonCollectionByLocalUserId(long id);
}