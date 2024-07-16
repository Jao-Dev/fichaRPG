package com.example.rpgdetails.character;

import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor
@Getter

public class CharacterDTO {
    private String nome;
    private Long pvMaximo;
    private Long pmMaximo;
    private Long forca;
    private Long inteligencia;
    private Long destreza;
    private Long constituicao;
    private Long carisma;
    private Long sabedoria;
}   
