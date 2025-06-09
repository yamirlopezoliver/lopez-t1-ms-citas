package com.lopez.domain.repository; // Assuming a similar package structure

import com.lopez.domain.model.Cita;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CitaRepository extends JpaRepository<Cita, Long> {

}