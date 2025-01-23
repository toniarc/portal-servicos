package br.com.portalservicos.persistence.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name = "servico", schema = "portalservicos")
@Getter
@Setter
public class ServicoEntity {

    @Id
    @SequenceGenerator(name = "servico_id_seq", sequenceName = "portalservicos.servico_id_seq", allocationSize = 1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "servico_id_seq")
    private Long id;

    @ManyToOne
    @JoinColumn(name = "carta_servico_id")
    private CartaServicoEntity cartaServico;

    @ManyToOne
    @JoinColumn(name = "categoria_id")
    private CategoriaEntity categoria;

    @ManyToOne
    @JoinColumn(name = "tipo_servico_id")
    private TipoServicoEntity tipo;

    @ManyToOne
    @JoinColumn(name = "orgao_id")
    private OrgaoEntity orgao;

    @Column(length = 100)
    private String nome;

    @Column(columnDefinition = "TEXT")
    private String oQueEh;

    @Column(columnDefinition = "TEXT")
    private String comoFazer;

    @Column(columnDefinition = "TEXT")
    private String quantoCusta;

    @Column(columnDefinition = "TEXT")
    private String quantoTempo;

    @Column(columnDefinition = "TEXT")
    private String outrosDetalhes;

    @Column(columnDefinition = "TEXT")
    private String contatos;

    private String icone;

    @OneToOne(mappedBy = "servico")
    private ServicoDigitalEntity servicoDigital;

    @OneToOne(mappedBy = "servico")
    private ServicoPresencialEntity servicoPresencial;
}
