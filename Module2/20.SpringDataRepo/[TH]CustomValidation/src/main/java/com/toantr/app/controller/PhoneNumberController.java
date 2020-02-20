package com.toantr.app.controller;

import com.toantr.app.model.PhoneNumber;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import javax.validation.Valid;

@Controller
public class PhoneNumberController
{
    @GetMapping("/")
    public String home(Model model){
        model.addAttribute("phoneNumber",new PhoneNumber());
        return "home";
    }
    @PostMapping("/")
    public String home(@Valid PhoneNumber phoneNumber, BindingResult result,Model model){
        System.out.println(phoneNumber.getNumber());
        new PhoneNumber().validate(phoneNumber,result);
        //System.out.println(result.getFieldErrors("number").get(0).getCode());
        if(result.hasFieldErrors("number")){
            for(FieldError fieldError: result.getFieldErrors("number")){
                System.out.println(fieldError.toString());
            }
        }
        return "home";
    }
}
