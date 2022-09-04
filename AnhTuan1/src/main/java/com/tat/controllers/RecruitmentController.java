/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.tat.controllers;

import com.tat.service.RecruitmentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

/**
 *
 * @author dts
 */
@Controller
public class RecruitmentController {
    @Autowired
    private RecruitmentService recruitmentService;
//    @Autowired
//    private CommentService commentService;
    
    @GetMapping("/recruitment/{recruitmentId}")
    public String detail(Model model, @PathVariable(value = "recruitmentId") int recruitmentId){
        model.addAttribute("recruitment", this.recruitmentService.getRecruitmentById(recruitmentId));
        
        return "recruitment-detail";
    }
}
