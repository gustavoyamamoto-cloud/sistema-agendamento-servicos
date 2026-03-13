package com.gustavo.sistemaAgendamento.exceptions;

public class ErroResponse {
    
    private int status;
	private String mensagem;
	private long timestamp;

	public ErroResponse(int status,String mensagem){
		this.status = status;
		this.mensagem = mensagem;
		this.timestamp = System.currentTimeMillis();
    }

    /* Getters */  
    public int getStatus() {
        return status;
    }

    public String getMensagem() {
        return mensagem;
    }

    public long getTimestamp() {
        return timestamp;
    }
}
