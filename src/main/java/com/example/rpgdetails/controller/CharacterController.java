package com.example.rpgdetails.controller;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

import org.apache.catalina.connector.Response;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.rpgdetails.character.AtributesRequestPayload;
import com.example.rpgdetails.character.Character;
import com.example.rpgdetails.character.CharacterCreateResponse;
import com.example.rpgdetails.character.CharacterData;
import com.example.rpgdetails.character.CharacterRequestPayload;
import com.example.rpgdetails.character.CharacterService;
import com.example.rpgdetails.repository.CharacterRepository;


@RestController
@RequestMapping("/")
public class CharacterController {
    
    @Autowired
    private CharacterRepository repository;
    @Autowired
    private CharacterService service;

    @PostMapping("/criar")
    public ResponseEntity<CharacterCreateResponse> criarPersonagem(@RequestBody CharacterRequestPayload payload){
        Character newCharacter = new Character(payload);
        
        this.repository.save(newCharacter);
        return ResponseEntity.ok(new CharacterCreateResponse(newCharacter.getId()));
    }   

    @GetMapping("/{nome}")
    public ResponseEntity<Character> encontrarPersonagem(@PathVariable String nome){
        Optional<Character> character = this.repository.findByNome(nome);

        return character.map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.notFound().build());
    }
    
    @PutMapping("/atualizarPersonagem")
    public ResponseEntity<Character> atualizarPersonagem(@PathVariable UUID id, @RequestBody AtributesRequestPayload payload){
        Optional<Character> character = this.repository.findById(id);
        
        if(character.isPresent()){
            Character rawCharacter = character.get();
            rawCharacter.setPvMaximo(payload.pvMaximo());
            rawCharacter.setPmMaximo(payload.pmMaximo());
            rawCharacter.setForca(payload.forca());
            rawCharacter.setInteligencia(payload.inteligencia());
            rawCharacter.setDestreza(payload.destreza());
            rawCharacter.setConstituicao(payload.constituicao());
            rawCharacter.setCarisma(payload.carisma());
            rawCharacter.setSabedoria(payload.sabedoria());

            this.repository.save(rawCharacter);

            return ResponseEntity.ok(rawCharacter);
        }
        return ResponseEntity.notFound().build();
    }


    @GetMapping("/personagens")
    public ResponseEntity<List<CharacterData>> listarPersonagens(){
        List<CharacterData> characterDataList = this.service.getAllCharacters();
        return ResponseEntity.ok(characterDataList);
    }

    @DeleteMapping("/{id}")
    public void excluirPersonagem(@PathVariable UUID id){
        repository.deleteById(id);
    }
    
}