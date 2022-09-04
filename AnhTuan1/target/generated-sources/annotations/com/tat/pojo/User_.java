package com.tat.pojo;

import com.tat.pojo.Comment;
import com.tat.pojo.Rating;
import com.tat.pojo.Recruitment;
import com.tat.pojo.Report;
import java.util.Date;
import javax.annotation.Generated;
import javax.persistence.metamodel.CollectionAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.7.9.v20210604-rNA", date="2022-09-04T22:03:53")
@StaticMetamodel(User.class)
public class User_ { 

    public static volatile CollectionAttribute<User, Comment> commentCollection;
    public static volatile CollectionAttribute<User, Recruitment> recruitmentCollection;
    public static volatile SingularAttribute<User, Integer> active;
    public static volatile SingularAttribute<User, String> avatar;
    public static volatile SingularAttribute<User, Date> creationDate;
    public static volatile CollectionAttribute<User, Rating> ratingCollection;
    public static volatile SingularAttribute<User, Integer> idUser;
    public static volatile SingularAttribute<User, String> password;
    public static volatile SingularAttribute<User, byte[]> cv;
    public static volatile CollectionAttribute<User, Report> reportCollection;
    public static volatile SingularAttribute<User, String> name;
    public static volatile SingularAttribute<User, String> userRole;
    public static volatile SingularAttribute<User, String> email;
    public static volatile SingularAttribute<User, String> username;

}