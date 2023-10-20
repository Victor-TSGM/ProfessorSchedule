package com.archweb.schedule.dtos;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Builder
public class CourseDTO {
    private Integer id;
    private String description;
    private int workload;
    private String objectives;
    private String menus;
    private Integer professoId;
    
}