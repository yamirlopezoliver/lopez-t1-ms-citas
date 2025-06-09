package com.lopez.application.service;

import com.lopez.web.dto.CitaRequestDto;
import com.lopez.web.dto.CitaResponseDto;

import java.util.List;

public interface CitaService {
    CitaResponseDto crearCita(CitaRequestDto request);
    CitaResponseDto actualizarEstadoCita(Long id, String nuevoEstado);
    CitaResponseDto obtenerCitaPorId(Long id); // Added method to get a single appointment
    List<CitaResponseDto> listarCitas();
    void eliminarCita(Long id); // Added method to delete an appointment
}