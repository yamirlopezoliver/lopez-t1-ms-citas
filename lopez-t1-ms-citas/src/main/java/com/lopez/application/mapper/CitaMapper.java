package com.lopez.application.mapper;

import com.lopez.domain.model.EstadoCitas; // Corrected import for EstadoCita
import com.lopez.domain.model.Cita; // Corrected import for Cita entity
import com.lopez.domain.model.EstadoCitas;
import com.lopez.web.dto.CitaRequestDto; // Corrected import for CitaRequestDto
import com.lopez.web.dto.CitaResponseDto; // Corrected import for CitaResponseDto
import org.springframework.stereotype.Component;

@Component
public class CitaMapper {

    public Cita toEntity(CitaRequestDto dto) {
        return Cita.builder()
                .fecha(dto.getFecha())
                .paciente(dto.getPaciente())
                .doctorId(dto.getDoctorId())

                .estado(EstadoCitas.valueOf(dto.getEstado()))
                .notas(dto.getNotas())
                .hora(dto.getHora())
                .build();
    }

    public CitaResponseDto toDto(Cita entity) {
        return CitaResponseDto.builder()
                .id(entity.getId())
                .fecha(entity.getFecha())
                .paciente(entity.getPaciente())
                .doctorId(entity.getDoctorId())
                .estado(entity.getEstado().name())
                .notas(entity.getNotas())
                .hora(entity.getHora())
                .build();
    }
}