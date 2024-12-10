package com.maliketh.TechGearAPI.controllers;

import com.maliketh.TechGearAPI.hardware.DadosAtualizarHardware;
import com.maliketh.TechGearAPI.hardware.DadosCadastroHardware;
import com.maliketh.TechGearAPI.hardware.DadosDetalhamentoHardware;
import com.maliketh.TechGearAPI.hardware.DadosListagemHardware;
import com.maliketh.TechGearAPI.hardware.Hardware;
import com.maliketh.TechGearAPI.hardware.HardwareRepository;

import jakarta.transaction.Transactional;
import jakarta.validation.Valid;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.util.UriComponentsBuilder;


@RestController
@RequestMapping("/hardwares")
public class HardwareController {

    @Autowired
    private HardwareRepository repository;

    @PostMapping
    @Transactional
    public ResponseEntity<DadosDetalhamentoHardware> cadastrar(@RequestBody @Valid DadosCadastroHardware dados, UriComponentsBuilder uriBuilder) {
        var hardware = new Hardware(dados);
        repository.save(hardware);

        var uri = uriBuilder.path("/hardwares/{id}").buildAndExpand(hardware.getId()).toUri();

        return ResponseEntity.created(uri).body(new DadosDetalhamentoHardware(hardware));
    }

    @GetMapping
    public ResponseEntity<List<DadosListagemHardware>> listar (){
        var lista = repository.findAllByAtivoTrue().stream().map(DadosListagemHardware::new).toList();

        return ResponseEntity.ok(lista);
    }

    @PutMapping
    @Transactional
    public ResponseEntity<DadosDetalhamentoHardware> atualizar(@RequestBody @Valid DadosAtualizarHardware dados) {
        var hardware = repository.getReferenceById(dados.id());
        hardware.atualizarinformacoes(dados);

        return ResponseEntity.ok(new DadosDetalhamentoHardware(hardware));
    }

    @DeleteMapping("/{id}")
    @Transactional
    public ResponseEntity<Void> excluir(@PathVariable Long id) {
        repository.deleteById(id);
        
        return ResponseEntity.noContent().build();
    }

    @DeleteMapping("inativar/{id}")
    @Transactional
    public ResponseEntity<Void> inativar (@PathVariable Long id) {
        var hardware = repository.getReferenceById(id);
        hardware.inativar();

        return ResponseEntity.noContent().build();
    }

    @PutMapping("reativar/{id}")
    @Transactional
    public ResponseEntity<Void> Reativar(@PathVariable Long id) {
        var hardware = repository.getReferenceById(id);
        hardware.reativar();

        return ResponseEntity.noContent().build();
    }
}