package com.gustavo.sistemaAgendamento.dto;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;

public class ClienteRequest {
    
    @NotBlank(message = "Nome não pode ser vaziu")
    private String nome;

    @NotBlank(message = "Telefone não pode ser vaziu")
    private String telefone;

    @Email(message = "Email incorreto")
    private String email;
    
    /* Construtor */
    public ClienteRequest() {
    }

    /* Getters e Setters */
    public String getNome() {
        return nome;
    }
    public void setNome(String nome) {
        this.nome = nome;
    }
    public String getTelefone() {
        return telefone;
    }
    public void setTelefone(String telefone) {
        this.telefone = telefone;
    }
    public String getEmail() {
        return email;
    }
    public void setEmail(String email) {
        this.email = email;
    }

    
}
