package com.example.provacrud.Model;

import jakarta.persistence.*;

@Entity
public class MagicIten {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long magicItenId;
    private String magicItenName;

    @Enumerated(EnumType.STRING)
    private MagicItenType magicItenType;

    private int attackMagicIten;
    private int defenseMagicIten;

    @ManyToOne
    @JoinColumn(name = "character_id")
    private Character character;

    public Long getMagicItenId() {
        return magicItenId;
    }

    public void setMagicItenId(Long magicItenId) {
        this.magicItenId = magicItenId;
    }

    public String getMagicItenName() {
        return magicItenName;
    }

    public void setMagicItenName(String magicItenName) {
        this.magicItenName = magicItenName;
    }

    public int getAttackMagicIten() {
        return attackMagicIten;
    }

    public void setAttackMagicIten(int attackMagicIten) {
        this.attackMagicIten = attackMagicIten;
    }

    public int getDefenseMagicIten() {
        return defenseMagicIten;
    }

    public void setDefenseMagicIten(int defenseMagicIten) {
        this.defenseMagicIten = defenseMagicIten;
    }

    public MagicItenType getMagicItenType() {
        return magicItenType;
    }

    public void setMagicItenType(MagicItenType magicItenType) {
        this.magicItenType = magicItenType;
    }

    public Character getCharacter() {
        return character;
    }

    public void setCharacter(Character character) {
        this.character = character;
    }
}
