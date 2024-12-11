package com.maliketh.TechGearAPI.controllers;

import com.maliketh.TechGearAPI.hardware.DataUpdateHardware;
import com.maliketh.TechGearAPI.hardware.DataRegisterHardware;
import com.maliketh.TechGearAPI.hardware.DataDetailsHardware;
import com.maliketh.TechGearAPI.hardware.DataListHardware;
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
    public ResponseEntity<DataDetailsHardware> register(@RequestBody @Valid DataRegisterHardware data, UriComponentsBuilder uriBuilder) {
        var hardware = new Hardware(data);
        repository.save(hardware);

        var uri = uriBuilder.path("/hardwares/{id}").buildAndExpand(hardware.getId()).toUri();

        return ResponseEntity.created(uri).body(new DataDetailsHardware(hardware));
    }

    @GetMapping
    public ResponseEntity<List<DataListHardware>> listing (){
        var list = repository.findAllByActiveTrue().stream().map(DataListHardware::new).toList();

        return ResponseEntity.ok(list);
    }

    @PutMapping
    @Transactional
    public ResponseEntity<DataDetailsHardware> update(@RequestBody @Valid DataUpdateHardware data) {
        var hardware = repository.getReferenceById(data.id());
        hardware.updateinformation(data);

        return ResponseEntity.ok(new DataDetailsHardware(hardware));
    }

    @DeleteMapping("/{id}")
    @Transactional
    public ResponseEntity<Void> delete(@PathVariable Long id) {
        repository.deleteById(id);
        
        return ResponseEntity.noContent().build();
    }

    @DeleteMapping("inactivate/{id}")
    @Transactional
    public ResponseEntity<Void> Inactivate (@PathVariable Long id) {
        var hardware = repository.getReferenceById(id);
        hardware.inactivate();

        return ResponseEntity.noContent().build();
    }

    @PutMapping("reactivate/{id}")
    @Transactional
    public ResponseEntity<Void> Reactivate (@PathVariable Long id) {
        var hardware = repository.getReferenceById(id);
        hardware.reactivate();

        return ResponseEntity.noContent().build();
    }

    @GetMapping("/{id}")
    public ResponseEntity<DataDetailsHardware> Detail (@PathVariable Long id) {
        var hardware = repository.getReferenceById(id);
        
        return ResponseEntity.ok(new DataDetailsHardware(hardware));
    }
}