package br.com.portalservicos.model.dto;

import lombok.Data;

@Data
public class TipoServicoDto {
    private Long id;
    private String nome;
    private String icone;
}