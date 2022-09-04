package com.tat.pojo;

import com.tat.pojo.Category;
import com.tat.pojo.Comment;
import com.tat.pojo.User;
import java.math.BigDecimal;
import java.util.Date;
import javax.annotation.Generated;
import javax.persistence.metamodel.SetAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.7.9.v20210604-rNA", date="2022-09-04T22:03:53")
@StaticMetamodel(Recruitment.class)
public class Recruitment_ { 

    public static volatile SingularAttribute<Recruitment, String> image;
    public static volatile SingularAttribute<Recruitment, Category> categoryRecruitmentId;
    public static volatile SingularAttribute<Recruitment, String> education;
    public static volatile SingularAttribute<Recruitment, Date> createdDate;
    public static volatile SetAttribute<Recruitment, Comment> commentSet;
    public static volatile SingularAttribute<Recruitment, User> userRecruitmentId;
    public static volatile SingularAttribute<Recruitment, BigDecimal> price;
    public static volatile SingularAttribute<Recruitment, String> company;
    public static volatile SingularAttribute<Recruitment, Integer> id;
    public static volatile SingularAttribute<Recruitment, String> title;
    public static volatile SingularAttribute<Recruitment, String> content;

}