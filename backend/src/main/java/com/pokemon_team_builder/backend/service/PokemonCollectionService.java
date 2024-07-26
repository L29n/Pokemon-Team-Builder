package com.pokemon_team_builder.backend.service;

import com.pokemon_team_builder.backend.Controller.PokemonCollectionController;
import com.pokemon_team_builder.backend.Repository.PokemonCollectionRepo;

import com.pokemon_team_builder.backend.model.PokemonCollection;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PokemonCollectionService {
    @Autowired
    private PokemonCollectionRepo pokemonCollectionRepo;

    public PokemonCollection savePokemonToCollection(PokemonCollection pokemon){
        try{
            return pokemonCollectionRepo.save(pokemon);
        }catch(RuntimeException e){
            throw new RuntimeException("Failed to save user: " + e.getMessage());
        }
    }
}
