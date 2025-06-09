package com.lopez.application.client;

import com.lopez.application.dto.DoctorDto;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@FeignClient(name = "doctors-service", url = "${application.client.doctors-service.url}")
public interface DoctorClient {

    @GetMapping("/api/doctores/{id}")
    DoctorDto obtenerDoctorPorId(@PathVariable Long id);
}