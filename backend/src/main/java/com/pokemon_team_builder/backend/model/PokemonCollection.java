package com.pokemon_team_builder.backend.model;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
@Table(name = "pokemon_collection")
@IdClass(PokemonCollectionId.class)
public class PokemonCollection {
    @Id
    @ManyToOne(optional = false)
    @JoinColumn(name = "local_user_id", nullable = false, unique = true)
    private LocalUser localUser;

    @Id
    @ManyToOne(optional = false)
    @JoinColumn(name = "pokemon_id", nullable = false, unique = true)
    private Pokemon pokemon;

}



