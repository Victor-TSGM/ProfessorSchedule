package com.example.ac2.controllers;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.example.ac2.dtos.AgendaDTO;
import com.example.ac2.dtos.DadosAgendaDTO;
import com.example.ac2.services.AgendaService;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;


@RestController
@RequestMapping("/api/agenda")
public class AgendaController {
    private AgendaService agendaService;

    public AgendaController(AgendaService agendaService){
        this.agendaService = agendaService;
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public int salvarAgenda(@RequestBody AgendaDTO agendaDTO){
        return agendaService.salvarAgenda(agendaDTO).getId();
    }

    @GetMapping
    public List<AgendaDTO> listarAgenda() {
        return agendaService.listarAgenda();
    }

    @GetMapping("{id}")
    public DadosAgendaDTO getById(@PathVariable Integer id){
        return agendaService.obtainById(id);
    }

    @DeleteMapping("{id}")
    public void delete(@PathVariable Integer id){
        agendaService.delete(id);
    }

    @PutMapping("{id}")
    public void edit(@PathVariable Integer id, @RequestBody AgendaDTO dto){
        agendaService.update(id, dto);
    }
}