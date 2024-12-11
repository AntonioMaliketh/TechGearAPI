package com.maliketh.TechGearAPI.hardware;

public record DataListHardware(Long id, Category category, String product, Brand brand) {

    public DataListHardware(Hardware hardware) {
        this(
            hardware.getId(),
            hardware.getCategory(),
            hardware.getProduct(),
            hardware.getBrand());
    }
}
