package com.maliketh.TechGearAPI.hardware;

import jakarta.persistence.Enumerated;
import jakarta.validation.constraints.NotBlank;

public record DadosCadastroHardware(

        
        @Enumerated
        Tipo tipo,
        
        @NotBlank
        String produto,

        @Enumerated
        Marca marca,

        int quantidade) {
}
