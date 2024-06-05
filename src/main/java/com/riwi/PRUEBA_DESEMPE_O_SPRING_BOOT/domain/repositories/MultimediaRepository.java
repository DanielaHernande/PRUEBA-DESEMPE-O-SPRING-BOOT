package com.riwi.PRUEBA_DESEMPE_O_SPRING_BOOT.domain.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.riwi.PRUEBA_DESEMPE_O_SPRING_BOOT.domain.entities.Multimedia;

public interface MultimediaRepository extends JpaRepository<Multimedia, Long>{
    
}
