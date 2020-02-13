package controllers;

import model.Login;
import model.User;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;
import userdao.UserDao;

@Controller
@RequestMapping("/login")
public class UserController
{
    @GetMapping("/form")
    public ModelAndView getForm()
    {
        return new ModelAndView("loginform", "login", new Login());
    }

    @PostMapping("/status")
    public ModelAndView status(@ModelAttribute("login") Login login)
    {
        ModelAndView mav = new ModelAndView("status");
        User sessionU = UserDao.checkLogin(login);
        if (sessionU != null)
        {
            mav.addObject("status", "good");
            mav.addObject("user", sessionU);
        } else
        {
            mav.addObject("status", "fail");
        }

        return mav;
    }
}
