package com.gustavo.sistemaAgendamento.dto;

import jakarta.validation.constraints.NotBlank;

public class ProfissionalRequest {
    
    @NotBlank(message = "Nome não pode ser vaziu")
    private String nome;

    @NotBlank(message = "Especialidade não pode ser vaziu")
    private String especialidade;

    /* Construtor */
    public ProfissionalRequest() {
    }

    /* Getters e Setters */
    public String getNome() {
        return nome;
    }
    public void setNome(String nome) {
        this.nome = nome;
    }
    public String getEspecialidade() {
        return especialidade;
    }
    public void setEspecialidade(String especialidade) {
        this.especialidade = especialidade;
    }

    
}
