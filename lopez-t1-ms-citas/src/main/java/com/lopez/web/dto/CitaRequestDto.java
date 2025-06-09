package com.lopez.web.dto;

import lombok.*;
import java.time.LocalDate;
import java.time.LocalTime;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class CitaRequestDto {
    private LocalDate fecha;
    private String paciente;
    private Long doctorId;
    private String estado; // This will likely be "PENDIENTE" initially, or for updates
    private String notas;
    private LocalTime hora;
}