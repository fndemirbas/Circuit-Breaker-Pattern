package circuit.breaker.instructor.config;

import java.util.Arrays;

import circuit.breaker.instructor.entity.Instructor;
import circuit.breaker.instructor.repository.InstructorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;

import jakarta.annotation.PostConstruct;

@Configuration
public class DataSetup {
    @Autowired
    private InstructorRepository instructorRepository;
    @PostConstruct
    public void setupData() {
        instructorRepository.saveAll(Arrays.asList(
                Instructor.builder().instructorId(1).firstName("Fatma Nur").lastName("Demirbas").email("fnd@cs.edu.tr")
                        .build(),
                Instructor.builder().instructorId(2).firstName("Nisa").lastName("Demirbas").email("hnd@cs.edu.tr")
                        .build(),
                Instructor.builder().instructorId(3).firstName("Emin").lastName("Demirbas").email("med@cs.edu.tr")
                        .build()));
    }
}
