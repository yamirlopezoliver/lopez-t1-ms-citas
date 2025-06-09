package com.lopez.web.controller;

import com.lopez.application.service.CitaService;
import com.lopez.web.dto.CitaRequestDto;
import com.lopez.web.dto.CitaResponseDto;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/citas")
@RequiredArgsConstructor
public class CitaController {

    private final CitaService citaService;

    @PostMapping
    public ResponseEntity<CitaResponseDto> crear(@RequestBody CitaRequestDto request) {
        // We'll return CREATED (201) for resource creation, which is good practice.
        return new ResponseEntity<>(citaService.crearCita(request), HttpStatus.CREATED);
    }

    @PutMapping("/{id}/estado")
    public ResponseEntity<CitaResponseDto> actualizarEstado(
            @PathVariable Long id,
            @RequestParam String nuevoEstado
    ) {
        return ResponseEntity.ok(citaService.actualizarEstadoCita(id, nuevoEstado));
    }

    @GetMapping
    public ResponseEntity<List<CitaResponseDto>> listar() {
        return ResponseEntity.ok(citaService.listarCitas());

    }
}