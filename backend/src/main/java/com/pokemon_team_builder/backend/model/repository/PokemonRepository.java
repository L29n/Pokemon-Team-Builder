package com.pokemon_team_builder.backend.model.repository;

import com.pokemon_team_builder.backend.model.Pokemon;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface PokemonRepository extends CrudRepository<Pokemon, Integer> {
    //Need to figure out what to search by
//    List<Pokemon> findAllByKeyword(String keyword);
}