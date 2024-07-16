package com.example.rpgdetails.character;

import java.util.List;
import java.util.UUID;

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


@RestController
@RequestMapping("/")
public class CharacterController {
    
    @Autowired
    private CharacterRepository repository;

    @PostMapping("/criar")
    public ResponseEntity<Character> criarPersonagem(@RequestBody Character character){
        if (character.getClasse() == null) {
            return ResponseEntity.badRequest().body(null);
        }

        CharacterClassesEnum characterClass = character.getClasse();
        character.setPvMaximo((characterClass.getPvMaximo() + characterClass.getConstituicao()));
        character.setPmMaximo((characterClass.getPmMaximo() + characterClass.getInteligencia()));
        character.setForca(characterClass.getForca());
        character.setInteligencia(characterClass.getInteligencia());
        character.setDestreza(characterClass.getDestreza());
        character.setConstituicao(characterClass.getConstituicao());
        character.setCarisma(characterClass.getCarisma());
        character.setSabedoria(characterClass.getSabedoria());

        character.setId(UUID.randomUUID());

        this.repository.save(character);
        return ResponseEntity.ok(character);
    }

    @GetMapping("/personagens")
    public ResponseEntity<List<Character>> listarPersonagens(){
        return ResponseEntity.ok().body(repository.findAll());
    }

    @GetMapping("/personagens/{nome}")
    public ResponseEntity<Character> encontrarPersonagem(@PathVariable String nome){
        Character character = this.repository.findByNome(nome);

        if (character == null) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(character);
    }

    @PutMapping("/atualizarPersonagem")
    public Character atualizarPersonagem(@RequestBody Character character){
        return repository.save(character);
    }

    //! Permitir somente adm
    @DeleteMapping("/excluirProduto/{id}")
    public void excluirPersonagem(@PathVariable UUID id){
        repository.deleteById(id);
    }
    
}