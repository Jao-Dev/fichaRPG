package com.example.rpgdetails.character;

import java.util.UUID;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter

@Entity
@Table(name = "character")
public class Character {
    
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id")
    private UUID id;

    @Column(name = "nome")
    private String nome;

    @Column(name = "classe")
    private CharacterClasses classe;

    @Column(name = "pvMaximo")
    private Long pvMaximo;

    @Column(name = "pmMaximo")
    private Long pmMaximo;


    private String character;

    private Character(String character){
        this.character = character;
    }

}
