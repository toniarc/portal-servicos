package br.com.portalservicos.model.dto;

import lombok.Data;

import java.util.List;

@Data
public class ServicoPresencialDto {

    private Long id;

    private List<HorarioAtendimentoDto> horariosAtendimento;
}