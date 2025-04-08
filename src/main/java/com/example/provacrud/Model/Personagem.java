package com.example.provacrud.Model;

import jakarta.persistence.*;

@Entity
@Table(name = "Personagem")
public class Personagem {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String nomePersonagem;
    private String nomeAventureiro;
    private String classe;
    private int level;
    private String itemMagico;
    private int forca;
    private int defesa;

    public Personagem(String nomePersonagem, String nomeAventureiro, String classe, int level, String itemMagico, int forca, int defesa) {
        this.nomePersonagem = nomePersonagem;
        this.nomeAventureiro = nomeAventureiro;
        this.classe = classe;
        this.level = level;
        this.itemMagico = itemMagico;
        this.forca = forca;
        this.defesa = defesa;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNomePersonagem() {
        return nomePersonagem;
    }

    public void setNomePersonagem(String nomePersonagem) {
        this.nomePersonagem = nomePersonagem;
    }

    public String getNomeAventureiro() {
        return nomeAventureiro;
    }

    public void setNomeAventureiro(String nomeAventureiro) {
        this.nomeAventureiro = nomeAventureiro;
    }

    public String getClasse() {
        return classe;
    }

    public void setClasse(String classe) {
        this.classe = classe;
    }

    public int getLevel() {
        return level;
    }

    public void setLevel(int level) {
        this.level = level;
    }

    public String getItemMagico() {
        return itemMagico;
    }

    public void setItemMagico(String itemMagico) {
        this.itemMagico = itemMagico;
    }

    public int getForca() {
        return forca;
    }

    public void setForca(int forca) {
        this.forca = forca;
    }

    public int getDefesa() {
        return defesa;
    }

    public void setDefesa(int defesa) {
        this.defesa = defesa;
    }
}
