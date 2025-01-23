package br.com.portalservicos.model.dto;

import br.com.portalservicos.persistence.entity.ServicoDigitalEntity;
import lombok.Data;

@Data
public class ServicoDto {
    private Long id;
    private CartaServicoDto cartaServico;
    private CategoriaDto categoria;
    private TipoServicoDto tipoServico;
    private OrgaoDto orgao;
    private String nome;
    private String oQueEh;
    private String comoFazer;
    private String quantoCusta;
    private String quantoTempo;
    private String outrosDetalhes;
    private String contatos;
    private String icone;
    private ServicoDigitalDto servicoDigital;
    private ServicoPresencialDto servicoPresencial;
}