package com.riwi.PRUEBA_DESEMPE_O_SPRING_BOOT.api.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.riwi.PRUEBA_DESEMPE_O_SPRING_BOOT.api.dto.request.StudentRequest;
import com.riwi.PRUEBA_DESEMPE_O_SPRING_BOOT.api.dto.response.StudentResponse;

import com.riwi.PRUEBA_DESEMPE_O_SPRING_BOOT.infraestructure.abstract_service.IStudentService;

import lombok.AllArgsConstructor;

@RestController
@AllArgsConstructor
@RequestMapping(path = "/student")
public class StudentController {
    
    @Autowired
    private final IStudentService studentService;

    // Obtener todo
    @GetMapping
    public ResponseEntity<Page<StudentResponse>> getAll(
            @RequestParam(defaultValue = "1") int page,
            @RequestParam(defaultValue = "10") int size
    ) {

        return ResponseEntity.ok(this.studentService.getAll(page, size));
    }

    // Obtener solo uno
    @GetMapping(path = "/{id}")
    public ResponseEntity<StudentResponse> get(
            @PathVariable Long id
    ) {
        return ResponseEntity.ok(this.studentService.get(id));
    }

    // Crear
    @PostMapping
    public ResponseEntity<StudentResponse> create(
            @Validated @RequestBody StudentRequest request
    ) {

        return ResponseEntity.ok(this.studentService.create(request));
    }

    // Actualizar
    @PutMapping(path = "/{id}")
    public ResponseEntity<StudentResponse> update(
            @Validated @RequestBody StudentRequest request,
            @PathVariable Long id
    ) {

        return ResponseEntity.ok(this.studentService.update(request, id));
    }

    // Delete
    @DeleteMapping(path = "/{id}")
    public ResponseEntity<Void> delete(
            @PathVariable Long id
    ) {

        this.studentService.delete(id);
        return ResponseEntity.noContent().build();
    }
}
