package com.example.petclinic_using_spring.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class Indexcontroller {

    @RequestMapping({"","/","index"})
    String getIndex(Model model){
        System.out.println("entered indexcontroller");
        //model.addAttribute("welcome",welcome);
        return "indexpage";
    }
}
