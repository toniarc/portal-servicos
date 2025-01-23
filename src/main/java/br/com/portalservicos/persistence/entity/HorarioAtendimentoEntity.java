package br.com.portalservicos.persistence.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.sql.Time;

@Entity
@Table(name = "horario_atendimento", schema = "portalservicos")
@Getter
@Setter
public class HorarioAtendimentoEntity {

    @Id
    @ManyToOne
    @JoinColumn(name = "servico_id")
    private ServicoPresencialEntity servico;

    @Id
    @ManyToOne
    @JoinColumn(name = "local_atendimento_id")
    private LocalAtendimentoEntity localAtendimento;

    @Column(length = 3)
    private String diaSemana;

    private Time horaInicio;

    private Time horaFim;
}
