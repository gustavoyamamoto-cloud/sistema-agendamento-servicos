package com.gustavo.sistemaAgendamento.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.gustavo.sistemaAgendamento.entity.Profissional;

public interface ProfissionalRepository extends JpaRepository<Profissional, Integer>{
    
    List<Profissional> findByNome(String nome);
}
