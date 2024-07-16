package com.example.rpgdetails.character;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;


@AllArgsConstructor
@NoArgsConstructor
@Getter

public enum CharacterClassesEnum {
    
    MAGO(1L, 1L, 1L, 1L, 1L),
    LADINO(2L, 2L, 2L, 2L, 2L),
    GUERREIRO(3L, 3L, 3L, 3L, 3L),
    DRUIDA(4L, 4L, 4L, 4L, 4L),
    CAÇADOR(5L, 5L, 5L, 5L, 5L),
    CLERIGO(6L, 6L, 6L, 6L, 6L),
    PALADINO(7L, 7L, 7L, 7L, 7L);

    private Long pvMaximo;
    private Long pmMaximo;
    private Long forca;
    private Long inteligencia;
    private Long destreza;
    

}
