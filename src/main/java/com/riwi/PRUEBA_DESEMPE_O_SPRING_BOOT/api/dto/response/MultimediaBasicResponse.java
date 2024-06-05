package com.riwi.PRUEBA_DESEMPE_O_SPRING_BOOT.api.dto.response;

import java.time.LocalDateTime;

import com.riwi.PRUEBA_DESEMPE_O_SPRING_BOOT.utils.enums.Contenido;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class MultimediaBasicResponse {
    
    private Long id;
    private Contenido type;
    private String url;
    private LocalDateTime createdId;
    private boolean active;
}
