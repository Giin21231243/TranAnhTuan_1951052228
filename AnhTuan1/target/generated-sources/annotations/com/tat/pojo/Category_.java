package com.tat.pojo;

import com.tat.pojo.Recruitment;
import javax.annotation.Generated;
import javax.persistence.metamodel.CollectionAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.7.9.v20210604-rNA", date="2022-09-04T22:03:53")
@StaticMetamodel(Category.class)
public class Category_ { 

    public static volatile SingularAttribute<Category, String> name;
    public static volatile CollectionAttribute<Category, Recruitment> recruitmentCollection;
    public static volatile SingularAttribute<Category, String> description;
    public static volatile SingularAttribute<Category, Integer> id;

}