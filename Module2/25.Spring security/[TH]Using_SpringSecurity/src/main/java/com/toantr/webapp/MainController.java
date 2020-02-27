package com.toantr.webapp;

import org.springframework.security.core.context.SecurityContext;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

import java.security.Principal;

@Controller
public class MainController
{
    @GetMapping("/")
    public String handleIndex(){
        return "index";
    }
    @GetMapping("/user")
    public String handleUser(Principal principal){
        System.out.println(principal.getName());
        return "user";
    }
    @GetMapping("/admin")
    public String handleAdmin(){
        SecurityContext context= SecurityContextHolder.getContext(); //TODO testcase
        System.out.println(context.getAuthentication().getName());
        return "admin";
    }
}
