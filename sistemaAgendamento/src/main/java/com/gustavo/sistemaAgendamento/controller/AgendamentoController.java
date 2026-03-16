package com.gustavo.sistemaAgendamento.controller;

import java.util.List;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.gustavo.sistemaAgendamento.dto.AgendamentoRequest;
import com.gustavo.sistemaAgendamento.dto.AgendamentoResponse;
import com.gustavo.sistemaAgendamento.entity.Agendamento;
import com.gustavo.sistemaAgendamento.service.AgendamentoService;

@RestController
@RequestMapping("/agendamentos")
public class AgendamentoController {
    
    private final AgendamentoService agendamentoService;

    /* Contrutor */
    public AgendamentoController(AgendamentoService agendamentoService) {
        this.agendamentoService = agendamentoService;
    }

    
    //Cadastrar
    @PostMapping
    public AgendamentoResponse cadastrar(@RequestBody AgendamentoRequest dto){
        Agendamento a = agendamentoService.cadastrar(dto);
        return agendamentoService.toResponse(a);
    }

    //Listar
    @GetMapping
    public List<AgendamentoResponse> listar(){
        return agendamentoService.listar()
                                .stream()
                                .map(agendamentoService::toResponse)
                                .toList();
    }

    //Atualizar(Cancelar serviço)
    @PutMapping("/{id}")
    public AgendamentoResponse cancelar(@PathVariable int id){
        Agendamento a = agendamentoService.cancelar(id);
        return agendamentoService.toResponse(a);
    }

    //Deletar
    @DeleteMapping("/{id}")
    public void deletar(@PathVariable int id){
        agendamentoService.deletar(id);
    }
    
}
