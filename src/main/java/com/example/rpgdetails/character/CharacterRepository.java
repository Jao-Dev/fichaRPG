package com.example.rpgdetails.character;

import java.util.UUID;

import org.springframework.data.jpa.repository.JpaRepository;


public interface CharacterRepository extends JpaRepository<Character, UUID>{

    Character findByNome(String nome);
    
}
