package com.pokemon_team_builder.backend.api.controller;

import com.pokemon_team_builder.backend.model.Pokemon;
import com.pokemon_team_builder.backend.service.PokemonService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
@CrossOrigin(origins = "http://localhost:3000", allowCredentials = "true")
@RestController
public class PokemonController {

    @Autowired
    private PokemonService pokemonService;

    //Need to fix this when we get to it, figure out logic for keyword search
//    @GetMapping("/api/get/Pokemon/listOfPokemon/keyWordSearch/{keyword}")
//    public ResponseEntity<List<Pokemon>> keywordSearch(@PathVariable("keyword") String keyword){
//        try{
//            List<Pokemon> savedPokemon = pokemonService.getPokemonByKeyword(keyword);
//            return ResponseEntity.ok(savedPokemon);
//        }catch(RuntimeException e){
//            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
//        }
//    }
}
