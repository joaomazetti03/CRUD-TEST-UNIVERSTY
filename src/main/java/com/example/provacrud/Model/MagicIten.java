package com.example.provacrud.Model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class MagicIten {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String magicItenName;
    private String typeMagicIten;
    private int attackMagicIten;
    private int defenseMagicIten;

    private enum typeMagicIten {
        ARMA, ARMADURA, AMULETO;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getMagicItenName() {
        return magicItenName;
    }

    public void setMagicItenName(String magicItenName) {
        this.magicItenName = magicItenName;
    }

    public String getTypeMagicIten() {
        return typeMagicIten;
    }

    public void setTypeMagicIten(String typeMagicIten) {
        this.typeMagicIten = typeMagicIten;
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
}
