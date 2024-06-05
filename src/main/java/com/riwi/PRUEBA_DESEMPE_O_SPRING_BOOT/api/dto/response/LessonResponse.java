package com.riwi.PRUEBA_DESEMPE_O_SPRING_BOOT.api.dto.response;

import java.time.LocalDateTime;
import java.util.List;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class LessonResponse {
    
    private Long id;
    private String title;
    private String content;
    private ClassBasicResponse classId;
    private LocalDateTime createAt;
    private List<MultimediaBasicResponse> multimedias;
}