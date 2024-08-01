package com.pokemon_team_builder.backend.service;

import com.pokemon_team_builder.backend.Controller.PokemonCollectionController;
import com.pokemon_team_builder.backend.Repository.PokemonCollectionRepo;

import com.pokemon_team_builder.backend.Repository.PokemonRepo;
import com.pokemon_team_builder.backend.Repository.UserRepo;
import com.pokemon_team_builder.backend.model.LocalUser;
import com.pokemon_team_builder.backend.model.Pokemon;
import com.pokemon_team_builder.backend.model.PokemonCollection;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PokemonCollectionService {
    @Autowired
    private UserRepo localUserRepo;

    @Autowired
    private PokemonRepo pokemonRepo;

    @Autowired
    private PokemonCollectionRepo pokemonCollectionRepo;

    public PokemonCollection addPokemonToCollection(PokemonCollection pc) {
        // Retrieve LocalUser and Pokemon entities
        LocalUser localUser = localUserRepo.findLocalUserByUsername(pc.getLocalUser().getUsername());
//                .orElseThrow(() -> new EntityNotFoundException("LocalUser not found"));
        Pokemon pokemon = pokemonRepo.findPokemonByName(pc.getPokemon().getName());
//                .orElseThrow(() -> new EntityNotFoundException("Pokemon not found"));

        // Create a new PokemonCollection entry
        PokemonCollection pokemonCollection = new PokemonCollection();
        pokemonCollection.setLocalUser(localUser);
        pokemonCollection.setPokemon(pokemon);

        // Save the PokemonCollection entry
        return pokemonCollectionRepo.save(pokemonCollection);
    }
}
