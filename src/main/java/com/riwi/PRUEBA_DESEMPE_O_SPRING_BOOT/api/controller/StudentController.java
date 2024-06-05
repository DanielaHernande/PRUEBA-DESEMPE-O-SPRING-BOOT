package com.riwi.PRUEBA_DESEMPE_O_SPRING_BOOT.api.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

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
}
