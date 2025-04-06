package com.edu.unicauca.asae.formatoa_relaciones;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.edu.unicauca.asae.formatoa_relaciones.repositories.AFormatRepository;
import com.edu.unicauca.asae.formatoa_relaciones.repositories.HistoricalRecordRepository;
import com.edu.unicauca.asae.formatoa_relaciones.repositories.ObservationRepository;
import com.edu.unicauca.asae.formatoa_relaciones.repositories.ProfessorRepository;
import com.edu.unicauca.asae.formatoa_relaciones.repositories.RoleRepository;
import com.edu.unicauca.asae.formatoa_relaciones.repositories.StateRepository;

import lombok.RequiredArgsConstructor;

@SpringBootApplication
@RequiredArgsConstructor
public class FormatoaRelacionesApplication implements CommandLineRunner {

	private final AFormatRepository aFormatRepository;

	private final StateRepository stateRepository;

	private final RoleRepository roleRepository;

	private final ProfessorRepository professorRepository;

	private final ObservationRepository observationRepository;

	private final HistoricalRecordRepository historicalRecordRepository;

	public static void main(String[] args) {
		SpringApplication.run(FormatoaRelacionesApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		System.out.println("Hello World");

	}


}
