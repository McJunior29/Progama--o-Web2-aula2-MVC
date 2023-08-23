package com.web.aula2.model.DTO;

import java.time.LocalTime;

public record PartidaDTO(
    LocalTime horaInicio,
    LocalTime horaFim,
    String local
) {
    
}
