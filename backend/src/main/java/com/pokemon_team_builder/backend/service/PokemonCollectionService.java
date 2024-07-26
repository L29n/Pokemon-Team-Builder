package com.pokemon_team_builder.backend.service;

import com.pokemon_team_builder.backend.Controller.PokemonCollection;
import com.pokemon_team_builder.backend.Repository.PokemonCollectionRepo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PokemonCollectionService {
    @Autowired
    private PokemonCollectionRepo pokemonCollectionRepo;
    public PokemonCollection savePokemonToCollection(PokemonCollection pokemonCollection){
        try{
            return pokemonCollectionRepo.save(pokemonCollection);
        }catch(RuntimeException e){

        }
    }
}
