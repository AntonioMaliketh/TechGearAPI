package com.maliketh.TechGearAPI.controllers;

import com.maliketh.TechGearAPI.hardware.DadosCadastroHardware;
import com.maliketh.TechGearAPI.hardware.DadosListagemHardware;
import com.maliketh.TechGearAPI.hardware.Hardware;
import com.maliketh.TechGearAPI.hardware.HardwareRepository;

import jakarta.transaction.Transactional;
import jakarta.validation.Valid;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/hardwares")
public class HardwareController {

    @Autowired
    private HardwareRepository repository;

    @PostMapping
    @Transactional
    public void cadastrar(@RequestBody @Valid DadosCadastroHardware dados) {
        repository.save(new Hardware(dados));
    }

    @GetMapping
    public List<DadosListagemHardware> listar (){
        return repository.findAll().stream().map(DadosListagemHardware::new).toList();
    }
}
