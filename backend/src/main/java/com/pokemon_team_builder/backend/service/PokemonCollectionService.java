package com.pokemon_team_builder.backend.service;

import com.pokemon_team_builder.backend.Controller.PokemonCollectionController;
import com.pokemon_team_builder.backend.Repository.PokemonCollectionRepo;

import com.pokemon_team_builder.backend.Repository.PokemonRepo;
import com.pokemon_team_builder.backend.Repository.UserRepo;
import com.pokemon_team_builder.backend.model.LocalUser;
import com.pokemon_team_builder.backend.model.Pokemon;
import com.pokemon_team_builder.backend.model.PokemonCollection;
import com.pokemon_team_builder.backend.model.PokemonCollectionId;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.stereotype.Service;

@Service
public class PokemonCollectionService {
    @Autowired
    private UserRepo localUserRepo;

    @Autowired
    private PokemonRepo pokemonRepo;

    @Autowired
    private PokemonCollectionRepo pokemonCollectionRepo;

    public PokemonCollection addPokemonToCollection(String username, String pokemonName) {
        try{
            System.out.println(username);
            System.out.println(pokemonName);
            // Retrieve LocalUser and Pokemon entities
            LocalUser localUser = localUserRepo.findLocalUserByUsername(username);
//                .orElseThrow(() -> new EntityNotFoundException("LocalUser not found"));
            Pokemon pokemon = pokemonRepo.findPokemonByName(pokemonName);
//                .orElseThrow(() -> new EntityNotFoundException("Pokemon not found"));
            PokemonCollection pokemonCollectionCheckPoke = pokemonCollectionRepo.findPokemonCollectionByPokemonId(pokemon.getId());

            if(pokemonCollectionCheckPoke!= null && pokemonCollectionCheckPoke.getLocalUser().getUsername().equals( username)){
              System.out.println("pokemonExists");
              return null;
            }
            // Create a new PokemonCollection entry
            PokemonCollection pokemonCollection = new PokemonCollection();
            pokemonCollection.setLocalUser(localUser);
            pokemonCollection.setPokemon(pokemon);

            // Save the PokemonCollection entry
            System.out.println(localUser.getId());
            System.out.println(pokemon.getId());
            return pokemonCollectionRepo.save(pokemonCollection);
        }
        catch(Exception e){
            System.out.println("issue in service");
            throw new RuntimeException("Failed to save pokemonCollection: " + e.getMessage());
        }

    }

//    public PokemonCollection getPokemonById(Str)
}
