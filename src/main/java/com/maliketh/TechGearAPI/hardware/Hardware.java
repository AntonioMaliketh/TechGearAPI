package com.maliketh.TechGearAPI.hardware;

import jakarta.persistence.*;
import jakarta.validation.Valid;
import lombok.Data;


@Table(name = "hardware")
@Entity(name = "hardwares")
@Data
public class Hardware {

    public Hardware() {
        
    }

    public Hardware(DataRegisterHardware data) {
        this.active = true;
        this.category = data.category();
        this.product = data.product();
        this.brand = data.brand();
        this.quantity = data.quantity();
    }

    @Id 
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Enumerated(EnumType.STRING)
    private Category category;

    private String product;

    @Enumerated(EnumType.STRING)
    private Brand brand;

    private int quantity;

    private Boolean active;

    public void updateinformation(@Valid DataUpdateHardware data) {
        if (data.category() != null) {
            this.category = data.category();
        }

        if (data.product() != null) {
            this.product = data.product();
        }

        if (data.brand() != null) {
            this.brand = data.brand();
        }
    }

    public void inactivate() {
        this.active = false;
    }

    public void reactivate() {
        this.active = true;
    }
}
