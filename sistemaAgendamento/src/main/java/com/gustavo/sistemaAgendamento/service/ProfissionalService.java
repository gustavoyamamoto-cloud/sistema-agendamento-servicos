package com.gustavo.sistemaAgendamento.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.gustavo.sistemaAgendamento.dto.ProfissionalRequest;
import com.gustavo.sistemaAgendamento.dto.ProfissionalResponse;
import com.gustavo.sistemaAgendamento.entity.Profissional;
import com.gustavo.sistemaAgendamento.repository.ProfissionalRepository;

@Service
public class ProfissionalService {
    
    private final ProfissionalRepository profissionalRepository;

    /* Construtor */
    public ProfissionalService(ProfissionalRepository profissionalRepository) {
        this.profissionalRepository = profissionalRepository;
    }

    /* ToResponse */
    public ProfissionalResponse toResponse(Profissional p){
        return new ProfissionalResponse(
            p.getId(),
            p.getNome(),
            p.getEspecialidade()
        );
    }

    /* ToEntity */
    public Profissional toEntity(ProfissionalRequest dto){
        Profissional p =  new Profissional();
        p.setNome(dto.getNome());
        p.setEspecialidade(dto.getEspecialidade());
        return p;
    }
    

    //Cadastrar
    public Profissional cadastrar(ProfissionalRequest dto){
        Profissional p = toEntity(dto);
        return profissionalRepository.save(p);
    }

    //Listar
    public List<Profissional> listar(){
        return profissionalRepository.findAll();
    }

}
