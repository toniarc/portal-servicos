package br.com.portalservicos.persistence.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name = "carta_servico", schema = "portalservicos")
@Getter
@Setter
public class CartaServicoEntity {

    @Id
    @SequenceGenerator(name = "carta_servico_id_seq", sequenceName = "carta_servico_id_seq", schema = "portalservicos", allocationSize = 1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "carta_servico_id_seq")
    private Long id;

    @Column(length = 200)
    private String apresentacao;

    @ManyToOne
    @JoinColumn(name = "orgao_id")
    private OrgaoEntity orgao;

    @Column(length = 200)
    private String instituicao;

    @Column(length = 200)
    private String missao;

    @Column(length = 200)
    private String valores;

    @Column(length = 200)
    private String visao;
}
