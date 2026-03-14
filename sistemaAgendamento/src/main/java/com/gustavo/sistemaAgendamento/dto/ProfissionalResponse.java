package com.gustavo.sistemaAgendamento.dto;

public class ProfissionalResponse {
    
    private Integer id;
    private String nome;
    private String especialidade;
    
    /* Construtor */
    public ProfissionalResponse(Integer id, String nome, String especialidade) {
        this.id = id;
        this.nome = nome;
        this.especialidade = especialidade;
    }

    /* Getters e Setters */
    public Integer getId() {
        return id;
    }
    public void setId(Integer id) {
        this.id = id;
    }
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
