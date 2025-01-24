package br.com.portalservicos.persistence.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;


@Entity
@Table(name = "categoria", schema = "portalservicos")
@Getter
@Setter
public class CategoriaEntity {

    @Id
    @SequenceGenerator(name = "categoria_id_seq", sequenceName = "categoria_id_seq", schema = "portalservicos", allocationSize = 1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "categoria_id_seq")
    private Long id;

    @Column(length = 100)
    private String nome;

    @Column(length = 200)
    private String descricao;

    private String icone;
}
