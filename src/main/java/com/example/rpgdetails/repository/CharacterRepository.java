package com.example.rpgdetails.repository;

import java.util.Optional;
import java.util.UUID;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.rpgdetails.character.Character;


public interface CharacterRepository extends JpaRepository<Character, UUID>{

    Optional<Character> findByNome(String nome);
    
}
