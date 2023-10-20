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

    

    public Schedule(LocalDate startDate, LocalDate finalDate, LocalDateTime startHour, LocalDateTime finalHour,
            Professor professor, Course course, Address address) {
        this.startDate = startDate;
        this.finalDate = finalDate;
        this.startHour = startHour;
        this.finalHour = finalHour;
        this.professor = professor;
        this.course = course;
        this.address = address;
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
     * @return LocalDate return the startDate
     */
    public LocalDate getStartDate() {
        return startDate;
    }

    /**
     * @param startDate the startDate to set
     */
    public void setStartDate(LocalDate startDate) {
        this.startDate = startDate;
    }

    /**
     * @return LocalDateTime return the startHour
     */
    public LocalDateTime getStartHour() {
        return startHour;
    }

    /**
     * @param startHour the startHour to set
     */
    public void setStartHour(LocalDateTime startHour) {
        this.startHour = startHour;
    }

    /**
     * @return Professor return the professor
     */
    public Professor getProfessor() {
        return professor;
    }

    /**
     * @param professor the professor to set
     */
    public void setProfessor(Professor professor) {
        this.professor = professor;
    }

    /**
     * @return List<Course> return the courses
     */
    public List<Course> getCourses() {
        return courses;
    }

    /**
     * @param courses the courses to set
     */
    public void setCourses(List<Course> courses) {
        this.courses = courses;
    }

    /**
     * @return Course return the course
     */
    public Course getCourse() {
        return course;
    }

    /**
     * @param course the course to set
     */
    public void setCourse(Course course) {
        this.course = course;
    }

    /**
     * @return Address return the address
     */
    public Address getAddress() {
        return address;
    }

    /**
     * @param address the address to set
     */
    public void setAddress(Address address) {
        this.address = address;
    }

}