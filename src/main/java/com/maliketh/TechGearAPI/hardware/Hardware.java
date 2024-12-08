package com.maliketh.TechGearAPI.hardware;

import jakarta.persistence.*;
import jakarta.validation.Valid;
import lombok.Data;


@Table(name = "hardware")
@Entity(name = "hardwares")
@Data
public class Hardware {

    public Hardware() {
        
    }

    public Hardware(DadosCadastroHardware dados) {
        this.ativo = true;
        this.tipo = dados.tipo();
        this.produto = dados.produto();
        this.marca = dados.marca();
        this.quantidade = dados.quantidade();
    }

    @Id 
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Enumerated(EnumType.STRING)
    private Tipo tipo;

    private String produto;

    @Enumerated(EnumType.STRING)
    private Marca marca;

    private int quantidade;

    private Boolean ativo;

    public void atualizarinformacoes(@Valid DadosAtualizarHardware dados) {
        if (dados.tipo() != null) {
            this.tipo = dados.tipo();
        }

        if (dados.produto() != null) {
            this.produto = dados.produto();
        }

        if (dados.marca() != null) {
            this.marca = dados.marca();
        }
    }

    public void inativar() {
        this.ativo = false;
    }

    public void reativar() {
        this.ativo = true;
    }
}
