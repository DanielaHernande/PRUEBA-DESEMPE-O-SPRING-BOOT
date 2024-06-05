package com.riwi.PRUEBA_DESEMPE_O_SPRING_BOOT.domain.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.riwi.PRUEBA_DESEMPE_O_SPRING_BOOT.domain.entities.Student;

@Repository
public interface StudentRepository extends JpaRepository<Student, Long>{
}