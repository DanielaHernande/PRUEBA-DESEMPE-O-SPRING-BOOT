package com.riwi.PRUEBA_DESEMPE_O_SPRING_BOOT.domain.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.riwi.PRUEBA_DESEMPE_O_SPRING_BOOT.domain.entities.ClassEntity;

@Repository
public interface ClassRepository extends JpaRepository<ClassEntity, Long>{
    

}
