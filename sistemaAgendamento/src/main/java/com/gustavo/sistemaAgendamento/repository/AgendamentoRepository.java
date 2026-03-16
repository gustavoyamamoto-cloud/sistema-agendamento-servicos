package com.gustavo.sistemaAgendamento.repository;

import java.time.LocalDate;
import java.time.LocalTime;

import org.springframework.data.jpa.repository.JpaRepository;

import com.gustavo.sistemaAgendamento.entity.Agendamento;

public interface AgendamentoRepository extends JpaRepository<Agendamento, Integer>{
    
    boolean existsByDataAndHoraAndProfissionalId(LocalDate data, LocalTime hora, Integer profissionalId);
}
