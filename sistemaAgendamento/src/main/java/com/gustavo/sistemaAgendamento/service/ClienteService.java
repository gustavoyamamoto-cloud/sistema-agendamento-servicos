package com.gustavo.sistemaAgendamento.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.gustavo.sistemaAgendamento.dto.ClienteRequest;
import com.gustavo.sistemaAgendamento.dto.ClienteResponse;
import com.gustavo.sistemaAgendamento.entity.Cliente;
import com.gustavo.sistemaAgendamento.repository.ClienteRepository;

@Service
public class ClienteService {
    
    private final ClienteRepository clienteRepository;

    /* Construtor */
    public ClienteService(ClienteRepository clienteRepository) {
        this.clienteRepository = clienteRepository;
    }

    /* toResponse */
    public ClienteResponse toResponse(Cliente c){
        return new ClienteResponse(
            c.getId(),
            c.getNome(),
            c.getTelefone(),
            c.getEmail()
        );
    }

    /* ToEntity */
    public Cliente toEntity(ClienteRequest dto){
        Cliente c = new Cliente();
        c.setNome(dto.getNome());
        c.setTelefone(dto.getTelefone());
        c.setEmal(dto.getEmail());
        return c;
    }


    //Cadastrar Cliente
    public Cliente cadastrar(ClienteRequest dto){
        Cliente c = toEntity(dto);
        return clienteRepository.save(c);
    }

    //Listar Cliente
    public List<Cliente> listar(){
        return clienteRepository.findAll();
    }

    
}
