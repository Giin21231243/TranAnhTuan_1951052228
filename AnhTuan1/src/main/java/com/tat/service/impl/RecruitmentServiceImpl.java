/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.tat.service.impl;

import com.tat.pojo.Comment;
import com.tat.pojo.Recruitment;
import com.tat.repository.RecruitmentRepository;
import com.tat.service.RecruitmentService;
import java.util.List;
import java.util.Map;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author dts
 */
@Service
public class RecruitmentServiceImpl implements RecruitmentService {
    @Autowired
    private RecruitmentRepository recruitmentRepository;

    @Override
    public List<Recruitment> getRecruitments(Map<String, String> params, int page) {
        return this.recruitmentRepository.getRecruitments(params, page);
    }

//    @Override
//    public long countRecruitment() {
//        return  this.recruitmentRepository.countRecruitment();
//    }

    @Override
    public boolean addRecruitment(Recruitment r) {
        r.setImage("https://res.cloudinary.com/dxxwcby8l/image/upload/v1647248652/dkeolz3ghc0eino87iec.jpg");
        return  this.recruitmentRepository.addRecruitment(r);
    }
    

    @Override
    public boolean deleteRecruitment(int id) {
        return this.recruitmentRepository.deleteRecruitment(id);
    }

    @Override
    public List<Object[]> countRecrByCate() {
        return this.recruitmentRepository.countRecrByCate();
    }

    @Override
    public Recruitment getRecruitmentById(int recruitmentId) {
        return this.recruitmentRepository.getRecruitmentById(recruitmentId);
    }

    
    @Override
    public Comment addComment(String content, int recruitmentId) {
        return this.recruitmentRepository.addComment(content, recruitmentId);
    }
    
    @Override
    public List<Comment> getComments(int recruitmentId) {
        return this.recruitmentRepository.getComments(recruitmentId);
    }
    

    
}
