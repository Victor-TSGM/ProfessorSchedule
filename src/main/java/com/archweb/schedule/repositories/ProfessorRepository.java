package com.archweb.schedule.repositories;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.archweb.schedule.models.Professor;

public interface ProfessorRepository extends
                JpaRepository<Professor, Integer> {

        @Query("select item from Professor item left join fetch item.Courses c " +
                        "where item.id = :id ")
        Professor findCursosFetchProfessor(@Param("id") Integer id);

}