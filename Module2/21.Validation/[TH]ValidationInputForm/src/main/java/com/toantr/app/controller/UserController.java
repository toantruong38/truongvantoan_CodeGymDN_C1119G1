package com.toantr.app.controller;

import com.toantr.app.model.User;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class UserController
{
    @GetMapping("/")
    public String home(Model model)
    {
        model.addAttribute("user",new User());
        return "login";
    }
    @PostMapping("/")
    public String home(@Validated User user, BindingResult bindingResult){
        if (bindingResult.hasFieldErrors()) {
            return "login";
        }
        return "oke";
    }
}
