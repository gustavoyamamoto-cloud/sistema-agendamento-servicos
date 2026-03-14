package com.gustavo.sistemaAgendamento.controller;

import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.gustavo.sistemaAgendamento.dto.ProfissionalRequest;
import com.gustavo.sistemaAgendamento.dto.ProfissionalResponse;
import com.gustavo.sistemaAgendamento.entity.Profissional;
import com.gustavo.sistemaAgendamento.service.ProfissionalService;

import jakarta.validation.Valid;

@RestController
@RequestMapping("/profissionais")
public class ProfissionalController {
    
    private final ProfissionalService profissionalService;

    /* Controller */
    public ProfissionalController(ProfissionalService profissionalService) {
        this.profissionalService = profissionalService;
    }


    //Cadastrar
    @PostMapping
    public ProfissionalResponse cadastrar(@RequestBody @Valid ProfissionalRequest dto){
        Profissional p = profissionalService.cadastrar(dto);
        return profissionalService.toResponse(p);
    }

    //Listar
    @GetMapping
    public List<ProfissionalResponse> listar(){
        return profissionalService.listar()
                                .stream()
                                .map(profissionalService::toResponse)
                                .toList();
    }

    
}
