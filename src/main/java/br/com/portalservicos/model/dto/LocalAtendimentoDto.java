package br.com.portalservicos.model.dto;

import lombok.Data;

@Data
public class LocalAtendimentoDto {
    private Long id;
    private OrgaoDto orgao;
    private String logradouro;
    private String bairro;
    private String cep;
    private MunicipioDto municipio;
    private String complemento;
    private String numero;
    private String nome;
}