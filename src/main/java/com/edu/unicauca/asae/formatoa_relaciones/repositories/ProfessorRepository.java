package com.edu.unicauca.asae.formatoa_relaciones.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;

import com.edu.unicauca.asae.formatoa_relaciones.models.Professor;

import java.util.List;

public interface ProfessorRepository extends JpaRepository<Professor, Long> {
    List<Professor> findByEmail(String email);
}
