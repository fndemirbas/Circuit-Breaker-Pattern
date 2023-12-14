package circuit.breaker.course.rest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.Optional;

@Service
public class GenericRestClientService {

    @Autowired
    private RestTemplate restTemplate;

    public Optional<ResponseEntity<Object>> get(String url, HttpHeaders httpHeaders) {
        HttpEntity<Object> entity = new HttpEntity<>(httpHeaders);
        ResponseEntity<Object> response = restTemplate.exchange(url, HttpMethod.GET, entity, Object.class);
        return Optional.ofNullable(response);
    }

}
