package com.tat.pojo;

import com.tat.pojo.User;
import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.7.9.v20210604-rNA", date="2022-09-04T22:03:53")
@StaticMetamodel(Rating.class)
public class Rating_ { 

    public static volatile SingularAttribute<Rating, User> userRatingId;
    public static volatile SingularAttribute<Rating, Integer> id;
    public static volatile SingularAttribute<Rating, String> content;

}