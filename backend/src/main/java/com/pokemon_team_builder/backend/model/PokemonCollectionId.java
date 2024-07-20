package com.pokemon_team_builder.backend.model;

import java.io.Serializable;
import java.util.Objects;

public class PokemonCollectionId implements Serializable {
    private LocalUser localUser;
    private Pokemon pokemon;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        PokemonCollectionId that = (PokemonCollectionId) o;
        return Objects.equals(localUser, that.localUser) && Objects.equals(pokemon, that.pokemon);
    }

    @Override
    public int hashCode() {
        return Objects.hash(localUser, pokemon);
    }
}