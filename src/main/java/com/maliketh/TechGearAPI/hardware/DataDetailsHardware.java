package com.maliketh.TechGearAPI.hardware;

public record DataDetailsHardware(
    
    Long id,
    
    Category category,
    
    String product,
    
    Brand brand,
    
    int quantity,
    
    boolean active) {

        public DataDetailsHardware(Hardware hardware) {
            this(
                hardware.getId(),
                hardware.getCategory(),
                hardware.getProduct(),
                hardware.getBrand(),
                hardware.getQuantity(),
                hardware.getActive());
        }
}
