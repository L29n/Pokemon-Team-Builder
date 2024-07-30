package com.pokemon_team_builder.backend.model;

import java.io.Serializable;
import java.util.Objects;

public class PokemonCollectionId implements Serializable {
    private long localUser;
    private long pokemon;

    public PokemonCollectionId() {}

    public PokemonCollectionId(long localUser, long pokemon) {
        this.localUser = localUser;
        this.pokemon = pokemon;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        PokemonCollectionId that = (PokemonCollectionId) o;
        return localUser == that.localUser && pokemon == that.pokemon;
    }

    @Override
    public int hashCode() {
        return Objects.hash(localUser, pokemon);
    }
}
