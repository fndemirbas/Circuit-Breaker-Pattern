package circuit.breaker.instructor.service;

import circuit.breaker.instructor.entity.Instructor;
import circuit.breaker.instructor.repository.InstructorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class InstructorService {
    @Autowired
    private InstructorRepository instructorRepository;
    public Instructor getInstructorByInstructorId(Integer instructorId) {
        return instructorRepository.findByInstructorId(instructorId)
                .orElseThrow(() -> new RuntimeException("Instructor Not Found: " + instructorId));
    }
}
