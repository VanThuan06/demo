package com.test.demoApp.Service;

import io.github.resilience4j.circuitbreaker.annotation.CircuitBreaker;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
public class DemoAppService {

    private static final String DEMOAPP_SERVICE = "demoAppService";
    @Autowired
    private RestTemplate restTemplate;



    @CircuitBreaker(name = DEMOAPP_SERVICE, fallbackMethod = "zeroNumber")
    public ResponseEntity<Integer> getRandomNumber() {
        int number = this.restTemplate.getForObject("http://numberservice/ramdomNumber", Integer.class);
        return new ResponseEntity<Integer>(number, HttpStatus.OK);
    }

    public ResponseEntity<Integer> zeroNumber(Exception e) {
        return new ResponseEntity<Integer>(1, HttpStatus.OK);
    }

}
