package com.riwi.PRUEBA_DESEMPE_O_SPRING_BOOT.api.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.riwi.PRUEBA_DESEMPE_O_SPRING_BOOT.api.dto.response.LessonResponse;
import com.riwi.PRUEBA_DESEMPE_O_SPRING_BOOT.infraestructure.abstract_service.ILessonService;
import com.riwi.PRUEBA_DESEMPE_O_SPRING_BOOT.infraestructure.service.LessonService;

import io.swagger.v3.oas.annotations.parameters.RequestBody;
import lombok.AllArgsConstructor;

@RestController
@AllArgsConstructor
@RequestMapping(path = "/lessons")
public class LessonController {

    @Autowired
    private final ILessonService lessonService;
    
    // Obtener todo
    @GetMapping
    public ResponseEntity<Page<LessonResponse>> getAll(
            @RequestParam(defaultValue = "1") int page,
            @RequestParam(defaultValue = "6") int size
    ) {

        return ResponseEntity.ok(this.lessonService.getAll(page, size));
    }
}
