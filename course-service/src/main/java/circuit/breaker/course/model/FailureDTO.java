package circuit.breaker.course.model;

import lombok.Data;

@Data
public class FailureDTO implements Type {
    private final String errorMessage;
}
