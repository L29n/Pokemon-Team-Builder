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

    public PokemonCollection addPokemonToCollection(String username, String pokemonName) throws PokemonAlreadyInCollectionException {
        // Retrieve LocalUser and Pokemon entities
        Optional<LocalUser> localUserOpt = localUserRepo.findByUsernameIgnoreCase(username);
        Optional<Pokemon> pokemonOpt = pokemonRepo.findPokemonByName(pokemonName);

        if (localUserOpt.isEmpty()) {
            throw new IllegalArgumentException("User not found");
        }

        if (pokemonOpt.isEmpty()) {
            throw new IllegalArgumentException("Pokemon not found");
        }

        LocalUser localUser = localUserOpt.get();
        Pokemon pokemon = pokemonOpt.get();

        // Check if the Pokemon is already in the user's collection
        Optional<PokemonCollection> existingEntry = pokemonCollectionRepo.findByLocalUserAndPokemon(localUser, pokemon);

        if (existingEntry.isPresent()) {
            throw new PokemonAlreadyInCollectionException("Pokemon already exists in collection");
        }

        // Create a new PokemonCollection entry
        PokemonCollection pokemonCollection = new PokemonCollection();
        pokemonCollection.setLocalUser(localUser);
        pokemonCollection.setPokemon(pokemon);

        // Save the PokemonCollection entry
        try {
            return pokemonCollectionRepo.save(pokemonCollection);
        } catch (Exception e) {
            throw new RuntimeException("Failed to save PokemonCollection: " + e.getMessage());
        }
    }
}
