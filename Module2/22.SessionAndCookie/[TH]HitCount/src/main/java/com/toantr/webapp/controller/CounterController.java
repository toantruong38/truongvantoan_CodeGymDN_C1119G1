package com.toantr.webapp.controller;

import com.toantr.webapp.model.MyCounter;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.SessionAttributes;

@Controller
@SessionAttributes("counter")
public class CounterController
{
    @ModelAttribute("counter")
    public MyCounter getCounter(){
        return new MyCounter();
    }
    @GetMapping("/")
    public String home(@ModelAttribute("counter")MyCounter counter){
        counter.increment();
        return "home";
    }
}
