package br.com.portalservicos.model.dto;

import br.com.portalservicos.persistence.entity.OrgaoEntity;
import lombok.Data;

@Data
public class CartaServicoDto {
    private Long id;
    private String apresentacao;
    private OrgaoEntity orgao;
    private String instituicao;
    private String missao;
    private String valores;
    private String visao;
}
