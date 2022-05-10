package com.example.petclinic_using_spring.controller;


import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class Indexcontroller {
    @Value("${welcome}")
    String welcome;
    @RequestMapping({"","/","index"})
    String getIndex(Model model){
        model.addAttribute("welcome",welcome);
        return "indexpage";
    }
}
