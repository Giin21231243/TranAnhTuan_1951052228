/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.tat.controllers;

import com.tat.pojo.User;
import com.tat.service.UserService;
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
public class AdminController {
    @Autowired
    private UserService userDetailsService;
    @GetMapping("/login")
    public String login(){
        return "login";
    }
    @GetMapping("/register")
    public String registerView(Model model){
        model.addAttribute("user", new User());
        return "register";
    }
    @PostMapping("/register")
    public String register(Model model, @ModelAttribute(value = "user") User user){
        
        if(user.getPassword().isEmpty()
            || !user.getPassword().equals(user.getConfirmPassword()))
            model.addAttribute("errMsg", "Mat khau khong khop ");
        else{
            if(this.userDetailsService.addUser(user)== true){
                return "redirect:/login";
            }
                model.addAttribute("errMsg", "Loi say ra xin vui long quay lai sau ");
        }
        return "register";
    }
}
