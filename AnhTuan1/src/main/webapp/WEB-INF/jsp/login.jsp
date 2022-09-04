<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<c:url value="/login" var="action"/>

<div class="alert alert-danger">
    <c:if test="${param.error != null}">
        <spring:message code="user.login.error1" />
    </c:if>
    <c:if test="${param.accessDenied != null}">
        <div class="alert alert-danger">
            Bạn không có quyền truy cập!!!
        </div>
    </c:if>
    <h1 class="text-center alert-danger">ĐĂNG NHẬP</h1>
</div> 
<c:url value="/login" var="action" />

<form action="${action}" method="post" >
    <div class="form-group ">
        <label for="username">Tài khoản</label>
        <input type="text" name="username" id="usernameId"
               class="form-control form-control-lg" />
    </div>
    <div class="form-group ">
        <label for="password"> Mật khẩu </label>
        <input id="password" name="password" class="form-control f form-control-lg" style="margin-bottom: 10px" type="password" />
    </div>
    <div class="form-group">
        <input type="submit"
               value="ĐĂNG NHẬP" class="btn btn-primary"/>
    </div>

</form>


