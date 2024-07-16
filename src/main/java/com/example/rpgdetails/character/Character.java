package com.example.rpgdetails.character;

import java.util.UUID;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
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
@Table(name = "character_details")
public class Character {
    
    @GeneratedValue(strategy = GenerationType.UUID)
    @Id
    @Column(name = "id", nullable = false)
    private UUID id;

    @Column(name = "nome", nullable = false)
    @NotBlank(message = "O campo NOME deve ser preenchido!")
    @Size(min = 3, max = 255, message = "O nome deve ter no mínimo 3 caracteres!")
    private String nome;

    @Column(name = "classe", nullable = false)
    @Enumerated(EnumType.STRING)
    private CharacterClassesEnum classe;

    @Column(name = "raca", nullable = false)
    @Enumerated(EnumType.STRING)
    private CharacterRaces raca;

    @Column(name = "pvMaximo")
    private Long pvMaximo;

    @Column(name = "pmMaximo")
    private Long pmMaximo;

    @Column(name = "forca")
    private Long forca;

    @Column(name = "inteligencia")
    private Long inteligencia;

    @Column(name = "destreza")
    private Long destreza;

    @Column(name = "constituicao")
    private Long constituicao;
    
    @Column(name = "carisma")
    private Long carisma;

    @Column(name = "sabedoria")
    private Long sabedoria;
}
