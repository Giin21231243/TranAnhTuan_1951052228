/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.tat.controllers;

import com.tat.pojo.Cart;
import com.tat.utils.Utils;
import java.util.Map;
import javax.servlet.http.HttpSession;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

/**
 *
 * @author dts
 */
@Controller
public class CartController {
    @GetMapping("/cart")
    public String cart(Model model, HttpSession session){
        Map<Integer, Cart> cart = (Map<Integer, Cart>) session.getAttribute("cart");
        if(cart != null)
            model.addAttribute("cart", cart.values());
        else
            model.addAttribute("cart",null);
        
        
        model.addAttribute("amount", Utils.sumAmount(cart));
        
        return "cart";
    }
}
