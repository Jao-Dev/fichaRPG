package com.example.rpgdetails.character;

import com.example.rpgdetails.enums.CharacterClassesEnum;
import com.example.rpgdetails.enums.CharacterRaces;

public record CharacterRequestPayload(String nome, CharacterClassesEnum classe, CharacterRaces raca) {
    
}
