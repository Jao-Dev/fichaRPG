package com.example.rpgdetails.character;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;


@AllArgsConstructor
@NoArgsConstructor
@Getter

public enum CharacterClassesEnum {

    //24 pontos, +3 pontos pra atributo bônus
    //vida escala com constituição
    //mana escala com inteligencia*3

    CACADOR(10L, 12L, 8L, 8L, 8L, 8L, 8L, 8L),
    GUERREIRO(10L,12L, 8L, 8L, 8L, 8L, 8L, 8L),
    MAGO(10L, 12L, 8L, 8L, 8L, 8L, 8L, 8L),
    LADINO(10L, 12L, 8L, 8L, 8L, 8L, 8L, 8L),
    MONGE(10L, 12L, 8L, 8L, 8L, 8L, 8L, 8L);

    private Long pvMaximo;
    private Long pmMaximo;
    private Long forca;
    private Long inteligencia;
    private Long destreza;
    private Long constituicao;
    private Long carisma;
    private Long sabedoria;

}
