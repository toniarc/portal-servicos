package br.com.portalservicos.persistence.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Entity
@Table(name = "servico_presencial", schema = "portalservicos")
@Getter
@Setter
public class ServicoPresencialEntity {

    @Id
    @Column(name = "id")
    private Long id;

    @MapsId
    @OneToOne
    @JoinColumn(name = "id")
    private ServicoEntity servico;

    @OneToMany(mappedBy = "servico")
    private List<HorarioAtendimentoEntity> horariosAtendimento;
}