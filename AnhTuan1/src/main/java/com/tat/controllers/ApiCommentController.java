/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.tat.controllers;

import com.tat.pojo.Comment;
import com.tat.service.RecruitmentService;
import java.util.List;
import java.util.Map;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 *
 * @author dts
 */
@RestController
@RequestMapping("/api")
public class ApiCommentController {
    @Autowired
    private RecruitmentService recruitmentService;
    
    @GetMapping("/recruitment/{recruitmentId}/comment")
    public ResponseEntity<List<Comment>> getComments(@PathVariable(value = "recruitmentId") int recruitmentId) {
        return new ResponseEntity<>(this.recruitmentService.getComments(recruitmentId),HttpStatus.OK);
    }
    @PostMapping(path = "/recruitment/{recruitmentId}/comment", produces = {
        MediaType.APPLICATION_JSON_VALUE
    })
    public ResponseEntity<Comment> addComment(@RequestBody Map<String, String> params) {
        try{
            String content = params.get("content");
            int recruitmentId = Integer.parseInt(params.get("recruitmentId"));

            Comment c = this.recruitmentService.addComment(content, recruitmentId);

            return new ResponseEntity<>(c, HttpStatus.CREATED);
        } catch (Exception ex){
            ex.printStackTrace();
        }
        
        return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
    }   
    
}
