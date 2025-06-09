package com.lopez.application.service.impl;

import com.lopez.application.mapper.CitaMapper;
import com.lopez.application.service.CitaService;
import com.lopez.config.KafkaProducerComponent;
import com.lopez.domain.event.CitaEstadoEvent;
import com.lopez.domain.model.EstadoCitas;
import com.lopez.domain.model.Cita;
import com.lopez.domain.model.EstadoCitas;
import com.lopez.domain.repository.CitaRepository;
import com.lopez.web.dto.CitaRequestDto;
import com.lopez.web.dto.CitaResponseDto;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
@Slf4j
public class CitaServiceImpl implements CitaService {

    private final CitaRepository citaRepository;
    private final CitaMapper citaMapper;
    private final KafkaProducerComponent kafkaProducer;

    @Override
    public CitaResponseDto crearCita(CitaRequestDto request) {
        Cita cita = citaMapper.toEntity(request);
        Cita savedCita = citaRepository.save(cita);
        log.info("Cita creada con ID: {}", savedCita.getId());
        return citaMapper.toDto(savedCita);
    }

    @Override
    public CitaResponseDto actualizarEstadoCita(Long id, String nuevoEstado) {
        Cita cita = citaRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Cita no encontrada con ID: " + id));

        // Validate if the new state is a valid enum value
        EstadoCitas estadoEnum;
        try {
            estadoEnum = EstadoCitas.valueOf(nuevoEstado.toUpperCase());
        } catch (IllegalArgumentException e) {
            throw new IllegalArgumentException("Estado de cita inválido: " + nuevoEstado);
        }

        cita.setEstado(estadoEnum);
        Cita updatedCita = citaRepository.save(cita);
        log.info("Estado de cita con ID {} actualizado a: {}", updatedCita.getId(), updatedCita.getEstado());

        CitaEstadoEvent evento = CitaEstadoEvent.builder()
                .citaId(updatedCita.getId())
                .paciente(updatedCita.getPaciente()) // Include patient name for context in the event
                .nuevoEstado(updatedCita.getEstado().name())
                .build();

        kafkaProducer.enviarEventoCambioEstadoCita(evento);

        return citaMapper.toDto(updatedCita);
    }

    @Override
    public CitaResponseDto obtenerCitaPorId(Long id) {
        Cita cita = citaRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Cita no encontrada con ID: " + id));
        return citaMapper.toDto(cita);
    }

    @Override
    public List<CitaResponseDto> listarCitas() {
        return citaRepository.findAll().stream()
                .map(citaMapper::toDto)
                .collect(Collectors.toList());
    }

    @Override
    public void eliminarCita(Long id) {
        if (!citaRepository.existsById(id)) {
            throw new RuntimeException("Cita no encontrada con ID: " + id);
        }
        citaRepository.deleteById(id);
        log.info("Cita con ID {} eliminada.", id);
    }
}