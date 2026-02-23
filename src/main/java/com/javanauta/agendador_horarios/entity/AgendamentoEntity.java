package com.javanauta.agendador_horarios.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDateTime;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table (name = "agendamento")

public class AgendamentoEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String produto;
    private String profissional;
    private LocalDateTime dataHoraAgendamento;
    private String cliente;
    private LocalDateTime dataInsercao = LocalDateTime.now();
    // para quando for criado o agendamento pegar a data do dia do agendamento
}
