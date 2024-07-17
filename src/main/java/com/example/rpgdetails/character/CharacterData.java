package com.example.rpgdetails.character;

import java.util.UUID;

import com.example.rpgdetails.enums.CharacterClassesEnum;

public record CharacterData(UUID id, String nome, CharacterClassesEnum classe) {
    
}
