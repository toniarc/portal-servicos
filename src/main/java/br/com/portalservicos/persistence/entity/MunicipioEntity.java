package br.com.portalservicos.persistence.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name = "municipio", schema = "portalservicos")
@Getter
@Setter
public class MunicipioEntity {

    @Id
    @Column(length = 10)
    private String codIbge;

    @ManyToOne
    @JoinColumn(name = "estado_cod_ibge")
    private EstadoEntity estado;

    @Column(length = 100)
    private String nome;
}
