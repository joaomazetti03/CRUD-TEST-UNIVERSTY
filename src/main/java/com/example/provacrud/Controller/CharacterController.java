package com.example.provacrud.Controller;

import com.example.provacrud.Model.Character;
import com.example.provacrud.Service.CharacterService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/character")
public class CharacterController {

    @Autowired
    CharacterService characterService;

    @GetMapping
    public List<Character> getAllCharacters(){
        return characterService.listCharacters();
    }

    @GetMapping("/{characterId}")
    public Optional<Character> getCharacterById(@PathVariable Long characterId) {
        return characterService.getCharacterById(characterId);
    }

    @PostMapping
    public String createCharacter(@RequestBody Character character) {
        int sum = character.getAttackCharacter() + character.getDefenseCharacter();
        if (sum != 10) {return "A soma de força e defesa deve ser igual a 10";}

        characterService.insertCharacter(character);
        return "Personagem criado";
    }

    @PutMapping("/{characterId}/adventurer-name")
    public String updateAdventurerName(@PathVariable Long characterId, @RequestBody Character newName) {
        Character character = characterService.getCharacterById(characterId).orElse(null);
        if (character == null) {return "Personagem não encontrado";}

        character.setAdventurerName(newName.getAdventurerName());
        characterService.updateCharacter(character);
        return "Nome atualizado";
    }

    @DeleteMapping
    public void deleteCharacterById(@PathVariable Long characterId) {
        characterService.deleteCharacterById(characterId);
    }

}
