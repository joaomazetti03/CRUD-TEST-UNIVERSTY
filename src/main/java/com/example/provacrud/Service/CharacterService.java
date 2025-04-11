package com.example.provacrud.Service;

import com.example.provacrud.Model.Character;
import com.example.provacrud.Model.MagicIten;
import com.example.provacrud.Repository.CharacterRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CharacterService {

    @Autowired
    CharacterRepository characterRepository;

    public List<Character> listCharacters() {
        return characterRepository.findAll();
    }

    public Optional<Character> getCharacterById(Long characterId) {
        return characterRepository.findById(characterId);
    }

    public Character insertCharacter(Character character) {
        return characterRepository.save(character);
    }

    public Character updateCharacter(Character character) {
        return characterRepository.save(character);
    }

    public void deleteCharacterById(Long characterId) {
        characterRepository.deleteById(characterId);
    }
}
