package com.riwi.PRUEBA_DESEMPE_O_SPRING_BOOT.infraestructure.service;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import com.riwi.PRUEBA_DESEMPE_O_SPRING_BOOT.api.dto.request.ClassRequest;
import com.riwi.PRUEBA_DESEMPE_O_SPRING_BOOT.api.dto.response.ClassResponse;
import com.riwi.PRUEBA_DESEMPE_O_SPRING_BOOT.domain.entities.ClassEntity;
import com.riwi.PRUEBA_DESEMPE_O_SPRING_BOOT.domain.entities.Lesson;
import com.riwi.PRUEBA_DESEMPE_O_SPRING_BOOT.domain.repositories.ClassRepository;
import com.riwi.PRUEBA_DESEMPE_O_SPRING_BOOT.domain.repositories.LessonRepository;
import com.riwi.PRUEBA_DESEMPE_O_SPRING_BOOT.infraestructure.abstract_service.IClassService;
import com.riwi.PRUEBA_DESEMPE_O_SPRING_BOOT.utils.exceptions.BadRequestException;

import lombok.AllArgsConstructor;

@Service
@AllArgsConstructor
public class ClassService implements IClassService{
    
    // Inyeccion de dependencia
    @Autowired
    private final ClassRepository classRepository;

    @Autowired
    private final LessonRepository lessonRepository;

    // Crear
    @Override
    public ClassResponse create(ClassRequest request) {

        ClassEntity classEntity = this.requestToEntity(request);

        return this.entityToResponse(this.classRepository.save(classEntity));
    }

    // Obtener solo uno
    @Override
    public ClassResponse get(Long id) {

        return this.entityToResponse(find(id));
    }

    // ACtualizar
    @Override
    public ClassResponse update(ClassRequest request, Long id) {

        ClassEntity classEntity = this.find(id);

        classEntity.setName(request.getName());
        classEntity.setDescription(request.getDescription());
        classEntity.setActive(request.isActive());

        return this.entityToResponse(this.classRepository.save(classEntity));
    }

    // ELiminar
    @Override
    public void delete(Long id) {

        this.classRepository.delete(find(id));
    }

    // Obtener todo
    @Override
    public Page<ClassResponse> getAll(int page, int size) {

        if (page < 0) page = 0;

        PageRequest paginable = PageRequest.of(page - 1, size);

        return this.classRepository.findAll(paginable)
                    .map(this::entityToResponse);
    }

    @Override
    public String findByNameOrDescription(String name) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'findByNameOrDescription'");
    }

    // Metodos privados 
    private ClassResponse entityToResponse(ClassEntity entity) {

        Lesson lesson = new Lesson();

        // Verificar si la lección no es nula y copiar propiedades si existe
        if (entity.getLessons() != null) {
            BeanUtils.copyProperties(entity.getLessons(), lesson);
        }

        return ClassResponse.builder()
                .id(entity.getId())
                .name(entity.getName())
                .description(entity.getDescription())
                .createdAt(entity.getCreatedAt())
                .active(entity.isActive())
                .build();
    }

    private ClassEntity requestToEntity(ClassRequest request) {

        return ClassEntity.builder()
                .name(request.getName())
                .description(request.getDescription())
                .active(request.isActive())
                .build();
    }

    private ClassEntity find(Long id) {

        return this.classRepository.findById(id)
                .orElseThrow(() -> new BadRequestException("No hay clases con el id suministrado"));
    }
}
