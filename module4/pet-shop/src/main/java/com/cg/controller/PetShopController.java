package com.cg.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;


@Controller
@RequestMapping("/pets")
public class PetShopController {

    @GetMapping("")
    public ModelAndView showHome(){
        return new ModelAndView("/pet_shop/index");
    }
    @GetMapping("/about")
    public ModelAndView showAbout(){
        return new ModelAndView("/pet_shop/about");
    }
}
