package com.example.provacrud.Model;

import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.*;

import java.util.ArrayList;
import java.util.List;

@Entity
public class Character {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String characterName;
    private String adventurerName;

    @Enumerated(EnumType.STRING)
    private CharacterClass characterClass;

    @OneToMany(mappedBy = "character", cascade = CascadeType.ALL)
    @JsonManagedReference
    private List<MagicIten> magicItenList = new ArrayList<>();

    private int level;
    private int attackCharacter;
    private int defenseCharacter;

    public Character() {}

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getCharacterName() {
        return characterName;
    }

    public void setCharacterName(String characterName) {
        this.characterName = characterName;
    }

    public String getAdventurerName() {
        return adventurerName;
    }

    public void setAdventurerName(String adventurerName) {
        this.adventurerName = adventurerName;
    }

    public int getLevel() {
        return level;
    }

    public void setLevel(int level) {
        this.level = level;
    }

    public int getAttackCharacter() {
        return attackCharacter;
    }

    public void setAttackCharacter(int forca) {
        this.attackCharacter = forca;
    }

    public int getDefenseCharacter() {
        return defenseCharacter;
    }

    public void setDefenseCharacter(int defense) {
        this.defenseCharacter = defenseCharacter;
    }

    public int getAllAtack(){
        return attackCharacter + magicItenList.stream().mapToInt(MagicIten::getAttackMagicIten).sum();
    }

    public int getAllDefense(){
        return defenseCharacter + magicItenList.stream().mapToInt(MagicIten::getDefenseMagicIten).sum();
    }

    public List<MagicIten> getMagicItenList() {
        return magicItenList;
    }

    public void setMagicItenList(List<MagicIten> magicItenList) {
        this.magicItenList = magicItenList;
    }
}
