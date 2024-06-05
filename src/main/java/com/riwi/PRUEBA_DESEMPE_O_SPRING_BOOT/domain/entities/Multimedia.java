package com.riwi.PRUEBA_DESEMPE_O_SPRING_BOOT.domain.entities;

import java.time.LocalDateTime;

import com.riwi.PRUEBA_DESEMPE_O_SPRING_BOOT.utils.enums.Contenido;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Multimedia {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    @Enumerated(EnumType.STRING)
    private Contenido type;

    @Column(columnDefinition = "TEXT", nullable = false)
    private String url;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "lesson_id", referencedColumnName = "id")
    private Lesson lessonId;

    @Column(nullable = false)
    @Builder.Default
    private LocalDateTime createdId = LocalDateTime.now();

    @Column(nullable = false)
    private boolean active;
}
