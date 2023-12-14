package circuit.breaker.course.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class CourseInfoResponse implements Type{

    private String courseCode;
    private String name;
    private Integer credit;
    private InstructorDTO instructor;
    private String datesAndTime;

}
