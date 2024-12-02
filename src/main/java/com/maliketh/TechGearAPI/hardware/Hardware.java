package com.maliketh.TechGearAPI.hardware;

import jakarta.persistence.*;
import lombok.Data;


@Table(name = "hardware")
@Entity(name = "hardwares")
@Data
public class Hardware {

    public Hardware(DadosCadastroHardware dados) {
        this.tipo=dados.tipo();
        this.produto=dados.produto();
        this.marca=dados.marca();
        this.quantidade=dados.quantidade();
    }

    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Enumerated(EnumType.STRING)
    private Tipo tipo;
    private String produto;

    @Enumerated(EnumType.STRING)
    private Marca marca;
    private int quantidade;
}
