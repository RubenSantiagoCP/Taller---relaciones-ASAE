package com.edu.unicauca.asae.formatoa_relaciones;

import java.time.LocalDate;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.edu.unicauca.asae.formatoa_relaciones.enums.StateEnum;
import com.edu.unicauca.asae.formatoa_relaciones.models.PPAFormat;
import com.edu.unicauca.asae.formatoa_relaciones.models.Professor;
import com.edu.unicauca.asae.formatoa_relaciones.models.State;
import com.edu.unicauca.asae.formatoa_relaciones.models.TIAFormat;
import com.edu.unicauca.asae.formatoa_relaciones.repositories.AFormatRepository;
import com.edu.unicauca.asae.formatoa_relaciones.repositories.HistoricalRecordRepository;
import com.edu.unicauca.asae.formatoa_relaciones.repositories.ObservationRepository;
import com.edu.unicauca.asae.formatoa_relaciones.repositories.ProfessorRepository;
import com.edu.unicauca.asae.formatoa_relaciones.repositories.RoleRepository;
import com.edu.unicauca.asae.formatoa_relaciones.repositories.StateRepository;


@SpringBootApplication

public class FormatoaRelacionesApplication implements CommandLineRunner {

	@Autowired
	private  AFormatRepository aFormatRepository;

	@Autowired
	private  StateRepository stateRepository;

	@Autowired
	private  RoleRepository roleRepository;

	@Autowired
	private  ProfessorRepository professorRepository;

	@Autowired
	private  ObservationRepository observationRepository;

	@Autowired
	private  HistoricalRecordRepository historicalRecordRepository;

	public static void main(String[] args) {
		SpringApplication.run(FormatoaRelacionesApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		/*professorRepository.deleteAll();
		aFormatRepository.deleteAll();
		createtTIAFormat();
		createPPAFormat();*/

	}

	private void createtTIAFormat() {
		TIAFormat objTIAFormat = TIAFormat.builder()
				.title("Título de la tesis")
				.generalObjective("Objetivo general")
				.specificObjective("Objetivo específico")
				.student1Name("student1")
				.student2Name("student2")
				.build();

		Professor obProfessor = Professor.builder()
				.name("Nombre del profesor")
				.lastName("Apellidos del profesor")
				.groupName("Grupo del profesor")
				.email("email@gmail.com")
				.build();

		State objState = State.builder()
				.actualState(StateEnum.FORMULATED)
				.registerStateDate(LocalDate.now())
				.build();

		objTIAFormat.setObjProfessor(obProfessor);
		objTIAFormat.setState(objState);

		this.aFormatRepository.save(objTIAFormat);
	}

	private void createPPAFormat() {
		PPAFormat objPPAFormat = PPAFormat.builder()
				.title("Título de la tesis 2")
				.generalObjective("Objetivo general")
				.specificObjective("Objetivo específico")
				.assesorName("assesor")
				.studedt1Name("student1")
				.acceptanceLetterRoute("route")
				.build();

		Professor obProfessor = Professor.builder()
				.name("Nombre del profesor")
				.lastName("Apellidos del profesor")
				.groupName("Grupo del profesor")
				.email("email2@gmail.com")
				.build();

		State objState = State.builder()
				.actualState(StateEnum.FORMULATED)
				.registerStateDate(LocalDate.now())
				.build();

		objPPAFormat.setObjProfessor(obProfessor);
		objPPAFormat.setState(objState);

		this.aFormatRepository.save(objPPAFormat);
	}




}
