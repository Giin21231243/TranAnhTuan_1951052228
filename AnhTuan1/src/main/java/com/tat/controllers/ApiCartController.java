/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.tat.controllers;

import com.tat.pojo.Cart;
import com.tat.utils.Utils;
import java.util.HashMap;
import java.util.Map;
import javax.servlet.http.HttpSession;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

/**
 *
 * @author dts
 */
@RestController
public class ApiCartController {
    @PostMapping("api/cart")
    public int addToCart(@RequestBody Cart params, HttpSession session){
        Map<Integer, Cart> cart = (Map<Integer, Cart>) session.getAttribute("cart");
        if (cart == null)
            cart = new HashMap<>();
        int recruitmentId = params.getRecruitmentId();
        if (cart.containsKey(recruitmentId) == true){
            Cart c = cart.get(recruitmentId);
            c.setQuatity(c.getQuatity()+1);
        }else{
            cart.put(recruitmentId, params);
        }
        session.setAttribute("cart", cart);
        
        return Utils.countCart(cart);
    }
}
