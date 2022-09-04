/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.tat.controllers;

import com.tat.pojo.Recruitment;
import com.tat.service.RecruitmentService;
import com.cloudinary.Cloudinary;
import com.cloudinary.utils.ObjectUtils;
import com.tat.pojo.User;
import java.io.IOException;
import javax.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

/**
 *
 * @author dts
 */
@Controller
public class ApiRecruitmentController {
    @Autowired
    private Cloudinary cloudinary;
    
    @Autowired
    private RecruitmentService recruitmentService;
        
    @GetMapping("/admin/recruitment")
    public String addRecruitment(Model model, HttpSession session){
        User currentUser = (User) session.getAttribute("currentUser");
        
        if(currentUser == null)
            return "redirect:/require-login";
        model.addAttribute("recruitment", new Recruitment());
        
        return "recruitment";
    }
    
    
    
//    @PostMapping("/admin/recruitment")
//    public String add(Model model ,@ModelAttribute(value = "recruitmen")  Recruitment recruitment,HttpSession session ) {
//        String err = "";
//        User currentUser = (User) session.getAttribute("currentUser");
//        
//        if(!result.hasErrors()){
//            if(this.recruitmentService.addRecruitment(recruitment)==true)
//                return "redirect:/";
//        }
//        err="Loi date-time. Hay Nhap lai!";
//        model.addAttribute("err", err);
//        return "addRecruitment";
//    }
}
