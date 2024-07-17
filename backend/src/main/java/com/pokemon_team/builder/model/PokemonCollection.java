package com.pokemon_team.builder.model;

import jakarta.persistence.*;

@Entity
@Table(name = "pokemon_collection")
public class PokemonCollection {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private Long id;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

}

