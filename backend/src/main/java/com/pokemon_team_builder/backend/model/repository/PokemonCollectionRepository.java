package com.pokemon_team_builder.backend.model.repository;

import com.pokemon_team_builder.backend.model.LocalUser;
import com.pokemon_team_builder.backend.model.Pokemon;
import com.pokemon_team_builder.backend.model.PokemonCollection;
import com.pokemon_team_builder.backend.model.PokemonCollectionId;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface PokemonCollectionRepository extends JpaRepository<PokemonCollection, PokemonCollectionId> {

    // Find a PokemonCollection by Pokemon ID
    Optional<PokemonCollection> findByPokemonId(long id);

    // Find a PokemonCollection by LocalUser ID
    Optional<PokemonCollection> findByLocalUserId(long id);

    // Find a PokemonCollection by LocalUser and Pokemon entities
    Optional<PokemonCollection> findByLocalUserAndPokemon(LocalUser user, Pokemon pokemon);

}
