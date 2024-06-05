package com.riwi.PRUEBA_DESEMPE_O_SPRING_BOOT.api.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.riwi.PRUEBA_DESEMPE_O_SPRING_BOOT.api.dto.response.ClassResponse;
import com.riwi.PRUEBA_DESEMPE_O_SPRING_BOOT.infraestructure.abstract_service.IClassService;

import lombok.AllArgsConstructor;

@RestController
@AllArgsConstructor
@RequestMapping(path = "/class")
public class ClassController {

    @Autowired
    private final IClassService classService;

    // Obtener todo
    @GetMapping
    public ResponseEntity<Page<ClassResponse>> getAll(
            @RequestParam(defaultValue = "1") int page,
            @RequestParam(defaultValue = "10") int size
    ) {

        return ResponseEntity.ok(this.classService.getAll(page, size));
    }

    
    
}
