package com.example.provacrud.Controller;

import com.example.provacrud.Model.Character;
import com.example.provacrud.Service.CharacterService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/character")
@Tag(name = "Character API", description = "Gerenciamento do Character")
public class CharacterController {

    @Autowired
    private final CharacterService characterService;

    public CharacterController(CharacterService characterService) {
        this.characterService = characterService;
    }

    @Operation(description = "Busca todos os personagens")
    @GetMapping
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Retorna a lista de personagens"),
            @ApiResponse(responseCode = "404", description = "Nenhum personagem encontrado")
    })
    public ResponseEntity<List<Character>> getAllCharacters(){
        return ResponseEntity.ok(characterService.listCharacters());
    }

    @Operation(description = "Busca personagem por id")
    @GetMapping("/{characterId}")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Retorna o personagem com o id"),
            @ApiResponse(responseCode = "404", description = "Personagem não encontrado")
    })
    public ResponseEntity<Optional<Character>> getCharacterById(@PathVariable Long characterId) {
        return ResponseEntity.ok(characterService.getCharacterById(characterId));
    }

    @Operation(description = "Cria o personagem")
    @PostMapping
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Personagem criado")
    })
    public ResponseEntity<Character> createCharacter(@RequestBody Character character) {
        return ResponseEntity.ok(characterService.insertCharacter(character));
    }

    @Operation(description = "Atualiza o nome de aventureiro")
    @PutMapping("/{characterId}/adventurer-name")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Nome de aventureiro atualizado"),
            @ApiResponse(responseCode = "404", description = "Personagem nao encontrado")
    })
    public Character updateAdventurerName(@PathVariable Long characterId, @RequestBody Character newName) {
        Character character = characterService.getCharacterById(characterId).orElse(null);
        if (character == null) {
            throw new RuntimeException("Erro ao atualizar o nome de aventureiro");
        }
        character.setAdventurerName(newName.getAdventurerName());
        return characterService.updateCharacter(character);
    }

    @Operation(description = "Deleta personagem")
    @DeleteMapping("/{characterId}")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "204", description = "Personagem deletado")
    })
    public void deleteCharacterById(@PathVariable Long characterId) {
        characterService.deleteCharacterById(characterId);
    }
}
