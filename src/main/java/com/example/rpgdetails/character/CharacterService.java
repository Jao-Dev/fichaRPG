package com.example.rpgdetails.character;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.rpgdetails.repository.CharacterRepository;

@Service
public class CharacterService {
    
    @Autowired
    private CharacterRepository repository;

    public List<CharacterData> getAllCharacters(){
        List<Character> characters = repository.findAll();

        return characters.stream().map(character -> new CharacterData(character.getId(), character.getNome(), character.getClasse())).collect(Collectors.toList());
    }
}
