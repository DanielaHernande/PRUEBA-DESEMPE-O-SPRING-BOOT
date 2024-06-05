package com.riwi.PRUEBA_DESEMPE_O_SPRING_BOOT.infraestructure.abstract_service;

import com.riwi.PRUEBA_DESEMPE_O_SPRING_BOOT.api.dto.request.ClassRequest;
import com.riwi.PRUEBA_DESEMPE_O_SPRING_BOOT.api.dto.response.ClassResponse;

public interface IClassService extends CrudService<ClassRequest, ClassResponse, Long> {

    public String findByNameOrDescription(String name);

}
