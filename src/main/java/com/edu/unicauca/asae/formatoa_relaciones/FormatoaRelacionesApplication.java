package com.edu.unicauca.asae.formatoa_relaciones;

import java.time.LocalDate;
import java.util.*;

import com.edu.unicauca.asae.formatoa_relaciones.enums.ConceptEnum;
import com.edu.unicauca.asae.formatoa_relaciones.enums.RoleEnum;
import com.edu.unicauca.asae.formatoa_relaciones.models.*;
import com.edu.unicauca.asae.formatoa_relaciones.repositories.*;
import org.hibernate.internal.util.collections.CollectionHelper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.edu.unicauca.asae.formatoa_relaciones.enums.StateEnum;
import org.springframework.transaction.annotation.Transactional;

@SpringBootApplication
@Transactional
public class FormatoaRelacionesApplication implements CommandLineRunner {

    @Autowired
    private AFormatRepository aFormatRepository;

    @Autowired
    private StateRepository stateRepository;

    @Autowired
    private RoleRepository roleRepository;

    @Autowired
    private ProfessorRepository professorRepository;

    @Autowired
    private ObservationRepository observationRepository;

    @Autowired
    private HistoricalRecordRepository historicalRecordRepository;

    @Autowired
    private TIAFormatRepository tiaFormatRepository;

    @Autowired
    private PPAFormatRepository ppaFormatRepository;

    @Autowired
    private EvaluationRepository evaluationRepository;

    public static void main(String[] args) {
        SpringApplication.run(FormatoaRelacionesApplication.class, args);
    }

    @Override
    public void run(String... args) throws Exception {
        /*
         * professorRepository.deleteAll();
         * aFormatRepository.deleteAll();
         * createObservation();
         */
        /* createPPAFormat(); */

        createAFormat();
        createObservation();
        getCommitteeMembers();
        getAFormatsByProfessor();

    }

    @Transactional
    public void createAFormat() {

        // Case 1: The director does not exist and it is stored in cascade when saving
        // the format
        Professor savedProfessor = Professor.builder()
                .name("Nombre del profesor")
                .lastName("Apellidos del profesor")
                .groupName("Grupo del profesor")
                .email("email@gmail.com")
                .build();

        State savedState = State.builder()
                .actualState(StateEnum.FORMULATED)
                .registerStateDate(LocalDate.now())
                .build();

        TIAFormat objTIAFormat = TIAFormat.builder()
                .title("Título de la tesis")
                .generalObjective("Objetivo general")
                .specificObjective("Objetivo específico")
                .student1Name("student1")
                .student2Name("student2")
                .objProfessor(savedProfessor)
                .state(savedState)
                .build();
        savedProfessor.setAFormat(List.of(objTIAFormat));
        this.aFormatRepository.save(objTIAFormat);

        // Case 2: The director already exists, it cannot be created, it is only
        // associated
        Professor objProfessor = professorRepository.getReferenceById(1L);

        State objState = State.builder()
                .actualState(StateEnum.FORMULATED)
                .registerStateDate(LocalDate.now())
                .build();

        PPAFormat objPPAFormat = PPAFormat.builder()
                .title("Título de la tesis 2")
                .generalObjective("Objetivo general")
                .specificObjective("Objetivo específico")
                .assesorName("assesor")
                .studedt1Name("student1")
                .acceptanceLetterRoute("route")
                .objProfessor(objProfessor)
                .state(objState)
                .build();

        this.aFormatRepository.save(objPPAFormat);

    }

    @Transactional
    public void createObservation() {
        Optional<TIAFormat> objTIAFormat = tiaFormatRepository.findById(1L);

        if (objTIAFormat.isPresent()) {
            List<Evaluation> lstEvaluations = objTIAFormat.get().getEvaluations();

            Evaluation evaluation;

            if (lstEvaluations == null || lstEvaluations.isEmpty()) {
                evaluation = Evaluation.builder()
                        .dateRegisterConcept(LocalDate.now())
                        .concept(ConceptEnum.UNESTABLISHED)
                        .coordinatorName("Nombre del coordinador")
                        .objAFormat(objTIAFormat.get())
                        .build();
                evaluation.setObjAFormat(objTIAFormat.get());
                evaluation = this.evaluationRepository.save(evaluation);

            } else {
                int sizeLstEvaluations = lstEvaluations.size();
                evaluation = lstEvaluations.get(sizeLstEvaluations - 1);
                evaluation = this.evaluationRepository.save(evaluation);
                if (!evaluation.getConcept().equals(ConceptEnum.TO_BE_FIXED)) {
                    System.out.println("No se pueden agregar más observaciones, el concepto de la evaluación es: "
                            + evaluation.getConcept().getDescription());
                    return;
                }
            }

            Iterable<Long> idDocentes = Arrays.asList(1L, 2L, 3L);
            List<Professor> lstProfessors = this.professorRepository.findAllById(idDocentes);
            Observation objObservation = Observation.builder()
                    .observation("Descripción de la observación")
                    .observationDateRegister(LocalDate.now())
                    .objEvaluation(evaluation)
                    .proffesors(lstProfessors)
                    .build();
            evaluation.setObservations(List.of(objObservation));

            this.observationRepository.save(objObservation);

        }

    }

    @Transactional(readOnly = true)
    public void getAFormatsByProfessor() {
        System.out.println("5. Consultar formatos A por docente");
        Professor proffesor = this.professorRepository.findById(6L).orElseThrow();
        System.out.println("Nombre del docente: " + proffesor.getName());
        System.out.println("Apellido del docente: "+proffesor.getLastName());

        List<AFormat> formats = proffesor.getAFormat();
        if (formats == null || formats.isEmpty()) {
            System.out.println("No hay formatos A para este docente");
            return;
        }
        System.out.println("===== FORMATOS A =====");

        for(AFormat objAFormat: proffesor.getAFormat()) {
            System.out.println("----Titulo del formato: " + objAFormat.getTitle()+"----");
            System.out.println("Docente: "+objAFormat.getObjProfessor().getName());
            System.out.println("---- Evaluaciones ----");
            //assert objAFormat.getEvaluations() != null;
            if (CollectionHelper.isEmpty(objAFormat.getEvaluations())) {
                System.out.println("No hay evaluaciones para este formato");
                continue;
            }
            for (Evaluation objEvaluation: objAFormat.getEvaluations()) {
                System.out.println("Evaluación: " + objEvaluation);
                System.out.println("Concepto: " + objEvaluation.getConcept());
                System.out.println("Fecha de registro: " + objEvaluation.getDateRegisterConcept());
                System.out.println("Nombre del coordinador: " + objEvaluation.getCoordinatorName());
                List<Observation> lstObservations = objEvaluation.getObservations();
                if (CollectionHelper.isEmpty(lstObservations)) {
                    System.out.println("No hay observaciones para esta evaluación");
                    continue;
                }
                for (Observation objObservation : lstObservations) {
                    System.out.println("Observación: " + objObservation);
                    System.out.println("Fecha de registro de la observación: " + objObservation.getObservationDateRegister());
                }
            }
        }

        /*for (AFormat objAFormat : proffesor.getAFormat()) {
            System.out.println("===== Titulo del formato: " + objAFormat.getTitle()+" =====");
            System.out.println("Docente: "+objAFormat.getObjProfessor().getName());
            System.out.println("---- Evaluaciones ----");
            //assert objAFormat.getEvaluations() != null;
            if (CollectionHelper.isEmpty(objAFormat.getEvaluations())) {
                System.out.println("No hay evaluaciones para este formato");
                continue;
            }


        }*/
    }

    @Transactional(readOnly = true)
    public void getObservations() {
        System.out.println("Observaciones del formato con id 1");
        Optional<AFormat> objAFormat = this.aFormatRepository.findById(1L);

        if (objAFormat.isPresent()) {
            List<Evaluation> lstEvaluations = objAFormat.get().getEvaluations();
            for (Evaluation objEvaluation : lstEvaluations) {
                System.out.println("Evaluación: " + objEvaluation);
                List<Observation> lstObservations = objEvaluation.getObservations();
                for (Observation objObservation : lstObservations) {
                    System.out.println("Observación: " + objObservation);
                }
            }
        } else {
            System.out.println("No se encontró el formato");
        }
    }

    @Transactional(readOnly = true)
    public void getCommitteeMembers() {
        System.out.println("Committee Members");

        List<Professor> lstProfessors = professorRepository.findAll();

        if (lstProfessors == null || lstProfessors.isEmpty()) {
            System.out.println("No professors found.");
            return;
        }

        System.out.println("---------------------------------------------------------");
        System.out.println("Committee Members");
        System.out.println("---------------------------------------------------------");

        boolean foundCommitteeMember = false;

        for (Professor professor : lstProfessors) {
            List<HistoricalRecord> lstHistoricalRecords = professor.getHistoricalRecord();

            if (lstHistoricalRecords == null || lstHistoricalRecords.isEmpty()) {
                System.out.println("No historical records for professor: " + professor.getName());
                continue;
            }

            for (HistoricalRecord historicalRecord : lstHistoricalRecords) {
                if (historicalRecord.getObjRole() != null &&
                        RoleEnum.COMMITTEE_MEMBER.equals(historicalRecord.getObjRole().getAssignedRole())) {

                    foundCommitteeMember = true;

                    System.out.println("Name: " + historicalRecord.getProfessor().getName());
                    System.out.println("Role: " + historicalRecord.getObjRole().getAssignedRole());
                    System.out.println("Start Date: " + historicalRecord.getStartDate());
                    System.out.println("End Date: " + historicalRecord.getEndDate());
                    System.out.println("---------------------------------------------------------");
                }
            }
        }

        if (!foundCommitteeMember) {
            System.out.println("No committee members found.");
        }
    }

}
