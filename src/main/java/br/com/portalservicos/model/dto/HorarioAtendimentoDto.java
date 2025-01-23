package br.com.portalservicos.model.dto;

import lombok.Data;

import java.sql.Time;

@Data
public class HorarioAtendimentoDto {
    private LocalAtendimentoDto localAtendimento;
    private String diaSemana;
    private Time horaInicio;
    private Time horaFim;
}