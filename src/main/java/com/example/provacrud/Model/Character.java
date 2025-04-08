package com.example.provacrud.Model;

import jakarta.persistence.*;

@Entity
@Table(name = "Character")
public class Character {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String characterName;
    private String adventurerName;
    private int level;
    private String magicIten;
    private int attack;
    private int defense;

    private enum classType {GUERREIRO, MAGO, ARQUEIRO, LADINO, BARDO;}

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

    public String getMagicIten() {
        return magicIten;
    }

    public void setMagicIten(String magicIten) {
        this.magicIten = magicIten;
    }

    public int getForca() {
        return attack;
    }

    public void setForca(int forca) {
        this.attack = forca;
    }

    public int getDefense() {
        return defense;
    }

    public void setDefense(int defense) {
        this.defense = defense;
    }

}
