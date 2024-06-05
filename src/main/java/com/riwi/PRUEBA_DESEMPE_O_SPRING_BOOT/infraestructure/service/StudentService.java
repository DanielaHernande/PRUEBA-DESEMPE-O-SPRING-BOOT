package com.riwi.PRUEBA_DESEMPE_O_SPRING_BOOT.infraestructure.service;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import com.riwi.PRUEBA_DESEMPE_O_SPRING_BOOT.api.dto.request.StudentRequest;
import com.riwi.PRUEBA_DESEMPE_O_SPRING_BOOT.api.dto.response.ClassBasicResponse;
import com.riwi.PRUEBA_DESEMPE_O_SPRING_BOOT.api.dto.response.StudentResponse;
import com.riwi.PRUEBA_DESEMPE_O_SPRING_BOOT.domain.entities.ClassEntity;
import com.riwi.PRUEBA_DESEMPE_O_SPRING_BOOT.domain.entities.Student;
import com.riwi.PRUEBA_DESEMPE_O_SPRING_BOOT.domain.repositories.ClassRepository;
import com.riwi.PRUEBA_DESEMPE_O_SPRING_BOOT.domain.repositories.StudentRepository;
import com.riwi.PRUEBA_DESEMPE_O_SPRING_BOOT.infraestructure.abstract_service.IStudentService;
import com.riwi.PRUEBA_DESEMPE_O_SPRING_BOOT.utils.exceptions.BadRequestException;

import lombok.AllArgsConstructor;

@Service
@AllArgsConstructor
public class StudentService implements IStudentService{
    
    // INyeccion de dependencias
    @Autowired
    private final StudentRepository studentRepository;

    @Autowired
    private final ClassRepository classRepository;

    // Crear
    @Override
    public StudentResponse create(StudentRequest request) {

        // Buscar el curso por ID, lanzar excepción si no se encuentra
        ClassEntity classEntity = this.classRepository.findById(request.getClassId())
                    .orElseThrow(() -> new BadRequestException("No hay clses con ese id"));

        // Convertir la solicitud a entidad student
        Student student = this.requestToEntity(request);

        // Asignar la calse a student
        student.setClassId(classEntity);

        // Guardar la lección en el repositorio y devolver la respuesta
        return this.entityToResponse(this.studentRepository.save(student));
    }

    // Obtener solo uno
    @Override
    public StudentResponse get(Long id) {

        return this.entityToResponse(find(id));
    }

    // Actualizar
    @Override
    public StudentResponse update(StudentRequest request, Long id) {

        Student student = this.find(id);

        ClassEntity classEntity = this.classRepository.findById(id)
                .orElseThrow(() -> new BadRequestException("No hay una clase con ese id suministrado"));

        student.setName(request.getName());
        student.setEmail(request.getEmail());
        student.setActive(request.isActive());
        student.setClassId(classEntity);

        return this.entityToResponse(this.studentRepository.save(student));
    }

    // Eliminar
    @Override
    public void delete(Long id) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'delete'");
    }

    // Obtener todo
    @Override
    public Page<StudentResponse> getAll(int page, int size) {

        if (page < 0) page = 0;

        PageRequest pagination = PageRequest.of(page - 1, size);

        return this.studentRepository.findAll(pagination)
                .map(this::entityToResponse);
    }

    // Metodos privados 
    private StudentResponse entityToResponse(Student entity) {

        ClassBasicResponse classEntity = new ClassBasicResponse();

        // Verificar si la lección no es nula y copiar propiedades si existe
        if (entity.getClassId() != null) {
            BeanUtils.copyProperties(entity.getClassId(), classEntity);
        }

        return StudentResponse.builder()
                .id(entity.getId())
                .name(entity.getName())
                .email(entity.getEmail())
                .createAt(entity.getCreateAt())
                .classId(classEntity)
                .active(entity.isActive())
                .build();
    }

    private Student requestToEntity(StudentRequest request) {

        return Student.builder()
                .name(request.getName())
                .email(request.getEmail())
                .active(request.isActive())
                .build();
    }

    private Student find(Long id) {

        return this.studentRepository.findById(id)
                .orElseThrow(() -> new BadRequestException("No hay clases con el id suministrado"));
    }
    
}
