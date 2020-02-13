package controllers;

import condimentdao.ListCondiments;
import entity.Condiment;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import java.util.ArrayList;

@Controller
public class SandwichCondimentsControllers
{
    ArrayList<Condiment> condiments= ListCondiments.getCondiments();
    @GetMapping("/home")
    public ModelAndView getSelection()
    {
        System.out.println("home"+condiments.get(0));
        return new ModelAndView("home","condiments",condiments);
    }

    @PostMapping("/home/listed")
    public ModelAndView getListed(@RequestParam(value = "condiments",required =true) String[] values)
    {
        return new ModelAndView("selected","values",values);
    }
}
