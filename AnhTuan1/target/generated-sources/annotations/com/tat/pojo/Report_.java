package com.tat.pojo;

import com.tat.pojo.User;
import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.7.9.v20210604-rNA", date="2022-09-04T22:03:53")
@StaticMetamodel(Report.class)
public class Report_ { 

    public static volatile SingularAttribute<Report, Integer> id;
    public static volatile SingularAttribute<Report, User> userReportId;
    public static volatile SingularAttribute<Report, String> content;

}