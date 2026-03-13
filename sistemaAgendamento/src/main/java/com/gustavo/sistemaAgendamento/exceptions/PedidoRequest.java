package com.gustavo.sistemaAgendamento.exceptions;

import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;

public class PedidoRequest {
    
    @NotBlank(message="Descricao é obrigatoria")
		private String descricao;

    @NotNull(message="Preco é obrigatorio")
    @Positive(message="Preco deve ser maior que zero")
		private Double preco;

    @NotNull(message="ClienteId é obrigatorio")
    @Min(value=1,message="ClienteId deve ser maior que 0")
		private Integer clienteId;
}
