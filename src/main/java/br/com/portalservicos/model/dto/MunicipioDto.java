package br.com.portalservicos.model.dto;

import lombok.Data;

@Data
public class MunicipioDto {
    private Long codIbge;
    private EstadoDto estado;
    private String nome;
}