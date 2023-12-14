package circuit.breaker.course.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class InstructorDTO {

    private Integer instructorId;
    private String firstName;
    private String lastName;
    private String email;

}

