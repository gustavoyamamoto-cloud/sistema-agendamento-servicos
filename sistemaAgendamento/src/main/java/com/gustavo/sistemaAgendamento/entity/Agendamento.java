package com.gustavo.sistemaAgendamento.entity;

import java.time.LocalDate;
import java.time.LocalTime;

import ch.qos.logback.core.status.Status;
import jakarta.persistence.Entity;

@Entity
public class Agendamento {
    
    private Integer id;
    private LocalDate data;
    private LocalTime hora;
    private Status status;
    private Cliente cliente;
    private Profissional profissional;
    
    /* Contrutor */
    public Agendamento() {
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

    public Cliente getCliente() {
        return cliente;
    }

    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }

    public Profissional getProfissional() {
        return profissional;
    }

    public void setProfissional(Profissional profissional) {
        this.profissional = profissional;
    }

    

    

}
