package com.example.provacrud.Model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class ItemMagico {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String nomeItemMagico;
    private String tipoItemMagico;
    private int forcaItemMagico;
    private int defesaItemMagico;

    public ItemMagico(String nomeItemMagico, String tipoItemMagico, int forcaItemMagico, int defesaItemMagico) {
        this.nomeItemMagico = nomeItemMagico;
        this.tipoItemMagico = tipoItemMagico;
        this.forcaItemMagico = forcaItemMagico;
        this.defesaItemMagico = defesaItemMagico;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNomeItemMagico() {
        return nomeItemMagico;
    }

    public void setNomeItemMagico(String nomeItemMagico) {
        this.nomeItemMagico = nomeItemMagico;
    }

    public String getTipoItemMagico() {
        return tipoItemMagico;
    }

    public void setTipoItemMagico(String tipoItemMagico) {
        this.tipoItemMagico = tipoItemMagico;
    }

    public int getForcaItemMagico() {
        return forcaItemMagico;
    }

    public void setForcaItemMagico(int forcaItemMagico) {
        this.forcaItemMagico = forcaItemMagico;
    }

    public int getDefesaItemMagico() {
        return defesaItemMagico;
    }

    public void setDefesaItemMagico(int defesaItemMagico) {
        this.defesaItemMagico = defesaItemMagico;
    }
}
