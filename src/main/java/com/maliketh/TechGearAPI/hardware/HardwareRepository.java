package com.maliketh.TechGearAPI.hardware;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

public interface HardwareRepository extends JpaRepository<Hardware, Long> {

    List<Hardware> findAllByAtivoTrue();
    
}
