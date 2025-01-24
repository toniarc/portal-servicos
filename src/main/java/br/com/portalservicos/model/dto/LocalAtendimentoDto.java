package br.com.portalservicos.model.dto;

import br.com.portalservicos.model.valueobject.EnderecoVO;
import lombok.Data;

@Data
public class LocalAtendimentoDto {
    private Long id;
    private String nome;
    private OrgaoDto orgao;
    private EnderecoVO endereco;
}