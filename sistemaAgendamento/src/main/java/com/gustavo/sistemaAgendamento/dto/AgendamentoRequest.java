package com.gustavo.sistemaAgendamento.dto;

import java.time.LocalDate;
import java.time.LocalTime;

import com.gustavo.sistemaAgendamento.enuns.Status;

public class AgendamentoRequest {
    
    private LocalDate data;
    private LocalTime hora;
    private Status status;
    private Integer clienteId;
    private Integer profissionalId;

    /* Construtor */
    public AgendamentoRequest() {
    }

    /* Getters e Setters */
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
