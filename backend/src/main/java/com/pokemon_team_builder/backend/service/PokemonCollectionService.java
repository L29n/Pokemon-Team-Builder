package com.pokemon_team_builder.backend.service;

import com.pokemon_team_builder.backend.model.PokemonCollection;
import com.pokemon_team_builder.backend.model.repository.PokemonCollectionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PokemonCollectionService {

    @Autowired
    private PokemonCollectionRepository pokemonCollectionRepository;

    public PokemonCollection savePokemonToCollection(PokemonCollection pokemon){
        try{
            return pokemonCollectionRepository.save(pokemon);
        }catch(RuntimeException e){
            throw new RuntimeException("Failed to save user: " + e.getMessage());
        }
    }
}