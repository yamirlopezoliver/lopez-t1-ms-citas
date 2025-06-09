package com.lopez.application.dto;

import com.lopez.domain.model.EstadoCitas;

public record DoctorDto(
    Long id,
    String nombre,
    String especialidad,
    String estado
) {}