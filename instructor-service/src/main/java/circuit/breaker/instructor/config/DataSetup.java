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
                Instructor.builder().instructorId(1).firstName("Ali").lastName("Seydi").email("as@cs.edu.tr")
                        .build(),
                Instructor.builder().instructorId(2).firstName("Nazlı").lastName("İkizler").email("ni@cs.edu.tr")
                        .build(),
                Instructor.builder().instructorId(3).firstName("Burak").lastName("Can").email("bc@cs.edu.tr")
                        .build()));
    }
}
