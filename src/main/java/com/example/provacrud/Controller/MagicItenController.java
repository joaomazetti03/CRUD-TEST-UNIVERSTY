package com.example.provacrud.Controller;

import com.example.provacrud.Model.Character;
import com.example.provacrud.Model.MagicIten;
import com.example.provacrud.Model.MagicItenType;
import com.example.provacrud.Service.CharacterService;
import com.example.provacrud.Service.MagicIntenService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/magicIten")
@Tag(name = "Magic Iten API", description = "Gerencimento do Magic Iten")
public class MagicItenController {

    @Autowired
    private MagicIntenService magicIntenService;
    @Autowired
    private CharacterService characterService;

    @Operation(description = "Lista todos os itens mágicos")
    @GetMapping
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Retorna lista de itens"),
            @ApiResponse(responseCode = "404", description = "Nenhum item encontrado")
    })
    public List<MagicIten> getAllMagicIten() {
        return magicIntenService.listMagicIten();
    }

    @Operation(description = "Busca item mágico por id")
    @GetMapping("/{magicItenId}")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Retorna item com o id"),
            @ApiResponse(responseCode = "404", description = "Item não encontrado")
    })
    public Optional<MagicIten> getMagicItenById(@PathVariable Long magicItenId) {
        return magicIntenService.getMagicItenById(magicItenId);
    }

    @Operation(description = "Busca item mágico atribuido ao personagem")
    @GetMapping("/character/{characterId}")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Retorna item por personagem com o id"),
            @ApiResponse(responseCode = "404", description = "Personagem não encontrado")
    })
    public List<MagicIten> getMagicItenByCharacter(@PathVariable Long characterId) {
        return magicIntenService.findByCharacterId(characterId);
    }

    @Operation(description = "Busca amuleto por personagem")
    @GetMapping("/character/{characterId}/amulet")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Retorna amuleto"),
            @ApiResponse(responseCode = "404", description = "Amuleto nao encontrado")
    })
    public MagicIten getAmulet(@PathVariable Long characterId) {
        return magicIntenService.findByCharacterId(characterId).stream()
                .filter(i -> i.getMagicItenType() == MagicItenType.AMULETO)
                .findFirst().orElse(null);
    }

    @Operation(description = "Cria o item mágico")
    @PostMapping
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Item criado com sucesso")
    })
    public String createMagicIten(@RequestBody MagicIten magicIten) {
        if(magicIten.getAttackMagicIten() == 0 && magicIten.getDefenseMagicIten() == 0){return "Item não pode ter força e defesa 0";}
        if(magicIten.getAttackMagicIten() > 10 && magicIten.getDefenseMagicIten() > 10){return "Força e defesa deve ser no máximo 10";}

        if(magicIten.getMagicItenType() ==MagicItenType.ARMA && magicIten.getDefenseMagicIten() != 0){return "Tipo arma deve ter defesa 0";}
        if(magicIten.getMagicItenType() == MagicItenType.ARMADURA && magicIten.getAttackMagicIten() != 0){return "Tipo armadura deve ter força 0";}

        magicIntenService.insertMagicIten(magicIten);
        return "Item mágico criado";
    }

    @Operation(description = "Atribui um item mágico ao personagem")
    @PostMapping("/{magicItenId}/add/{characterId}")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Item atribuido"),
            @ApiResponse(responseCode = "404", description = "Item ou personagem nao encontrado")
    })
    public String addItenForCharacter(@PathVariable Long magicItenId, @PathVariable Long characterId) {
        MagicIten magicIten = magicIntenService.getMagicItenById(magicItenId).orElse(null);
        Character character = characterService.getCharacterById(characterId).orElse(null);

        if (magicIten == null || character == null) {return "Item ou personagem não encontrado";}

        if (magicIten.getMagicItenType() == MagicItenType.ARMA) {
            boolean haveMagicIten = character.getMagicItenList().stream()
                    .anyMatch(i -> i.getMagicItenType() == MagicItenType.AMULETO);
            if (haveMagicIten) {return "Personagem já tem amuleto";}
        }

        magicIten.setCharacter(character);
        magicIntenService.saveMagicIten(magicIten);
        return "Item atribuido ao personagem";
    }

    @Operation(description = "Remove item mágico do personagem")
    @DeleteMapping("/{magicItenId}/remove-character")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "204", description = "Item removido"),
            @ApiResponse(responseCode = "404", description = "Item nao encontrado")
    })
    public String removeMagicItenFromCharacter(@PathVariable Long magicItenId) {
        MagicIten magicIten = magicIntenService.getMagicItenById(magicItenId).orElse(null);
        if (magicIten == null){return "Item não encontrado";}

        magicIten.setCharacter(null);
        magicIntenService.saveMagicIten(magicIten);
        return "Item removido do personagem";
    }

    @Operation(description = "Deleta item mágico")
    @DeleteMapping
    @ApiResponses(value = {
            @ApiResponse(responseCode = "204", description = "Item apagado"),
            @ApiResponse(responseCode = "404", description = "Item nao encontrado")
    })
    public void deleteMagicItenById(@PathVariable Long magicItenId) {
        magicIntenService.deleteMagicItenById(magicItenId);
    }
}
