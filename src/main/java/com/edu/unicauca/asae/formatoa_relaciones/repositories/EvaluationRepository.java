package com.edu.unicauca.asae.formatoa_relaciones.repositories;

import com.edu.unicauca.asae.formatoa_relaciones.models.Evaluation;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

public interface EvaluationRepository extends JpaRepository<Evaluation, Long> {
}
