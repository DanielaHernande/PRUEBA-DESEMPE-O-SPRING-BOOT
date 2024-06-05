package com.riwi.PRUEBA_DESEMPE_O_SPRING_BOOT.api.dto.request;

import java.time.LocalDateTime;

import com.riwi.PRUEBA_DESEMPE_O_SPRING_BOOT.utils.enums.Contenido;

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
public class MultimediaRequest {
    
    @NotNull(message = "El contenido es requerido")
    private Contenido type;

    @NotBlank(message = "La url del contenido multimedia es requerido")
    private String url;

    @NotNull(message = "EL id de la lesson es requerido")
    private Long lessonId;

    @NotNull(message = "La activacion es requerida")
    private boolean active;
}
