package br.com.portalservicos.persistence.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name = "servico_digital", schema = "portalservicos")
@Getter
@Setter
public class ServicoDigitalEntity {

    @Id
    @Column(name = "id")
    private Long id;

    @MapsId
    @OneToOne
    @JoinColumn(name = "id")
    private ServicoEntity servico;

    @Column(length = 200)
    private String link;
}