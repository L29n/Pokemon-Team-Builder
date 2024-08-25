package com.pokemon_team_builder.backend.service;

import com.pokemon_team_builder.backend.exception.PokemonAlreadyInCollectionException;
import com.pokemon_team_builder.backend.model.LocalUser;
import com.pokemon_team_builder.backend.model.Pokemon;
import com.pokemon_team_builder.backend.model.PokemonCollection;
import com.pokemon_team_builder.backend.model.repository.LocalUserRepository;
import com.pokemon_team_builder.backend.model.repository.PokemonCollectionRepository;
import com.pokemon_team_builder.backend.model.repository.PokemonRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class PokemonCollectionService {

    @Autowired
    private LocalUserRepository localUserRepo;

    @Autowired
    private PokemonRepository pokemonRepo;

    @Autowired
    private PokemonCollectionRepository pokemonCollectionRepo;

    public PokemonCollection addPokemonToCollection(String username, String pokemonName) {
        try{
            // Retrieve LocalUser and Pokemon entities
            Optional<LocalUser> localUser = localUserRepo.findByUsernameIgnoreCase(username);
            Optional<Pokemon> pokemon = pokemonRepo.findPokemonByName(pokemonName);

            if(localUser.isEmpty()){
                throw new Error("User not found");
            }

            if(pokemon.isEmpty()){
                throw new Error("Pokemon not found");
            }

            Optional<PokemonCollection> pokemonCollectionCheckEntry = pokemonCollectionRepo.findPokemonCollectionByPokemonId(pokemon.get().getId());

            if(pokemonCollectionCheckEntry.isPresent() && pokemonCollectionCheckEntry.get().getLocalUser().getUsername().equals(username)){
                System.out.println("Pokemon already exists in collection");
                return null; // conflict handle with error 409
            }
            // Create a new PokemonCollection entry
            PokemonCollection pokemonCollection = new PokemonCollection();
            pokemonCollection.setLocalUser(localUser.get());
            pokemonCollection.setPokemon(pokemon.get());

            // Save the PokemonCollection entry
            System.out.println(localUser.get().getId());
            System.out.println(pokemon.get().getId());
            return pokemonCollectionRepo.save(pokemonCollection);
        }
        catch(Exception e){
            System.out.println("issue in service");
            throw new RuntimeException("Failed to save pokemonCollection: " + e.getMessage());
        }

    }
}