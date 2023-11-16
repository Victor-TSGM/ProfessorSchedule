package com.example.ac2.services;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.stereotype.Service;

import com.example.ac2.dtos.DadosProfessoresDTO;
import com.example.ac2.dtos.ProfessoresDTO;
import com.example.ac2.exceptions.RegraNegocioException;
import com.example.ac2.models.Professores;
import com.example.ac2.repositories.AgendaRepository;
import com.example.ac2.repositories.ProfessoresRepository;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class ProfessoresServiceImplementation implements ProfessoresService {
    private final ProfessoresRepository professoresRepository;
    private final AgendaRepository agendaRepository;
    
    @Override
    public Professores salvar(ProfessoresDTO professoresDTO) {
        Professores pf = new Professores();
        pf.setNome(professoresDTO.getNome());
        pf.setCpf(professoresDTO.getCpf());
        pf.setRg(professoresDTO.getRg());
        pf.setEndereco(professoresDTO.getEndereco());
        pf.setCelular(professoresDTO.getCelular());

        return professoresRepository.save(pf);
    }

    @Override
    public List<ProfessoresDTO> listarTodos() {
        List<ProfessoresDTO> cursos = professoresRepository.findAll().stream().map(
            (Professores pf) -> {
                return ProfessoresDTO.builder()
                .id(pf.getId())
                .nome(pf.getNome())
                .cpf(pf.getCpf())
                .rg(pf.getRg())
                .endereco(pf.getEndereco())
                .celular(pf.getCelular())
                .build();
            }
        ).collect(Collectors.toList());

        return cursos;
    }

    @Override
    public DadosProfessoresDTO obtainById(Integer id) {
        return professoresRepository.findById(id).map(
            (Professores pf) -> {
                return DadosProfessoresDTO.builder()
                .id(pf.getId())
                .nome(pf.getNome())
                .cpf(pf.getCpf())
                .rg(pf.getRg())
                .endereco(pf.getEndereco())
                .celular(pf.getCelular())
                .build();
            }
        ).orElseThrow(
            () -> new RegraNegocioException("O Professor com o ID fornecido não pode ser encontrado!")
        );
    }

    @Override
    public void delete(Integer id) {
        Professores professores = professoresRepository.findById(id).orElseThrow(
            () -> new RegraNegocioException("Professor não encontrado")
        );

        if(agendaRepository.existsByProfessoresId(professores.getId())){
            throw new RegraNegocioException("O Professor possui agenda, e por isso não pode ser excluído!");
        }

        professoresRepository.deleteById(id);
    }

    @Override
    public void update(Integer id, ProfessoresDTO dto) {
        Professores professores = professoresRepository.findById(id).orElseThrow(
            () -> new RegraNegocioException("ID de Professor não encontrado!")
        );

        professores.setNome(dto.getNome());
        professores.setCpf(dto.getCpf());
        professores.setRg(dto.getRg());
        professores.setEndereco(dto.getEndereco());
        professores.setCelular(dto.getCelular());

        professoresRepository.save(professores);
    }
}
