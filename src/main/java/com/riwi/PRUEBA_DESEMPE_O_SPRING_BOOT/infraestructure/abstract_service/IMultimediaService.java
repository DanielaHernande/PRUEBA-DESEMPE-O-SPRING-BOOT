package com.riwi.PRUEBA_DESEMPE_O_SPRING_BOOT.infraestructure.abstract_service;

import com.riwi.PRUEBA_DESEMPE_O_SPRING_BOOT.api.dto.request.MultimediaRequest;
import com.riwi.PRUEBA_DESEMPE_O_SPRING_BOOT.api.dto.response.MultimediaResponse;

public interface IMultimediaService extends CrudService<MultimediaRequest, MultimediaResponse, Long>{
    
}
