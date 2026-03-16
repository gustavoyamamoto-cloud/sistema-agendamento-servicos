package com.gustavo.sistemaAgendamento.exceptions;

public class ClienteNaoExisteExceptions extends RuntimeException{
    
    public ClienteNaoExisteExceptions(String msg){
        super(msg);
    }
}
