package br.com.portalservicos.persistence.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;


@Entity
@Table(name = "local_atendimento", schema = "portalservicos")
@Getter
@Setter
public class LocalAtendimentoEntity {

    @Id
    @SequenceGenerator(name = "local_atendimento_id_seq", sequenceName = "local_atendimento_id_seq", schema = "portalservicos", allocationSize = 1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "local_atendimento_id_seq")
    private Long id;

    @ManyToOne
    @JoinColumn(name = "servico_id")
    private ServicoEntity servico;

    @ManyToOne
    @JoinColumn(name = "orgao_id")
    private OrgaoEntity orgao;

    private String nome;

    @Column(length = 200)
    private String logradouro;

    @Column(length = 200)
    private String bairro;

    @Column(length = 200)
    private String cep;

    @ManyToOne
    @JoinColumn(name = "municipio_cod")
    private MunicipioEntity municipio;

    @Column(length = 200)
    private String complemento;

    @Column(length = 200)
    private String numero;
}
