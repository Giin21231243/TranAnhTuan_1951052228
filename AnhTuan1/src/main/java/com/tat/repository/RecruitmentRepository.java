/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.tat.repository;

import com.tat.pojo.Comment;
import com.tat.pojo.Recruitment;
import java.util.List;
import java.util.Map;

/**
 *
 * @author dts
 */
public interface RecruitmentRepository {
    List<Recruitment> getRecruitments(Map<String, String> params, int page); 
//    int countRecruitment();
    boolean addRecruitment(Recruitment r);
    boolean deleteRecruitment(int id);
    List<Object[]> countRecrByCate();
    List<Comment> getComments(int recruitmentId);
    Recruitment getRecruitmentById(int recruitmentId);
    Comment addComment(String content, int recruitmentId);
}
