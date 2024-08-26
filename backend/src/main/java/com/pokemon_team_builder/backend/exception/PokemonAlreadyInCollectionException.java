package com.pokemon_team_builder.backend.exception;

public class PokemonAlreadyInCollectionException extends Exception{
    public PokemonAlreadyInCollectionException(String message) {
        super(message);
    }
}
