package com.example.provacrud.Service;

import com.example.provacrud.Model.Character;
import com.example.provacrud.Repository.CharacterRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PersonagemService {

    @Autowired
    CharacterRepository characterRepository;

    public List<Character> listCharacters() {
        return characterRepository.findAll();
    }

    public Character getCharacterById(Long id) {
        return characterRepository.findById(id).orElse(null);
    }

    public Character insertCharacter(Character character) {
        return characterRepository.save(character);
    }

    public Character updateCharacter(Character character) {
        return characterRepository.save(character);
    }

    public Character deleteCharacterById(Long id) {
        Character character = getCharacterById(id);
        characterRepository.delete(character);
        return character;
    }
}
