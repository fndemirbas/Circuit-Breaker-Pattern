package circuit.breaker.course.config;

import java.util.Arrays;

import circuit.breaker.course.entity.Course;
import circuit.breaker.course.repository.CourseRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;

import jakarta.annotation.PostConstruct;

@Configuration
public class DataSetup {
    @Autowired
    private CourseRepository courseRepository;
    @PostConstruct
    public void setupData() {
        courseRepository.saveAll(Arrays.asList(
                Course.builder().courseId(1).courseCode("BBM101").name("Introduction to Programming I").credit(6).instructorId(1).datesAndTime("Wed : 13:00 - 15:00").build(),
                Course.builder().courseId(2).courseCode("BBM202").name("Algorithms").credit(4).instructorId(2).datesAndTime("Mon : 10:00 - 12:00").build(),
                Course.builder().courseId(3).courseCode("MAT123").name("Mathematics I").credit(6).instructorId(3).datesAndTime("Fri : 09:00 - 11:00").build()));
    }
}
