package com.example.ac2.services;

import com.example.ac2.dtos.CursosDTO;
import com.example.ac2.dtos.DadosCursosDTO;
import com.example.ac2.dtos.ProfessoresDTO;
import com.example.ac2.exceptions.RegraNegocioException;
import com.example.ac2.models.Cursos;
import com.example.ac2.models.Professores;
import com.example.ac2.repositories.AgendaRepository;
import com.example.ac2.repositories.CursosRepository;

import java.util.List;
import java.util.stream.Collectors;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class CursosServiceImplementation implements CursosService {

  private final CursosRepository cursosRepository;
  private final AgendaRepository agendaRepository;

  @Override
  public Cursos salvarCurso(CursosDTO cursosDTO) {
    Cursos c = new Cursos();
    c.setDescricao(cursosDTO.getDescricao());
    c.setCargaHoraria(cursosDTO.getCargaHoraria());
    c.setObjetivos(cursosDTO.getObjetivos());
    c.setEmenta(cursosDTO.getEmenta());
    return cursosRepository.save(c);
  }

  @Override
  public List<CursosDTO> listarCursos() {
    List<CursosDTO> cursos = cursosRepository
      .findAll()
      .stream()
      .map((Cursos c) -> {
        return CursosDTO
          .builder()
          .id(c.getId())
          .descricao(c.getDescricao())
          .cargaHoraria(c.getCargaHoraria())
          .objetivos(c.getObjetivos())
          .ementa(c.getEmenta())
          .build();
      })
      .collect(Collectors.toList());

    return cursos;
  }

  @Override
  public DadosCursosDTO obtainById(Integer id) {
    return cursosRepository
      .findCursosByIdFetchProfessores(id)
      .map((Cursos c) -> {
        return DadosCursosDTO
          .builder()
          .id(c.getId())
          .descricao(c.getDescricao())
          .cargaHoraria(c.getCargaHoraria())
          .objetivos(c.getObjetivos())
          .ementa(c.getEmenta())
          .professores(
            c.getProfessores() != null
              ? c
                .getProfessores()
                .stream()
                .map((Professores p) -> {
                  return ProfessoresDTO
                    .builder()
                    .id(p.getId())
                    .nome(p.getNome())
                    .cpf(p.getCpf())
                    .rg(p.getRg())
                    .endereco(p.getEndereco())
                    .celular(p.getCelular())
                    .build();
                })
                .collect(Collectors.toList())
              : null
          )
          .build();
      })
      .orElseThrow(() ->
        new RegraNegocioException("Curso com o ID fornecido não pode ser encontrado!")
      );
      // return null;
  }

  @Override
  public void delete(Integer id) {
    Cursos cursos = cursosRepository
      .findById(id)
      .orElseThrow(() ->
        new RegraNegocioException("Código do curso não encontrado.")
      );

    if (agendaRepository.existsByCursosId(cursos.getId())) {
      throw new RegraNegocioException(
        "O Curso está em alguma agenda, e por isso não pode ser excluído!"
      );
    }

    cursosRepository.deleteById(id);
  }

  @Override
  public void update(Integer id, CursosDTO dto) {
    Cursos cursos = cursosRepository
      .findById(id)
      .orElseThrow(() ->
        new RegraNegocioException("Código de curso não encontrado.")
      );

    cursos.setDescricao(dto.getDescricao());
    cursos.setCargaHoraria(dto.getCargaHoraria());
    cursos.setObjetivos(dto.getObjetivos());
    cursos.setEmenta(dto.getEmenta());
    cursosRepository.save(cursos);
  }
}
