/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.tat.service;

import com.tat.pojo.Comment;
import com.tat.pojo.Recruitment;
import java.util.List;
import java.util.Map;

/**
 *
 * @author dts
 */
public interface RecruitmentService {
    List<Recruitment> getRecruitments(Map<String, String> params, int page);
//    long countRecruitment();
    boolean addRecruitment(Recruitment r);
    boolean deleteRecruitment(int id);
    List<Object[]> countRecrByCate();
    Recruitment getRecruitmentById(int recruitmentId);
    List<Comment> getComments(int recruitmentId);
    Comment addComment(String content, int recruitmentId);
}
