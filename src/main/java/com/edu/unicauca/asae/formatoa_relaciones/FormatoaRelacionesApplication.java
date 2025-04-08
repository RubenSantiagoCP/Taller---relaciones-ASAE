package com.edu.unicauca.asae.formatoa_relaciones;

import java.time.LocalDate;
import java.util.*;

import com.edu.unicauca.asae.formatoa_relaciones.enums.ConceptEnum;
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
		/*professorRepository.deleteAll();
		aFormatRepository.deleteAll();
        createObservation();*/
        /*createPPAFormat();*/

        createtTIAFormat();
        createPPAFormat();
        createObservation();

    }


    @Transactional
    public void createtTIAFormat() {

        //Professor obProfessor = ;

        //Professor savedProf = professorRepository.save(obProfessor);

        Professor savedProfessor =
                Professor.builder()
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

        this.aFormatRepository.save(objTIAFormat);

    }

    @Transactional
    public void createPPAFormat() {

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

        PPAFormat objPPAFormat = PPAFormat.builder()
                .title("Título de la tesis 2")
                .generalObjective("Objetivo general")
                .specificObjective("Objetivo específico")
                .assesorName("assesor")
                .studedt1Name("student1")
                .acceptanceLetterRoute("route")
                .objProfessor(obProfessor)
                .state(objState)
                .build();

        this.aFormatRepository.save(objPPAFormat);
    }
    @Transactional
    public void createObservation() {
        TIAFormat objTIAFormat = tiaFormatRepository.findById(1L)
                .orElseThrow(() -> new RuntimeException("TIAFormat not found"));

        List<Evaluation> lstEvaluations = objTIAFormat.getEvaluations();

        Evaluation evaluation;
        int sizeLstEvaluations = lstEvaluations.size();
        if (sizeLstEvaluations == 0) {
            evaluation = Evaluation.builder()
                    .dateRegisterConcept(LocalDate.now())
                    .concept(ConceptEnum.UNESTABLISHED)
                    .coordinatorName("Nombre del coordinador")
                    .objAFormat(objTIAFormat)
                    .build();
            objTIAFormat.getEvaluations().add(evaluation);
            evaluation = this.evaluationRepository.save(evaluation);


        }else {
            evaluation = lstEvaluations.get(sizeLstEvaluations-1);
            evaluation = this.evaluationRepository.save(evaluation);
            if(!evaluation.getConcept().equals(ConceptEnum.TO_BE_FIXED)) {
                System.out.println("No se pueden agregar más observaciones, el concepto de la evaluación es: "+ evaluation.getConcept().getDescription());
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


        this.observationRepository.save(objObservation);
    }
    @Transactional(readOnly = true)
    public void getAFormatsByProfessor(){
        System.out.println("Formatos Asignados al profesor con id 1");
        List<AFormat> lstAFormats = this.aFormatRepository.findAllByObjProfessor_Id(1L);

        for(AFormat objAFormat : lstAFormats){
            System.out.println("Docente: "+objAFormat.getObjProfessor().getName());
            System.out.println("---- Evaluaciones ----");
            for(Evaluation objEvaluation : objAFormat.getEvaluations()){
                System.out.println("Evaluación: "+objEvaluation);
                System.out.println("---- Observaciones ----");
                for(Observation objObservation : objEvaluation.getObservations()){
                    System.out.println("Observación: "+objObservation);
                }
            }
        }
    }

    @Transactional(readOnly = true)
    public void getObservations(){
        System.out.println("Observaciones del formato con id 1");
        Optional<AFormat> objAFormat = this.aFormatRepository.findById(1L);

        if(objAFormat.isPresent()){
            List<Evaluation> lstEvaluations = objAFormat.get().getEvaluations();
            for(Evaluation objEvaluation : lstEvaluations){
                System.out.println("Evaluación: "+objEvaluation);
                List<Observation> lstObservations = objEvaluation.getObservations();
                for(Observation objObservation : lstObservations){
                    System.out.println("Observación: "+objObservation);
                }
            }
        }else{
            System.out.println("No se encontró el formato");
        }
    }
}
