package com.pokemon_team_builder.backend.service;

import com.pokemon_team_builder.backend.model.repository.PokemonRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PokemonService {

    @Autowired
    private PokemonRepository pokemonRepository;
    //Need to modify this when we get to it
//    public List<Pokemon> getPokemonByKeyword(String keyword){
//        try {
//            return pokemonRepo.findAllByKeyword(keyword);
//        } catch (Exception e) {
//            // Handle other unexpected exceptions
//            throw new RuntimeException("Failed to save user: " + e.getMessage());
//        }
//    }
}