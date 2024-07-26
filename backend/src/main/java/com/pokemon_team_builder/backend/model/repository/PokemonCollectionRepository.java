package com.pokemon_team_builder.backend.model.repository;


import com.pokemon_team_builder.backend.model.PokemonCollection;
import org.springframework.data.repository.CrudRepository;

public interface PokemonCollectionRepository extends CrudRepository<PokemonCollection, Integer> {

}