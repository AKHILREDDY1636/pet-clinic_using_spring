package com.example.petclinic_using_spring.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class Petcontroller {

    @RequestMapping("pets")
    String getPets(){
        return "pets/indexpage";
    }
}
