package circuit.breaker.course.service;

import circuit.breaker.course.entity.Course;
import circuit.breaker.course.model.CourseInfoResponse;
import circuit.breaker.course.model.InstructorDTO;
import circuit.breaker.course.model.Type;
import circuit.breaker.course.repository.CourseRepository;
import circuit.breaker.course.rest.GenericRestClientService;
import com.fasterxml.jackson.databind.ObjectMapper;
import io.github.resilience4j.circuitbreaker.annotation.CircuitBreaker;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.*;
import org.springframework.stereotype.Service;
import circuit.breaker.course.model.FailureDTO;
import java.util.Optional;

@Service
public class CourseService{

    @Autowired
    private CourseRepository courseRepository;
    @Autowired
    private GenericRestClientService genericRestClient;
    @Autowired
    private ObjectMapper objectMapper;

    private static final String SERVICE_NAME = "order-service";
    private static final String INSTRUCTOR_SERVICE_URL = "http://localhost:9090/instructors/";

    @CircuitBreaker(name = SERVICE_NAME, fallbackMethod = "fallbackMethod")
    public Type getCourseByCourseCode(String courseCode) {
        Course course = courseRepository.findByCourseCode(courseCode).orElseThrow(() -> new RuntimeException("Course Not Found: " + courseCode));
        CourseInfoResponse courseInfoResponse = objectMapper.convertValue(course, CourseInfoResponse.class);
        Optional<ResponseEntity<Object>> response = genericRestClient.get((INSTRUCTOR_SERVICE_URL + course.getCourseId()), getHttpHeaders());
        if (response.isPresent()) {
            InstructorDTO instructorDTO = objectMapper.convertValue(response.get().getBody(), InstructorDTO.class);
            courseInfoResponse.setInstructor(instructorDTO);
        }
        return courseInfoResponse;
    }

    private HttpHeaders getHttpHeaders() {
        HttpHeaders httpHeaders = new HttpHeaders();
        httpHeaders.setContentType(MediaType.APPLICATION_JSON);
        return httpHeaders;
    }

    private Type fallbackMethod(Exception e) {
        return new FailureDTO("Instructor service is not responding properly!");
    }
}
