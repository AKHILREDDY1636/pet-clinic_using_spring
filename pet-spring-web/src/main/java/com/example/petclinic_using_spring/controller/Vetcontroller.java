package com.example.petclinic_using_spring.controller;

import com.example.petclinic_using_spring.services.VetService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class Vetcontroller {

    private VetService vetService;

    public Vetcontroller(VetService vetService) {
        this.vetService = vetService;
    }

    @RequestMapping("vets")
    String getVets(Model model){
        model.addAttribute("vets",vetService.findAll());
        return "vets/indexpage";
    }

}
