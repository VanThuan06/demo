package com.test.numberService.Controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.concurrent.ThreadLocalRandom;

@RestController
public class NumberServiceController {
    @GetMapping("ramdomNumber")
    public int ramdomNumber() {
        return ThreadLocalRandom.current().nextInt(1, 100);
    }
}
