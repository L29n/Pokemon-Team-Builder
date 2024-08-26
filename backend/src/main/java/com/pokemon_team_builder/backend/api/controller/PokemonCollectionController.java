package com.pokemon_team_builder.backend.api.controller;

import com.pokemon_team_builder.backend.exception.PokemonAlreadyInCollectionException;
import com.pokemon_team_builder.backend.model.PokemonCollection;
import com.pokemon_team_builder.backend.service.PokemonCollectionService;
import com.pokemon_team_builder.backend.service.PokemonService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@CrossOrigin(origins = "http://localhost:3000", allowCredentials = "true")
@RestController
public class PokemonCollectionController {

    @Autowired
    private PokemonCollectionService pokemonCollectionService;

    @Autowired
    private PokemonService pokemonService;

    @PostMapping("/api/post/PokemonCollection/addPokemon/{username}/{pokemonName}")
    public ResponseEntity<PokemonCollection> postPokemonCollection(@PathVariable ("username") String username, @PathVariable ("pokemonName") String pokemonName ){
        System.out.println(username);
        System.out.println(pokemonName);
        try{
            PokemonCollection savedPokemonCollection = pokemonCollectionService.addPokemonToCollection(username, pokemonName);
            if(savedPokemonCollection == null){
                throw new PokemonAlreadyInCollectionException("Pokemon already exists in collection");
            }
            return ResponseEntity.ok(savedPokemonCollection);
        }catch(PokemonAlreadyInCollectionException e){
            return ResponseEntity.status(HttpStatus.CONFLICT).build();
        }catch(RuntimeException e){
            System.out.println("issue in controller");
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
        }
    }

}
