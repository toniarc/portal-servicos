package br.com.portalservicos.model.dto;

import br.com.portalservicos.model.valueobject.EnderecoVO;
import lombok.Data;

import java.util.List;

@Data
public class LocalAtendimentoDto {

    private Long id;
    private String nome;
    private OrgaoDto orgao;
    private EnderecoVO endereco;

    private List<HorarioAtendimentoDto> horarios;
}