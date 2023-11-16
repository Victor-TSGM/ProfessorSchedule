package com.example.ac2.services;

import java.util.List;

import com.example.ac2.dtos.CursosDTO;
import com.example.ac2.dtos.DadosCursosDTO;
import com.example.ac2.models.Cursos;

public interface CursosService {
    Cursos salvarCurso(CursosDTO cursosDTO);
    List<CursosDTO> listarCursos();

    DadosCursosDTO obtainById(Integer id);
    void delete(Integer id);
    void update(Integer id, CursosDTO dto);
}
