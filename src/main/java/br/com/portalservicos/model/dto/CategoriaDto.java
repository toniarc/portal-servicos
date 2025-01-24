package br.com.portalservicos.model.dto;

import lombok.Data;

@Data
public class CategoriaDto {
    private Long id;
    private String nome;
    private String descricao;
    private String icone;
}