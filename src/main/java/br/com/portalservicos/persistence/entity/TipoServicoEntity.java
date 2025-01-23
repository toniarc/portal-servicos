package br.com.portalservicos.persistence.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name = "tipo_servico", schema = "portalservicos")
@Getter
@Setter
public class TipoServicoEntity {

    @Id
    @SequenceGenerator(name = "tipo_servico_id_seq", sequenceName = "tipo_servico_id_seq", schema = "portalservicos", allocationSize = 1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "tipo_servico_id_seq")
    private Long id;

    private String nome;

    private String descricao;

    private String icone;

}
