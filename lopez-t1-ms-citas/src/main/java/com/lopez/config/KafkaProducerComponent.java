package com.lopez.config;

import com.lopez.domain.event.CitaEstadoEvent; // Corrected import to CitaEstadoEvent
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
@Slf4j
public class KafkaProducerComponent {


    private final KafkaTemplate<String, CitaEstadoEvent> kafkaTemplate;
    public void enviarEventoCambioEstadoCita(CitaEstadoEvent evento) {

        kafkaTemplate.send("lopez-topic", evento);
        log.info("Evento de cambio de estado de cita enviado a Kafka: {}", evento);
    }
}