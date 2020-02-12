package controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class CurrencyConverter
{
    @GetMapping("/converter")
    public String converter()
    {
        return "converter";
    }

    @PostMapping(value = "/result")
    public String result(@RequestParam double usd, double rate, Model model)
    {
        model.addAttribute("usd", usd);
        model.addAttribute("rate", rate);
        model.addAttribute("vnd", usd * rate);
        return "display";
    }
}

//@Controller
//class DisplayResult{
//    @RequestMapping(value = "/result",method = RequestMethod.POST)
//    public String result(@RequestParam double usd,double rate, Model model){
//        model.addAttribute("usd",usd);
//        model.addAttribute("rate",rate);
//        model.addAttribute("vnd",usd*rate);
//        return "display";
//    }
//}
