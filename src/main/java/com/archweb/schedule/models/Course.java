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

    public Course(Integer id, String description, int workload, String objectives, String menus) {
        this.id = id;
        this.description = description;
        this.workload = workload;
        this.objectives = objectives;
        this.menus = menus;
    }


    /**
     * @return Integer return the id
     */
    public Integer getId() {
        return id;
    }

    /**
     * @param id the id to set
     */
    public void setId(Integer id) {
        this.id = id;
    }

    /**
     * @return String return the description
     */
    public String getDescription() {
        return description;
    }

    /**
     * @param description the description to set
     */
    public void setDescription(String description) {
        this.description = description;
    }

    /**
     * @return int return the workload
     */
    public int getWorkload() {
        return workload;
    }

    /**
     * @param workload the workload to set
     */
    public void setWorkload(int workload) {
        this.workload = workload;
    }

    /**
     * @return String return the objectives
     */
    public String getObjectives() {
        return objectives;
    }

    /**
     * @param objectives the objectives to set
     */
    public void setObjectives(String objectives) {
        this.objectives = objectives;
    }

    /**
     * @return String return the menus
     */
    public String getMenus() {
        return menus;
    }

    /**
     * @param menus the menus to set
     */
    public void setMenus(String menus) {
        this.menus = menus;
    }

    /**
     * @return List<Schedule> return the schedules
     */
    public List<Schedule> getSchedules() {
        return schedules;
    }

    /**
     * @param schedules the schedules to set
     */
    public void setSchedules(List<Schedule> schedules) {
        this.schedules = schedules;
    }

    /**
     * @return List<Professor> return the professors
     */
    public List<Professor> getProfessors() {
        return professors;
    }

    /**
     * @param professors the professors to set
     */
    public void setProfessors(List<Professor> professors) {
        this.professors = professors;
    }

}