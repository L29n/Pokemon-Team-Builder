package com.pokemon_team_builder.backend.Repository;

import com.pokemon_team_builder.backend.model.Pokemon;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface PokemonRepo extends JpaRepository<Pokemon, Integer> {
   //Need to figure out what to search by
//    List<Pokemon> findAllByKeyword(String keyword);
}
