package com.edu.unicauca.asae.formatoa_relaciones.repositories;

import org.springframework.data.repository.CrudRepository;

import com.edu.unicauca.asae.formatoa_relaciones.models.HistoricalRecord;

public interface HistoricalRecordRepository extends CrudRepository<HistoricalRecord, Long> {
    
}
