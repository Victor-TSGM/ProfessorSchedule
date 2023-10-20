package com.archweb.schedule.dtos;

import java.time.LocalDate;
import java.time.LocalDateTime;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Builder
public class ScheduleDTO {
    private Integer id;
    private LocalDate startDate;
    private LocalDate finalDate;
    private LocalDateTime startHour;
    private LocalDateTime finalHour;
    private Integer professorId;
    private Integer addressId;
}
