package com.pokemon_team_builder.backend;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Data;


@Entity
@Data
@Table(name= "TestTable")

public class TestTable {
    @Id
    @Column(name = "ID")
    private  int id;

    @Column(name = "NAME")
    private String name;
}
