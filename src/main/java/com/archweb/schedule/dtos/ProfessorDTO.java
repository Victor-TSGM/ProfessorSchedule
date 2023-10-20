package com.archweb.schedule.dtos;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Builder
public class ProfessorDTO {
    private Integer id;
    private String name;
    private String cpf;
    private String rg;
    private String phone; // rua josé, 200 - sorocaba -sao paulo 18000000
    private Integer addressId;

}