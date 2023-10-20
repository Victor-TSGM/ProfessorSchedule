package com.archweb.schedule.models;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.ManyToOne;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Schedule {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    @Column(nullable = false)
    private LocalDate startDate;
    @Column(nullable = false)
    private LocalDate finalDate;
    @Column(nullable = false)
    private LocalDateTime startHour;
    @Column(nullable = false)
    private LocalDateTime finalHour;
    @ManyToOne
    @JoinColumn(name = "professor_id")
    private Professor professor;
    @ManyToMany(mappedBy = "professors")
    private List<Course> courses;
    private Course course;
    @ManyToOne
    @JoinColumn(name = "address_id")
    private Address address;
}