package com.riwi.PRUEBA_DESEMPE_O_SPRING_BOOT.domain.entities;

import java.time.LocalDateTime;
import java.util.List;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Entity(name = "class")
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class ClassEntity {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String name;

    @Column(columnDefinition = "TEXT", nullable = false)
    private String description;

    @Column(nullable = false)
    @Builder.Default
    private LocalDateTime createdAt = LocalDateTime.now();

    @Column(nullable = false)
    private boolean active;

    // Lesson
    @OneToMany(
        fetch = FetchType.EAGER,
        mappedBy = "classId",
        cascade = CascadeType.ALL,
        orphanRemoval = false
    )
    @ToString.Exclude
    @EqualsAndHashCode.Exclude
    private List<Lesson> lessons;

    // Student
    @OneToMany(
        fetch = FetchType.EAGER,
        mappedBy = "classId",
        cascade = CascadeType.ALL,
        orphanRemoval = false
    )
    @ToString.Exclude
    @EqualsAndHashCode.Exclude
    private List<Student> students;
}
