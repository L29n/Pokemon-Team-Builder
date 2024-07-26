package com.pokemon_team_builder.backend.Repository;

import com.pokemon_team_builder.backend.model.PokemonCollection;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PokemonCollectionRepo extends JpaRepository<PokemonCollection, Integer> {

}
