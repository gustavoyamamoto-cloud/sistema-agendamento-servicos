package com.gustavo.sistemaAgendamento.exceptions;

public class ProfissionalNaoExiste extends RuntimeException{
    
    public ProfissionalNaoExiste(String msg){
        super(msg);
    }
}
