package com.riwi.PRUEBA_DESEMPE_O_SPRING_BOOT.infraestructure.service;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import com.riwi.PRUEBA_DESEMPE_O_SPRING_BOOT.api.dto.request.LessonRequest;
import com.riwi.PRUEBA_DESEMPE_O_SPRING_BOOT.api.dto.response.ClassBasicResponse;
import com.riwi.PRUEBA_DESEMPE_O_SPRING_BOOT.api.dto.response.LessonResponse;
import com.riwi.PRUEBA_DESEMPE_O_SPRING_BOOT.api.dto.response.MultimediaBasicResponse;
import com.riwi.PRUEBA_DESEMPE_O_SPRING_BOOT.domain.entities.ClassEntity;
import com.riwi.PRUEBA_DESEMPE_O_SPRING_BOOT.domain.entities.Lesson;
import com.riwi.PRUEBA_DESEMPE_O_SPRING_BOOT.domain.repositories.ClassRepository;
import com.riwi.PRUEBA_DESEMPE_O_SPRING_BOOT.domain.repositories.LessonRepository;
import com.riwi.PRUEBA_DESEMPE_O_SPRING_BOOT.infraestructure.abstract_service.ILessonService;
import com.riwi.PRUEBA_DESEMPE_O_SPRING_BOOT.utils.exceptions.BadRequestException;

import lombok.AllArgsConstructor;

@Service
@AllArgsConstructor
public class LessonService implements ILessonService{
    
    // Inyeccion
    @Autowired
    private final LessonRepository lessonRepository;

    // Class
    @Autowired
    private final ClassRepository classRepository;
    
    // Crear
    @Override
    public LessonResponse create(LessonRequest request) {

        ClassEntity classEntity = this.classRepository.findById(request.getClassId())
                    .orElseThrow(() -> new BadRequestException("No hay clses con ese id"));

        Lesson lesson = this.requestToEntity(request);

        lesson.setClassId(classEntity);

        return this.entityToResponse(this.lessonRepository.save(lesson));

    }

    // Obtener solo uno
    @Override
    public LessonResponse get(Long id) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'get'");
    }

    // Actualizar
    @Override
    public LessonResponse update(LessonRequest request, Long id) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'update'");
    }

    // Eliminar
    @Override
    public void delete(Long id) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'delete'");
    }

    // Obtener todo
    @Override
    public Page<LessonResponse> getAll(int page, int size) {

        if (page < 0) page = 0;

        PageRequest pagination = PageRequest.of(page - 1, size);

        return this.lessonRepository.findAll(pagination)
                .map(this::entityToResponse);
    }

    // Metodos privados 
    private LessonResponse entityToResponse(Lesson entity) {

        ClassBasicResponse classEntity = new ClassBasicResponse();

        // Verificar si la multimedia no es nula y copiar propiedades si existe
        if (entity.getClassId() != null) {
            BeanUtils.copyProperties(entity.getClassId(), classEntity);
        }

        return LessonResponse.builder()
                .id(entity.getId())
                .title(entity.getTitle())
                .content(entity.getContent())
                .classId(classEntity)
                .createAt(entity.getCreateAt())
                .build();
    }

    private Lesson requestToEntity(LessonRequest request) {

        return Lesson.builder()
                    .title(request.getTitle())
                    .content(request.getContent())
                    .active(request.isActive())
                    .build();
    }

    private Lesson find(Long id) {

        return this.lessonRepository.findById(id)
                .orElseThrow(() -> new BadRequestException("No hay una leccion con el id suministrado"));
    }
    
}
