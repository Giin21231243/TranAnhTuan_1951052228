package com.tat.pojo;

import com.tat.pojo.Recruitment;
import com.tat.pojo.User;
import java.util.Date;
import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.7.9.v20210604-rNA", date="2022-09-04T22:03:53")
@StaticMetamodel(Comment.class)
public class Comment_ { 

    public static volatile SingularAttribute<Comment, Date> createdDate;
    public static volatile SingularAttribute<Comment, Integer> id;
    public static volatile SingularAttribute<Comment, User> userCommentId;
    public static volatile SingularAttribute<Comment, Recruitment> recruitmentCommentId;
    public static volatile SingularAttribute<Comment, String> content;

}