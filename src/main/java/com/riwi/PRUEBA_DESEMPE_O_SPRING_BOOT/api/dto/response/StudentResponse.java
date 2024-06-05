package com.riwi.PRUEBA_DESEMPE_O_SPRING_BOOT.api.dto.response;

import java.time.LocalDateTime;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class StudentResponse {
    
    private Long id;
    private String name;
    private String email;
    private ClassBasicResponse classId;
    private LocalDateTime createAt;
    private boolean active;
}
