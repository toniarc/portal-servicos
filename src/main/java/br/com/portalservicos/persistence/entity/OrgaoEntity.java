package br.com.portalservicos.persistence.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name = "orgao", schema = "portalservicos")
@Getter
@Setter
public class OrgaoEntity {

    @Id
    @SequenceGenerator(name = "orgao_id_seq", sequenceName = "orgao_id_seq", schema = "portalservicos", allocationSize = 1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "orgao_id_seq")
    private Long id;

    @Column(length = 100)
    private String nome;

    @Column(length = 20)
    private String sigla;
}
