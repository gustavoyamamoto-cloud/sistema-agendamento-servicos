package com.gustavo.sistemaAgendamento.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.gustavo.sistemaAgendamento.dto.AgendamentoRequest;
import com.gustavo.sistemaAgendamento.dto.AgendamentoResponse;
import com.gustavo.sistemaAgendamento.entity.Agendamento;
import com.gustavo.sistemaAgendamento.entity.Cliente;
import com.gustavo.sistemaAgendamento.entity.Profissional;
import com.gustavo.sistemaAgendamento.enuns.Status;
import com.gustavo.sistemaAgendamento.exceptions.AgendamentoNaoExisteExceptions;
import com.gustavo.sistemaAgendamento.exceptions.ClienteNaoExisteExceptions;
import com.gustavo.sistemaAgendamento.exceptions.ProfissionalNaoExiste;
import com.gustavo.sistemaAgendamento.repository.AgendamentoRepository;
import com.gustavo.sistemaAgendamento.repository.ClienteRepository;
import com.gustavo.sistemaAgendamento.repository.ProfissionalRepository;

@Service
public class AgendamentoService {
    
    private final AgendamentoRepository agendamentoRepository;
    private final ClienteRepository clienteRepository;
    private final ProfissionalRepository profissionalRepository;
    
    /* Construtor */
    public AgendamentoService(AgendamentoRepository agendamentoRepository, ClienteRepository clienteRepository,
            ProfissionalRepository profissionalRepository) {
        this.agendamentoRepository = agendamentoRepository;
        this.clienteRepository = clienteRepository;
        this.profissionalRepository = profissionalRepository;
    }
    
    
    /* ToResponse */
    public AgendamentoResponse toResponse(Agendamento a){
        return new AgendamentoResponse(
            a.getId(),
            a.getData(),
            a.getHora(),
            a.getStatus(),
            a.getCliente().getId(),
            a.getProfissional().getId()
        );
    }

    /* ToEntity */
    public Agendamento toEntity(AgendamentoRequest dto){
        Agendamento a = new Agendamento();
        a.setData(dto.getData());
        a.setHora(dto.getHora());
        a.setStatus(Status.AGENDADO);
        
        Cliente c = clienteRepository.findById(dto.getClienteId())
        .orElseThrow(() -> new ClienteNaoExisteExceptions("Id do cliente não encontrado"));
        Profissional p = profissionalRepository.findById(dto.getProfissionalId())
        .orElseThrow(() -> new ProfissionalNaoExiste("Id do profissional não encontrado"));

        a.setCliente(c);
        a.setProfissional(p);
        return a;
    }

    
    //Cadastrar (Agendar) 
    public Agendamento cadastrar(AgendamentoRequest dto){

        //Verificar se existe data hora desse profissional
        boolean horarioOcupado = agendamentoRepository .existsByDataAndHoraAndProfissionalId(dto.getData(), dto.getHora(), dto.getProfissionalId()); 
        
        if(horarioOcupado){ 
            throw new RuntimeException("Horário já está ocupado para esse profissional"); 
        } 

        Agendamento a = toEntity(dto);
        return agendamentoRepository.save(a);
    }

    //Listar
    public List<Agendamento> listar(){
        return agendamentoRepository.findAll();
    }

    //Cancelar
    public Agendamento cancelar(int id){
        Agendamento a = agendamentoRepository.findById(id)
        .orElseThrow(() -> new AgendamentoNaoExisteExceptions("Agendamento não existe"));

        a.setStatus(Status.CANCELADO);

        return agendamentoRepository.save(a);
    }

    //Deletar
    public void deletar(int id){
        Agendamento a = agendamentoRepository.findById(id)
        .orElseThrow(() -> new AgendamentoNaoExisteExceptions("Id do agendamento não encontrado"));
        agendamentoRepository.delete(a);
    }
    
}
