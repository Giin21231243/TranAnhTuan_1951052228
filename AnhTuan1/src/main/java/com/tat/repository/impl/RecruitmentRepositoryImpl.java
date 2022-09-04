/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.tat.repository.impl;

import com.tat.pojo.Category;
import com.tat.pojo.Comment;
import com.tat.pojo.Recruitment;
import com.tat.pojo.User;
import com.tat.repository.RecruitmentRepository;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;
import org.hibernate.Session;
import org.hibernate.query.Query;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.orm.hibernate5.LocalSessionFactoryBean;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

/**
 *
 * @author dts
 */
@Repository
@Transactional
public class RecruitmentRepositoryImpl implements RecruitmentRepository {

    @Autowired
    private LocalSessionFactoryBean sessionFactory;
    @Autowired
    private Environment env;

    @Override
    public List<Recruitment> getRecruitments(Map<String, String> params, int page) {
        Session session = this.sessionFactory.getObject().getCurrentSession();
        CriteriaBuilder b = session.getCriteriaBuilder();
        CriteriaQuery<Recruitment> q = b.createQuery(Recruitment.class);
        Root root = q.from(Recruitment.class);
        q.select(root);
        if (params != null) {
            List<Predicate> predicates = new ArrayList<>();
            String kw = params.get("kw");
            if (kw != null && !kw.isEmpty()) {
                Predicate p = b.like(root.get("name").as(String.class),
                        String.format("%%%s%%", kw));
                predicates.add(p);
            }

            String fp = params.get("fromPrice");
            if (fp != null) {
                Predicate p = b.greaterThanOrEqualTo(root.get("price").as(Long.class),
                        Long.parseLong(fp));
                predicates.add(p);
            }

            String tp = params.get("toPrice");
            if (tp != null) {
                Predicate p = b.lessThanOrEqualTo(root.get("price").as(Long.class),
                        Long.parseLong(tp));
                predicates.add(p);
            }

            String cateId = params.get("cateId");
            if (cateId != null) {
                Predicate p = b.equal(root.get("categoryId"), Integer.parseInt(cateId));
                predicates.add(p);
            }

            q.where(predicates.toArray(new Predicate[]{}));

        }
        Query query = session.createQuery(q);
//        int max = 2;
//        query.setMaxResults(max);
//        query.setFirstResult((page - 1) * max);

        return query.getResultList();
    }

//    @Override
//    public long countRecruitment() {
//        Session session = this.sessionFactory.getObject().getCurrentSession();
//        Query  query = session.createQuery("Select Count(*) From Recruitment");
//        return Long.parseLong(query.getSingleResult().toString()); 
//    }
    @Override
    public boolean addRecruitment(Recruitment r) {
        Session session = this.sessionFactory.getObject().getCurrentSession();
        try {
            session.save(r);
            return true;
        } catch (Exception ex) {
            ex.printStackTrace();
            return false;
        }
    }

    @Override
    public boolean deleteRecruitment(int id) {
        Session session = this.sessionFactory.getObject().getCurrentSession();
        try {
            Recruitment r = session.get(Recruitment.class, id);
            session.delete(r);
            return true;
        } catch (Exception ex) {
            ex.printStackTrace();
            return false;
        }
    }

    @Override
    public List<Object[]> countRecrByCate() {
        Session session = this.sessionFactory.getObject().getCurrentSession();
        
        CriteriaBuilder b = session.getCriteriaBuilder();
        CriteriaQuery<Object[]> q = b.createQuery(Object[].class);

        Root rP = q.from(Recruitment.class);
        Root rC = q.from(Category.class);

        q.where(b.equal(rP.get("categoryId"), rC.get("id")));
        q.multiselect(rC.get("id"), rC.get("name"), b.count(rP.get("id")));
        q.groupBy(rC.get("id"));

        Query query = session.createQuery(q);
        return query.getResultList();
    }

    @Override
    public List<Comment> getComments(int recruitmentId) {
        Session session = this.sessionFactory.getObject().getCurrentSession();
        CriteriaBuilder b = session.getCriteriaBuilder();
        CriteriaQuery<Comment> q = b.createQuery(Comment.class);
        Root root = q.from(Comment.class);
        q.select(root);
        
        q.where(b.equal(root.get("recruitmentCommentId"), recruitmentId));
        
        Query query = session.createQuery(q);
        return query.getResultList();
    }
   

    @Override
    public Recruitment getRecruitmentById(int recruitmentId) {
        Session session = this.sessionFactory.getObject().getCurrentSession();
        return session.get(Recruitment.class, recruitmentId);
    }

    @Override
    public Comment addComment(String content, int recruitmentId) {
        Session session = this.sessionFactory.getObject().getCurrentSession();
        Comment c = new Comment();
        c.setContent(content);
        c.setRecruitmentCommentId(this.getRecruitmentById(recruitmentId));
        c.setUserCommentId(session.get(User.class, 6));
        
        session.save(c);
        
        return c;
    }

}
