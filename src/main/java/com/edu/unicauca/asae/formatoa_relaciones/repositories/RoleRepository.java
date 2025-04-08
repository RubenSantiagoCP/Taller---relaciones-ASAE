package com.edu.unicauca.asae.formatoa_relaciones.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;

import com.edu.unicauca.asae.formatoa_relaciones.models.Role;

public interface RoleRepository extends JpaRepository<Role, Long> {
    
}
