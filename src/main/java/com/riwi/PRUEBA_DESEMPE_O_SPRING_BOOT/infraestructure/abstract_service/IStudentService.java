package com.riwi.PRUEBA_DESEMPE_O_SPRING_BOOT.infraestructure.abstract_service;

import com.riwi.PRUEBA_DESEMPE_O_SPRING_BOOT.api.dto.request.StudentRequest;
import com.riwi.PRUEBA_DESEMPE_O_SPRING_BOOT.api.dto.response.StudentResponse;

public interface IStudentService extends CrudService<StudentRequest, StudentResponse, Long> {
    
}
