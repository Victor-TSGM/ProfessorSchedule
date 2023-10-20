package com.archweb.schedule.models;

import java.util.List;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Course {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    @Column(length = 200, nullable = false)
    private String description;
    @Column(nullable = false)
    private int workload;
    @Column(nullable = false)
    private String objectives;
    @Column(nullable = false)
    private String menus;
    @OneToMany(mappedBy = "course")
    private List<Schedule> schedules;
    @ManyToMany(mappedBy = "courses")
    private List<Professor> professors;

}