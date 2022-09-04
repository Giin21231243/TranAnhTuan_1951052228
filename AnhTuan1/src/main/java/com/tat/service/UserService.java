/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.tat.service;

/**
 *
 * @author dts
 */
import com.tat.pojo.User;
import java.util.List;
import org.springframework.security.core.userdetails.UserDetailsService;

public interface UserService extends UserDetailsService {
    User getUserById(int id);
    boolean addUser(User user);

    List<User> getUsers(String username);
}
