package com.lopez.domain.model;

import jakarta.persistence.*;
import lombok.*;
import java.time.LocalDate;
import java.time.LocalTime;

@Entity
@Table(name = "citas")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Cita {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private LocalDate fecha;

    private String paciente;

    private Long doctorId;

    @Enumerated(EnumType.STRING)
    private EstadoCitas estado; // Changed to EstadoCita for clarity

    private String notas;

    private LocalTime hora;
}