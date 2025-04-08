package com.edu.unicauca.asae.formatoa_relaciones.repositories;

import com.edu.unicauca.asae.formatoa_relaciones.models.Professor;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;

import com.edu.unicauca.asae.formatoa_relaciones.models.AFormat;

import java.util.List;

public interface AFormatRepository extends JpaRepository<AFormat, Long> {
    List<AFormat> findAllByObjProfessor_Id(Long id);
}
