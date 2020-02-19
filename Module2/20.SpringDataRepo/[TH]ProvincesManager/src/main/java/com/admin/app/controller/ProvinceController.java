package com.admin.app.controller;

import com.admin.app.model.Province;
import com.admin.app.service.ProvinceService;
import com.sun.org.apache.xpath.internal.operations.Mod;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@Controller
public class ProvinceController
{
    @Autowired
    private ProvinceService provinceService;

    @GetMapping("/provinces")
    public ModelAndView provinces(){
        return new ModelAndView("province/provinces","provinces",provinceService.findAll());
    }
    @GetMapping("/province-add")
    public ModelAndView add(){
        return new ModelAndView("province/add","province",new Province());
    }
    @PostMapping("/province-add")
    public String add(Province province,RedirectAttributes rA){
        provinceService.save(province);
        rA.addFlashAttribute("status","add oke");
        return "redirect:/provinces";
    }
    @GetMapping("/province-edit/{id}")
    public ModelAndView edit(@PathVariable long id){
        return new ModelAndView("province/edit","province",provinceService.findById(id));
    }
    @PostMapping("/province-edit")
    public String edit(Province province, RedirectAttributes redirectAttributes)
    {
        provinceService.save(province);
        redirectAttributes.addFlashAttribute("status","edit oke");
        return "redirect:/provinces";
    }
    @GetMapping("/province-remove/{id}")
    public String remove(@PathVariable long id,RedirectAttributes rA){
        provinceService.remove(id);
        rA.addFlashAttribute("status","delete oke");
        return "redirect:/provinces";
    }
}
