package br.com.portalservicos.persistence.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name = "estado", schema = "portalservicos")
@Getter
@Setter
public class EstadoEntity {

    @Id
    @Column(length = 10)
    private String codIbge;

    @Column(length = 100)
    private String nome;

    @Column(length = 2)
    private String uf;
}
