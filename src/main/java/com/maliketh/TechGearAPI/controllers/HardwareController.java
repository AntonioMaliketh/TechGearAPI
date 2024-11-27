package com.maliketh.TechGearAPI.controllers;

import com.maliketh.TechGearAPI.hardware.DadosCadastroHardware;
import com.maliketh.TechGearAPI.hardware.Hardware;
import com.maliketh.TechGearAPI.hardware.HardwareRepository;
import org.springframework.beans.factory.annotation.Autowired;
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
    public void cadastrar(@RequestBody DadosCadastroHardware dados) {
        repository.save(new Hardware(dados));
    }
}
