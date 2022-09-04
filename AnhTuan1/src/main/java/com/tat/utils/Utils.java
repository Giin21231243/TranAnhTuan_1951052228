/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.tat.utils;

import com.tat.pojo.Cart;
import java.util.Map;

/**
 *
 * @author dts
 */
public class Utils {
    public static int countCart(Map<Integer, Cart> cart) {
        int q =0;
        if(cart != null)
            for(Cart c: cart.values())
                q += c.getQuatity();

        return q;
    }
    public static Long sumAmount(Map<Integer, Cart> cart){
        Long s = 0l;
        if(cart != null)
            for(Cart c: cart.values())
                s += c.getQuatity() *c.getPrice();

        
        return s;  
    }
}

