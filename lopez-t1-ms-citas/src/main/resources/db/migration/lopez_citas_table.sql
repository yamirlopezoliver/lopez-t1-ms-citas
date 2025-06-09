CREATE TABLE citas (
                       id BIGINT AUTO_INCREMENT PRIMARY KEY,
                       fecha DATE NOT NULL,
                       paciente VARCHAR(255) NOT NULL,
                       doctor_id BIGINT NOT NULL,
                       estado ENUM('PENDIENTE', 'CONFIRMADA', 'CANCELADA') NOT NULL,
                       notas TEXT,
                       hora TIME NOT NULL,
                       CONSTRAINT fk_citas_doctor FOREIGN KEY (doctor_id) REFERENCES doctores(id)
);