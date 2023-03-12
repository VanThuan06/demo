package com.test.demoApp.Controller;

import com.test.demoApp.Service.DemoAppService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class DemoAppController {
    @Autowired
    private DemoAppService demoAppService;

    @GetMapping("/printNumber")
    public String printNumber(){
        return "Ramdom Number : "  + demoAppService.getRandomNumber().getBody();
    }
}
