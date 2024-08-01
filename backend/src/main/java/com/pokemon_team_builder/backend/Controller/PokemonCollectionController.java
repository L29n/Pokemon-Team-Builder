package com.pokemon_team_builder.backend.Controller;

import com.pokemon_team_builder.backend.model.LocalUser;
import com.pokemon_team_builder.backend.model.PokemonCollection;
import com.pokemon_team_builder.backend.service.PokemonCollectionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@CrossOrigin(origins = "http://localhost:3000", allowCredentials = "true")
@RestController
public class PokemonCollectionController {
    @Autowired
    private PokemonCollectionService pokemonCollectionService;
    @PostMapping("/api/post/PokemonCollection/addPokemon")
    public ResponseEntity<PokemonCollection> postPokemonCollection(@RequestBody PokemonCollection pokemon){
        try{
            PokemonCollection savedPokemonCollection = pokemonCollectionService.addPokemonToCollection(pokemon);
            return ResponseEntity.ok(savedPokemonCollection);
        }catch(RuntimeException e){
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
        }
    }
}
