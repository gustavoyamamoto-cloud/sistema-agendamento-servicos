package com.gustavo.sistemaAgendamento.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.gustavo.sistemaAgendamento.entity.Cliente;

public interface ClienteRepository extends JpaRepository<Cliente, Integer>{
     
    List<Cliente> findByNome(String nome);
}
