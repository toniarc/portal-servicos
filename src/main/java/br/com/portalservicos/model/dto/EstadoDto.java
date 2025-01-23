package br.com.portalservicos.model.dto;

import lombok.Data;

@Data
public class EstadoDto {
    private Long codIbge;
    private String nome;
    private String uf;
}