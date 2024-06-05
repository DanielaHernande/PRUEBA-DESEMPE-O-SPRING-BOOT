package com.riwi.PRUEBA_DESEMPE_O_SPRING_BOOT.api.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.riwi.PRUEBA_DESEMPE_O_SPRING_BOOT.api.dto.request.ClassRequest;
import com.riwi.PRUEBA_DESEMPE_O_SPRING_BOOT.api.dto.response.ClassResponse;
import com.riwi.PRUEBA_DESEMPE_O_SPRING_BOOT.domain.entities.ClassEntity;
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

    // Obtener solo uno
    @GetMapping(path = "/{id}")
    public ResponseEntity<ClassResponse> get(
            @PathVariable Long id
    ) {

        return ResponseEntity.ok(this.classService.get(id));
    }

    @PostMapping
    public ResponseEntity<ClassResponse> create(
            @Validated @RequestBody ClassRequest request
    ) {
        return ResponseEntity.ok(this.classService.create(request));
    }
    
}
