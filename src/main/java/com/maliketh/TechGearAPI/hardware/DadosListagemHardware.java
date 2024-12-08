package com.maliketh.TechGearAPI.hardware;

public record DadosListagemHardware(Long id, Tipo tipo, String produto, Marca marca) {

    public DadosListagemHardware(Hardware hardware) {
        this(
            hardware.getId(),
            hardware.getTipo(),
            hardware.getProduto(),
            hardware.getMarca());
    }
}
