package com.gustavo.sistemaAgendamento.controller;

import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.gustavo.sistemaAgendamento.dto.ClienteRequest;
import com.gustavo.sistemaAgendamento.dto.ClienteResponse;
import com.gustavo.sistemaAgendamento.entity.Cliente;
import com.gustavo.sistemaAgendamento.service.ClienteService;

import jakarta.validation.Valid;

@RestController
@RequestMapping("/clientes")
public class ClienteController {
    
    private final ClienteService clienteService;

    /* Construtor */
    public ClienteController(ClienteService clienteService) {
        this.clienteService = clienteService;
    }


    //Cadastrar
    @PostMapping
    public ClienteResponse cadastrar(@RequestBody @Valid ClienteRequest dto){
        Cliente c = clienteService.cadastrar(dto);
        return clienteService.toResponse(c);
    }

    //Listar
    @GetMapping
    public List<ClienteResponse> listar(){
        return clienteService.listar()
                            .stream()
                            .map(clienteService::toResponse)
                            .toList();
    }

    
}
