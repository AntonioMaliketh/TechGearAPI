package com.maliketh.TechGearAPI.hardware;

import jakarta.persistence.Enumerated;
import jakarta.validation.constraints.NotBlank;

public record DataRegisterHardware(

        
        @Enumerated
        Category category,
        
        @NotBlank
        String product,

        @Enumerated
        Brand brand,

        int quantity) {
}
