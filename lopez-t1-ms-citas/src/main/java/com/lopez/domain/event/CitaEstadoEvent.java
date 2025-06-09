package com.lopez.domain.event; // Assuming a similar package structure

import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
@Builder
public class CitaEstadoEvent {
    private Long id;
    private Long citaId;
    private String paciente;
    private String nuevoEstado;
}