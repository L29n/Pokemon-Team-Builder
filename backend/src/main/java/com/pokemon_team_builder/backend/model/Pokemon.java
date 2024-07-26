package com.pokemon_team_builder.backend.model;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
@Table(name = "pokemon")
public class Pokemon {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private Long id;

    @Column(name = "name", nullable = false, unique = true)
    private String name;

    @Column(name = "base_hp", nullable = false)
    private Integer base_hp;

    @Column(name = "base_atk", nullable = false)
    private Integer base_atk;

    @Column(name = "base_sp_atk", nullable = false)
    private Integer base_sp_atk;

    @Column(name = "base_def", nullable = false)
    private Integer base_def;

    @Column(name = "base_sp_def", nullable = false)
    private Integer base_sp_def;

    @Column(name = "base_spd", nullable = false)
    private Integer base_spd;

    @Column(name = "front_default_sprite", nullable = false, length = 1000)
    private String front_default_sprite;

    @Column(name = "front_female_sprite", length = 1000)
    private String front_female_sprite;

    @Column(name = "front_default_shiny_sprite", length = 1000)
    private String front_default_shiny_sprite;

    @Column(name = "front_female_shiny_sprite", length = 1000)
    private String front_female_shiny_sprite;

    @Column(name = "type_1", nullable = false)
    private String type_1;

    @Column(name = "type_2")
    private String type2;

    @Column(name = "ability_1", nullable = false)
    private String ability_1;

    @Column(name = "ability_2")
    private String ability_2;

    @Column(name = "hidden_ability")
    private String hidden_ability;

}