package com.toantr.restfulapp.controller;

import org.springframework.http.HttpRequest;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.CookieValue;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@RestController
public class MainController
{
    @GetMapping("/")
    public String handleHit(
            @CookieValue(value="hitCounter",defaultValue = "0") Long hitCount,
            HttpServletRequest request, HttpServletResponse response,
            Model model )
    {
        hitCount++;
        Cookie cookie=new Cookie("hitCounter",hitCount.toString());
        response.addCookie(cookie);

        Cookie[] cookies=request.getCookies();
        for (Cookie c:cookies){
            if(c.getName().equals("hitCounter"))
            {
                return c.getValue().toString();
            }
        }
        return "";
    }
}
