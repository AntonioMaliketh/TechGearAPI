package com.maliketh.TechGearAPI.controllers;

import com.maliketh.TechGearAPI.hardware.DadosCadastroHardware;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/hardwares")
public class HardwareController {

    @PostMapping
    public void cadastrar(@RequestBody DadosCadastroHardware dados) {

        System.out.println(dados);
    }
}
