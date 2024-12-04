package com.maliketh.TechGearAPI.hardware;

public record DadosListagemHardware(Tipo tipo, String produto, Marca marca) {

    public DadosListagemHardware(Hardware hardware) {
        this(hardware.getTipo(), hardware.getProduto(), hardware.getMarca());
    }
}
