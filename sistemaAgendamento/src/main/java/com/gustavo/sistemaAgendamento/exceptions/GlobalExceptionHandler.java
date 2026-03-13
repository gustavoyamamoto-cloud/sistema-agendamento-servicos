package com.gustavo.sistemaAgendamento.exceptions;

import java.util.HashMap;
import java.util.Map;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class GlobalExceptionHandler {
    
    // 400 - Erro de validação
    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ResponseEntity<ErroResponse> tratarValidacoes(MethodArgumentNotValidException ex) {

        Map<String, String> erros = new HashMap<>();

        ex.getBindingResult().getFieldErrors()
                .forEach(erro ->
                        erros.put(erro.getField(), erro.getDefaultMessage())
                );

        ErroResponse erroResponse = new ErroResponse(
                HttpStatus.BAD_REQUEST.value(),
                "Erro de validação"
        );

        return ResponseEntity.status(HttpStatus.BAD_REQUEST)
                .body(erroResponse);
    }

    // 500 - Erro interno
    @ExceptionHandler(Exception.class)
    public ResponseEntity<ErroResponse> tratarErroGeral(Exception ex) {

        ErroResponse erro = new ErroResponse(
                HttpStatus.INTERNAL_SERVER_ERROR.value(),
                "Erro interno no servidor"
        );

        return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
                .body(erro);
    }
}
