package controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.HashMap;
import java.util.Map;

@Controller
public class DictionaryController
{
    @GetMapping("/dictionary")
    public String getForm()
    {
        return "dictionary";
    }

    @PostMapping("/dictionary")
    public String displayResult(@RequestParam String search, Model model)
    {
        Map<String, String> dictionary = new HashMap<>();
        dictionary.put("hello", "xin chao");
        dictionary.put("computer", "may tinh");
        dictionary.put("phone", "dien thoai");
        dictionary.put("fan", "cai quat");
        dictionary.put("love", "yeu");
        dictionary.put("hate", "ghet");

        String result = dictionary.get(search);
        if (result != null) model.addAttribute("result", result);
        else model.addAttribute("result", "404-Not found");

        return "dictionary";
    }
}
