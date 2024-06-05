package com.riwi.PRUEBA_DESEMPE_O_SPRING_BOOT.api.dto.response;

import java.time.LocalDateTime;
import java.util.List;

import com.riwi.PRUEBA_DESEMPE_O_SPRING_BOOT.domain.entities.Lesson;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class ClassResponse {
    
    private Long id;
    private String name;
    private String description;
    private LocalDateTime createdAt;
    private boolean active;

    // Lesson
    private List<Lesson> lessons;
}
