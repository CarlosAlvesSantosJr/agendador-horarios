package com.javanauta.agendador_horarios.service;

import com.javanauta.agendador_horarios.entity.Agendamento;
import com.javanauta.agendador_horarios.repository.AgendamentoRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.Objects;

@Service
@RequiredArgsConstructor // injeção da dependencia
public class AgendamentoService {

    private final AgendamentoRepository agendamentoRepository;

    public Agendamento SalvarAgendamento (Agendamento agendamento){

        LocalDateTime horaAgendamento = agendamento.getDataHoraAgendamento();
                // vai buscar pela hora do agendamento e comparar la no repository se essa hora ja esta agendada.
        LocalDateTime horaFim = agendamento.getDataHoraAgendamento().plusHours(1);
                // dentro dessa 1 hora se não tiver ninguem agendado, o sistema agenda.
        Agendamento agendados = agendamentoRepository.findByServicoAndDataHoraAgendamentoBetween
                (agendamento.getServico(), horaAgendamento , horaFim);
                // nesse periodo não poderá haver agendamento

        if(Objects.nonNull(agendados))
        {throw new RuntimeException("Horário já esta preenchido");
                // se agendados não esta nulo.
        }
        return agendamentoRepository.save(agendamento);
    }

}
