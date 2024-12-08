package com.maliketh.TechGearAPI.hardware;

public record DadosDetalhamentoHardware(
    
    Long id,
    
    Tipo tipo,
    
    String produto,
    
    Marca marca,
    
    int quantidade,
    
    boolean ativo) {

        public DadosDetalhamentoHardware(Hardware hardware) {
            this(
                hardware.getId(),
                hardware.getTipo(),
                hardware.getProduto(),
                hardware.getMarca(),
                hardware.getQuantidade(),
                hardware.getAtivo());
        }
}
