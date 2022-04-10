package com.example.petclinic_using_spring.controller;

import com.example.petclinic_using_spring.services.OwnerService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class Ownercontroller {

    private OwnerService ownerService;

    public Ownercontroller(OwnerService ownerService) {
        this.ownerService = ownerService;
    }

    @RequestMapping("owners")
    String getOwners(Model model){
        model.addAttribute("owners",ownerService.findAll());
        return "owners/indexpage";
    }
}
