package com.toantr.webapp.controller;

import com.toantr.webapp.model.User;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@Controller
@SessionAttributes("user")
public class UserController
{
    @ModelAttribute("user")
    public User getUser(){
        return new User();
    }
    @GetMapping("/")
    public String home(@CookieValue(name = "email",defaultValue = "")String email, Model model)
    {
        Cookie cookie=new Cookie("email",email);
        model.addAttribute("cookie",cookie);
        return "home";
    }
    @PostMapping("/")
    public String home(@ModelAttribute("user") User user, Model model,
                       @CookieValue(name = "email",defaultValue = "")String email,
                       HttpServletResponse response, HttpServletRequest request){
        if(user.getEmail().equals("admin@host.com")&&user.getPassword().equals("admin")){
           email=user.getEmail();

           Cookie cookie=new Cookie("email",email);
           cookie.setMaxAge(24*60*60);
           response.addCookie(cookie);

           Cookie[] cookies=request.getCookies();
           for (Cookie c:cookies)
           {
               if(c.getName().equals("email")){
                   model.addAttribute("cookie",c);
                   break;
               }else{
                   c.setValue("");
                   model.addAttribute("cookie",c);
                   break;
               }
           }
           model.addAttribute("message","Login oke");
        }else{
            user.setEmail("");
            Cookie cookie=new Cookie("email",email);
            model.addAttribute("cookie",cookie);
            model.addAttribute("message","Login fail");
        }
        return "home";
    }
}
