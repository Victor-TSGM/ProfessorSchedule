package com.example.ac2.services;

import java.util.List;

import com.example.ac2.dtos.DadosProfessoresDTO;
import com.example.ac2.dtos.ProfessoresDTO;
import com.example.ac2.models.Professores;

public interface ProfessoresService {
    Professores salvar(ProfessoresDTO professoresDTO);
    List<ProfessoresDTO> listarTodos();

    DadosProfessoresDTO obtainById(Integer id);
    void delete(Integer id);
    void update(Integer id, ProfessoresDTO dto);
}
