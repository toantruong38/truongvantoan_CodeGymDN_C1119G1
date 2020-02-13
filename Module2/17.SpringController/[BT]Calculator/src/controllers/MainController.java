package controllers;

import model.CalculationModel;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class MainController
{
    @GetMapping("/home")
    public ModelAndView home(){
        return new ModelAndView("home","calculation",new CalculationModel());
    }

    @PostMapping("/home")
    public ModelAndView executeCommand(@ModelAttribute("calculation")CalculationModel calculation
            ,@RequestParam("command")String command){
        ModelAndView mav=new ModelAndView("home");
        try
        {
            mav.addObject("result",calculation.calculate(command));
        }catch (Exception e){
            System.out.println(e.getMessage());
            mav.addObject("result",null);
            mav.addObject("errorMessage",e.getMessage());
        }

        return mav;
    }
}
