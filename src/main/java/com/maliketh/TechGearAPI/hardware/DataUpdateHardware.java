package com.maliketh.TechGearAPI.hardware;

import jakarta.validation.constraints.NotNull;

public record DataUpdateHardware(
    @NotNull
    Long id, 
    
    Category category,
    
    String product,
    
    Brand brand) {

}
