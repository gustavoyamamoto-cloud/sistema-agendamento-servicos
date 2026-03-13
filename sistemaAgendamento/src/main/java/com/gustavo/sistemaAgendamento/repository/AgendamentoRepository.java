package com.gustavo.sistemaAgendamento.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.gustavo.sistemaAgendamento.entity.Agendamento;

public interface AgendamentoRepository extends JpaRepository<Agendamento, Integer>{
    
    
}
