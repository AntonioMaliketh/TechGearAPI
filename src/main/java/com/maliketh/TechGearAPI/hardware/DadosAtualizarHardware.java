package com.maliketh.TechGearAPI.hardware;

import jakarta.validation.constraints.NotNull;

public record DadosAtualizarHardware(
    @NotNull
    Long id, 
    
    Tipo tipo,
    
    String produto,
    
    Marca marca) {

}
