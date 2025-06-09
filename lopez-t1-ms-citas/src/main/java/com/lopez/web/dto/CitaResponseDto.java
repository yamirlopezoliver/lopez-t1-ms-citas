package com.lopez.web.dto;

import lombok.*;
import java.time.LocalDate;
import java.time.LocalTime;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class CitaResponseDto {
    private Long id; // Include the ID for the response
    private LocalDate fecha;
    private String paciente;
    private Long doctorId;
    private String estado; // The current state of the appointment
    private String notas;
    private LocalTime hora;
}