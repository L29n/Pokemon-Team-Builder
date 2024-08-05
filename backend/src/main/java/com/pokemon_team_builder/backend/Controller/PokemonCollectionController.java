package com.pokemon_team_builder.backend.Controller;

import com.pokemon_team_builder.backend.model.LocalUser;
import com.pokemon_team_builder.backend.model.Pokemon;
import com.pokemon_team_builder.backend.model.PokemonCollection;
import com.pokemon_team_builder.backend.service.PokemonCollectionService;
import com.pokemon_team_builder.backend.service.PokemonService;
import org.apache.coyote.Response;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@CrossOrigin(origins = "http://localhost:3000", allowCredentials = "true")
@RestController
public class PokemonCollectionController {
    @Autowired
    private PokemonCollectionService pokemonCollectionService;
    private PokemonService pokemonService;
    @PostMapping("/api/post/PokemonCollection/addPokemon/{username}/{pokemonName}")
    public ResponseEntity<PokemonCollection> postPokemonCollection(@PathVariable ("username") String username,@PathVariable ("pokemonName") String pokemonName ){
        System.out.println(username);
        System.out.println(pokemonName);
        try{
            PokemonCollection savedPokemonCollection = pokemonCollectionService.addPokemonToCollection(username, pokemonName);
            if(savedPokemonCollection == null){
                return null;
            }
            return ResponseEntity.ok(savedPokemonCollection);
        }catch(RuntimeException e){
            System.out.println("issue in controller");
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
        }
    }
//    @GetMapping("/api/get/PokemonCollection/checkPokemon/{username}/{pokemonName}")
//    public Boolean getPokemon(@PathVariable("username") String username,@PathVariable("pokemonName") String pokemonName){
//        try{
//            // get pokemon by username
//            Pokemon savedPokemon = pokemonService.
//            //get pokemon collection by pokemon ID
//            return true;
//        }catch(RuntimeException e){
//
//            return false;
//        }
//    }
}
