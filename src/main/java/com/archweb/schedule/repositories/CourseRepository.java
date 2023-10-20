package com.archweb.schedule.repositories;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;

import com.archweb.schedule.models.Course;

public interface CourseRepository extends JpaRepository<Course, Long> {
        List<Course> findByNomeLike(String name);
}