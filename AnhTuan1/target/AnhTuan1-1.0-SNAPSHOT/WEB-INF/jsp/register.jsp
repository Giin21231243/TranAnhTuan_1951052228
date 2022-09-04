<%-- 
    Document   : register
    Created on : Aug 19, 2022, 9:11:40 PM
    Author     : dts
--%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@taglib prefix="from" uri="http://www.springframework.org/tags/form" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<h1 class="text-center alert-danger">ĐĂNG KÝ</h1>
<c:if test="${errMsg != null}">
    <div class="alert alert-danger">
        ${errMsg}
    </div>
</c:if>
<c:url value="/register" var="action" />

<from:form action="${action}" method="post" 
           enctype="mutipart/form-data" modelAttribute="user">
    <div class="form-group ">
        <label for="name">
            Name
        </label>
        <from:input type="text" path="name" id="name"
               class="form-control form-control-lg"/>
    </div>
    <div class="form-group ">
        <label for="email">
            Email
        </label>
        <from:input type="text" path="email" id="email"
               class="form-control form-control-lg"/>
    </div><!-- comment -->
    
    <div class="form-group ">
        <label for="username">
            Username
        </label>
        <from:input type="text" path="username" id="usernameId"
               class="form-control form-control-lg"/>
    </div>
    <div class="form-group ">
        <label for="password">
            Password
        </label>
        <from:input type="password" path="password" id="password"
               class="form-control form-control-lg"/>
    </div>
    <div class="form-group " >
        <label for="confirm-password">
            Confirm Password
        </label>
        <from:input type="password" path="confirmPassword" id="confirm-password"
               class="form-control form-control-lg" style="margin-bottom: 10px"/>
    </div>
    <div class="form-group " >
        <label for="avatar">
            Avatar
        </label>
        <from:input type="file" path="file" id="avatar"
               class="form-control form-control-lg" style="margin-bottom: 10px"/>
    </div>
    <div class="form-group" >
        <input type="submit" "
               value="ĐĂNG NHẬP" class="btn btn-primary"/>
    </div>
</from:form>
