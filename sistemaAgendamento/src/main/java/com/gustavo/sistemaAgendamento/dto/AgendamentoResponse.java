package com.gustavo.sistemaAgendamento.dto;

import java.time.LocalDate;
import java.time.LocalTime;

import com.gustavo.sistemaAgendamento.enuns.Status;

public class AgendamentoResponse {
    
    private Integer id;
    private LocalDate data;
    private LocalTime hora;
    private Status status;
    private Integer clienteId;
    private Integer profissionalId;

    /* Construtor */
    public AgendamentoResponse(Integer id, LocalDate data, LocalTime hora, Status status, Integer clienteId,
            Integer profissionalId) {
        this.id = id;
        this.data = data;
        this.hora = hora;
        this.status = status;
        this.clienteId = clienteId;
        this.profissionalId = profissionalId;
    }

    /* Getters e Setters */
    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public LocalDate getData() {
        return data;
    }

    public void setData(LocalDate data) {
        this.data = data;
    }

    public LocalTime getHora() {
        return hora;
    }

    public void setHora(LocalTime hora) {
        this.hora = hora;
    }

    public Status getStatus() {
        return status;
    }

    public void setStatus(Status status) {
        this.status = status;
    }

    public Integer getClienteId() {
        return clienteId;
    }

    public void setClienteId(Integer clienteId) {
        this.clienteId = clienteId;
    }

    public Integer getProfissionalId() {
        return profissionalId;
    }

    public void setProfissionalId(Integer profissionalId) {
        this.profissionalId = profissionalId;
    }

    
    
}
