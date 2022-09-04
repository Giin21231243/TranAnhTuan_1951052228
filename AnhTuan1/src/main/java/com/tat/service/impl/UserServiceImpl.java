/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.tat.service.impl;

import com.cloudinary.Cloudinary;
import com.cloudinary.utils.ObjectUtils;
import com.tat.pojo.User;
import com.tat.repository.UserRepository;
import com.tat.service.UserService;
import java.io.IOException;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 *
 * @author dts
 */
@Service("userDetailsService")
public class UserServiceImpl implements UserService {

    @Autowired
    private UserRepository userRepository;
    @Autowired
    private BCryptPasswordEncoder bCryptPasswordEncoder;
    
    @Autowired
    private Cloudinary cloudinary;

    @Override
    @Transactional
    public boolean addUser(User user) {
        try { 
            String pass = user.getPassword();
            user.setPassword(bCryptPasswordEncoder.encode(pass));
            user.setUserRole(User.USER);
        
        
            Map r = this.cloudinary.uploader().upload(user.getFile().getBytes(),
                    ObjectUtils.asMap("resource", "auto"));
            user.setAvatar((String) r.get("secure_url"));
            
            return this.userRepository.addUser(user);
        } catch (IOException ex) {
            ex.printStackTrace();
        }
        
        return false;
    }

    @Override
    @Transactional(readOnly = true)
    public UserDetails loadUserByUsername(String username)
            throws UsernameNotFoundException {
        List<User> users = userRepository.getUsers(username);
        if (users.isEmpty()) {
            throw new UsernameNotFoundException("Tài khoản không tồn tại!");
        }
        User u = users.get(0);
        Set<GrantedAuthority> authorities = new HashSet<>();
        authorities.add(new SimpleGrantedAuthority(u.getUserRole()));
        return new org.springframework.security.core.userdetails.User(
                u.getUsername(), u.getPassword(), authorities);
    }

    @Override
    public List<User> getUsers(String username) {
        return this.userRepository.getUsers(username);
    }

    @Override
    public User getUserById(int id) {
        return this.userRepository.getUserById(id);
    }

}
