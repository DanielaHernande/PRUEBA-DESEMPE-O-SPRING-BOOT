package com.riwi.PRUEBA_DESEMPE_O_SPRING_BOOT.infraestructure.abstract_service;

import com.riwi.PRUEBA_DESEMPE_O_SPRING_BOOT.api.dto.request.LessonRequest;
import com.riwi.PRUEBA_DESEMPE_O_SPRING_BOOT.api.dto.response.LessonResponse;

public interface ILessonService extends CrudService<LessonRequest, LessonResponse, Long> {
    
}
