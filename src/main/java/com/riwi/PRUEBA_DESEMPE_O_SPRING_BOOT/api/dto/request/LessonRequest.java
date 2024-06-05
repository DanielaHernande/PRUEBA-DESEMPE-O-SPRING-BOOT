package com.riwi.PRUEBA_DESEMPE_O_SPRING_BOOT.api.dto.request;

import java.time.LocalDateTime;

import jakarta.validation.constraints.FutureOrPresent;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class LessonRequest {
    
    @NotBlank(message = "El titulo de la leccion es requerido")
    private String title;

    @NotBlank(message = "El contenido de la leccin es requerida")
    private String content;

    @NotNull(message = "EL id de la clase es requerido")
    private Long classId;

    @NotNull(message = "La activacion es requerida")
    private boolean active;
}
