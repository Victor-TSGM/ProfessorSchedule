package com.example.ac2.services;

import java.util.List;

import com.example.ac2.dtos.AgendaDTO;
import com.example.ac2.dtos.DadosAgendaDTO;
import com.example.ac2.models.Agenda;

public interface AgendaService {
    Agenda salvarAgenda(AgendaDTO agendaDTO);
    List<AgendaDTO> listarAgenda();

    DadosAgendaDTO obtainById(Integer id);
    void delete(Integer id);
    void update(Integer id, AgendaDTO dto);
}
