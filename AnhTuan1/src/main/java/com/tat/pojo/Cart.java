/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.tat.pojo;

/**
 *
 * @author dts
 */
public class Cart {
    private int recruitmentId;
    private String recruitmentName;
    private Long price;
    private int quatity;

    /**
     * @return the recruitmentId
     */
    public int getRecruitmentId() {
        return recruitmentId;
    }

    /**
     * @param recruitmentId the recruitmentId to set
     */
    public void setRecruitmentId(int recruitmentId) {
        this.recruitmentId = recruitmentId;
    }

    /**
     * @return the price
     */
    public Long getPrice() {
        return price;
    }

    /**
     * @param price the price to set
     */
    public void setPrice(Long price) {
        this.price = price;
    }

    /**
     * @return the quatity
     */
    public int getQuatity() {
        return quatity;
    }

    /**
     * @param quatity the quatity to set
     */
    public void setQuatity(int quatity) {
        this.quatity = quatity;
    }

    /**
     * @return the recruitmentName
     */
    public String getRecruitmentName() {
        return recruitmentName;
    }

    /**
     * @param recruitmentName the recruitmentName to set
     */
    public void setRecruitmentName(String recruitmentName) {
        this.recruitmentName = recruitmentName;
    }
}
