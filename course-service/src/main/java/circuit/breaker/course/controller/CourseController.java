package circuit.breaker.course.controller;

import circuit.breaker.course.model.Type;
import circuit.breaker.course.service.CourseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/courses")
public class CourseController {
    @Autowired
    private CourseService courseService;
    @GetMapping
    public Type getCourseInfo(@RequestParam("courseCode") String courseCode) {
        return courseService.getCourseByCourseCode(courseCode);
    }
}
