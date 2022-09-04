/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.tat.repository.impl;

import com.tat.pojo.User;
import com.tat.repository.UserRepository;
import java.util.List;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.hibernate5.LocalSessionFactoryBean;
import org.springframework.stereotype.Repository;

/**
 *
 * @author dts
 */
@Repository
public class UserRepositoryImp implements UserRepository {
    @Autowired
    private LocalSessionFactoryBean sessionFactory;

    @Override
    public boolean addUser(User user) {
        Session session = this.sessionFactory.getObject().getCurrentSession();
        try{
            session.save(user);
            return true;
        }catch(HibernateException ex){
            System.err.println(ex.getMessage());
        }
        
        return false;
    }

    @Override
    public List<User> getUsers(String username) {
        Session session = this.sessionFactory.getObject().getCurrentSession();
        CriteriaBuilder b = session.getCriteriaBuilder();
        CriteriaQuery<User> q = b.createQuery(User.class);
        Root root = q.from(User.class);
        q.select(root);
        
        if(!username.isEmpty()){
            Predicate p = b.equal(root.get("username").as(String.class), username.trim());
            q = q.where(p);
        }

        Query query = session.createQuery(q);
        return query.getResultList();
    }

    @Override
    public User getUserById(int id) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }


}
