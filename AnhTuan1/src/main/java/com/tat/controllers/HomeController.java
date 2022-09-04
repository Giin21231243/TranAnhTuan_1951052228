/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.tat.controllers;

import com.tat.service.CategoryService;
import com.tat.service.RecruitmentService;
import java.util.Map;
import javax.servlet.http.HttpSession;
import org.graalvm.compiler.word.Word;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

/**
 *
 * @author dts
 */
@Controller
@ControllerAdvice
public class HomeController {

    @Autowired
    private CategoryService categoryService;
    @Autowired
    private RecruitmentService recruitmentService;

    @RequestMapping("/")
    public String index(Model model,
            @RequestParam Map<String, String> params, 
            HttpSession session) {
        int page = Integer.parseInt(params.getOrDefault("page", "1"));
//        model.addAttribute("category", this.categoryService.getCategories());
        model.addAttribute("recruitments", this.recruitmentService.getRecruitments(params, page));
//        model.addAttribute("counter", this.recruitmentService.countRecruitment());
       

        return "index";
    }
    @ModelAttribute
    public void commonAttrs(Model model){
        model.addAttribute("category", this.categoryService.getCategories());
    }
            
    @InitBinder
    public void initBinder(WebDataBinder binder) {
        binder.setAllowedFields("word", "description");
    }

}
