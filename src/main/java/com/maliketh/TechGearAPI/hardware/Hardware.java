package com.maliketh.TechGearAPI.hardware;

import jakarta.persistence.*;
import lombok.Data;


@Table(name = "Hardware")
@Entity(name = "hardwares")
@Data
public class Hardware {

    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Enumerated(EnumType.STRING)
    private Tipo tipo;
    private String produto;

    @Enumerated(EnumType.STRING)
    private Marca marca;
    private String quantidade;
}
