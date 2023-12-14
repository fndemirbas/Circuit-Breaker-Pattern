package circuit.breaker.instructor.controller;

import circuit.breaker.instructor.entity.Instructor;
import circuit.breaker.instructor.service.InstructorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("instructors")
public class InstructorController {
    @Autowired
    private InstructorService instructorService;
    @GetMapping("/{instructorId}")
    public Instructor getInstructorByInstructorId(@PathVariable("instructorId") Integer instructorId) {
        return instructorService.getInstructorByInstructorId(instructorId);
    }
}
