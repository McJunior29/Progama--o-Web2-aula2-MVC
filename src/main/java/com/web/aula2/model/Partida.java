package com.web.aula2.model;

import java.time.Duration;
import java.time.LocalTime;

import com.web.aula2.model.DTO.PartidaDTO;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Getter @Setter @NoArgsConstructor
@Builder @AllArgsConstructor
@ToString
public class Partida {
    private static int count;
    private int id;
    private LocalTime horaInicio;
    private LocalTime horaFim;
    private String local;
    private String duracao;

    public Partida(PartidaDTO dados) {
        count++;
        this.id = count;
        this.horaInicio = dados.horaInicio();
        this.horaFim = dados.horaFim();
        this.local = dados.local();
        this.duracao = this.getDuracao();

    }

    public String getDuracao() {
        Duration duration = Duration.between(horaInicio, horaFim);     
        long hours = duration.toHours();
        long minutes = duration.minusHours(hours).toMinutes();

        return hours +"H "+ minutes + "M";
        
    }
    
}
