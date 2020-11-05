package org.cap.apps.freelancerapp.adminms.controllers;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RequestMapping("/admin")
@RestController
public class AdminController {

    @GetMapping("/hello")
    public String greetHello(){
        return "hello from admin";
    }

    @GetMapping("/hi")
    public String greetHi(){
        return "hi from admin";
    }

}
