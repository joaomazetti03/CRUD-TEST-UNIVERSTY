package com.example.provacrud.Controller;

import com.example.provacrud.Model.Character;
import com.example.provacrud.Service.CharacterService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/character")
@Tag(name = "Character API", description = "Gerenciamento do Character")
public class CharacterController {

    @Autowired
    CharacterService characterService;

    @Operation(description = "Busca todos os personagens")
    @GetMapping
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Retorna a lista de personagens"),
            @ApiResponse(responseCode = "404", description = "Nenhum personagem encontrado")
    })
    public List<Character> getAllCharacters(){
        return characterService.listCharacters();
    }

    @Operation(description = "Busca personagem por id")
    @GetMapping("/{characterId}")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Retorna o personagem com o id"),
            @ApiResponse(responseCode = "404", description = "Personagem não encontrado")
    })
    public Optional<Character> getCharacterById(@PathVariable Long characterId) {
        return characterService.getCharacterById(characterId);
    }

    @Operation(description = "Cria o personagem")
    @PostMapping
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Personagem criado")
    })
    public String createCharacter(@RequestBody Character character) {
        int sum = character.getAttackCharacter() + character.getDefenseCharacter();
        if (sum != 10) {return "A soma de força e defesa deve ser igual a 10";}

        characterService.insertCharacter(character);
        return "Personagem criado";
    }

    @Operation(description = "Atualiza o nome de aventureiro")
    @PutMapping("/{characterId}/adventurer-name")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Nome de aventureiro atualizado"),
            @ApiResponse(responseCode = "404", description = "Personagem nao encontrado")
    })
    public String updateAdventurerName(@PathVariable Long characterId, @RequestBody Character newName) {
        Character character = characterService.getCharacterById(characterId).orElse(null);
        if (character == null) {return "Personagem não encontrado";}

        character.setAdventurerName(newName.getAdventurerName());
        characterService.updateCharacter(character);
        return "Nome atualizado";
    }

    @Operation(description = "Deleta personagem")
    @DeleteMapping
    @ApiResponses(value = {
            @ApiResponse(responseCode = "204", description = "Personagem deletado")
    })
    public void deleteCharacterById(@PathVariable Long characterId) {
        characterService.deleteCharacterById(characterId);
    }
}
