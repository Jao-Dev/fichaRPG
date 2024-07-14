package com.example.rpgdetails.character;

public enum CharacterClasses {
    
    MAGO("Mago"),
    LADINO("Ladino"),
    GUERREIRO("Guerreiro"),
    DRUIDA("Druida"),
    CAÇADOR("Caçador"),
    CLERIGO("Clerigo"),
    PALADINO("Paladino");



    private String classes;

    private CharacterClasses(String classes){
        this.classes = classes;
    }
}
