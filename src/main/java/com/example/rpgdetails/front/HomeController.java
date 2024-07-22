package com.example.rpgdetails.front;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class HomeController {
    
    @GetMapping("/")
    public ModelAndView index(){
        ModelAndView mv = new ModelAndView();
        mv.setViewName("home/index");
        return mv;
    } 

    @GetMapping("/characterCreatehtml")
    public ModelAndView characterCreatehtml(){
        ModelAndView mv = new ModelAndView();
        mv.setViewName("character/characterCreate");
        return mv;
    }
    

    @GetMapping("/characterFindhtml")
    public ModelAndView characterFindhtml(){
        ModelAndView mv = new ModelAndView();
        mv.setViewName("character/characterFind");
        return mv;
    }

}