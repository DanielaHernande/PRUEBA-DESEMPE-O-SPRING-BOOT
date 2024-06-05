package com.riwi.PRUEBA_DESEMPE_O_SPRING_BOOT.infraestructure.abstract_service;

import org.springframework.data.domain.Page;

public interface CrudService <RQ, RS, ID>{
    
    public RS create(RQ request);

    public RS get(ID id);

    public RS update(RQ request, ID id);

    public void delete(ID id);

    public Page<RS> getAll(int page, int size);
}
