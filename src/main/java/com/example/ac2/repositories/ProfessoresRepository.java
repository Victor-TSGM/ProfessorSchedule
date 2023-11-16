package com.example.ac2.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import com.example.ac2.models.Professores;

public interface ProfessoresRepository extends JpaRepository<Professores, Integer> {
    @Query("SELECT p FROM Professores p RIGHT JOIN FETCH p.agenda WHERE p.id = :id")
    List<Professores> findProfessoresFetchAgenda(@Param("id") Integer id);
}
