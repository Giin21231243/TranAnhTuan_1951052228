<%-- 
    Document   : recruitment
    Created on : Aug 31, 2022, 3:27:31 AM
    Author     : dts
--%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<h1>QUAN LY VIEC LAM</h1>

<c:url value="/admin/recruitment" var="action" />

<form:form method="post" action="${action}" 
           modelAttribute="recruitment">
    <form >
        <div class="form-group">
            <label for="title" class="form-label">Tên Việc Làm:</label>
            <form:input type="title" id="title" path="title" cssClass="form-control"/>

        </div>
        <div class="form-group">
            <label  for="content" >Mô tả:</label>
            <textarea class="form-control" placeholder="Nhap noi dung " id="contentId"></textarea>
        </div>
        <div class="form-group">
            <label for="price" class="form-label">Lương:</label>
            <form:input type="price" id="price" path="price" cssClass="form-control"/>
        </div>
        <div class="form-group">
            <form:select type="category" id="cate" path="categoryRecruitmentId" cssClass="form-control">
                <c:forEach items="${category}" var="cat">
                    <option value="${cat.id}">
                        ${cate.name}
                    </option>
                </c:forEach>
            </form:select>
            <label  for="cate" >Danh muc:</label>
            <%--<form:input type="category" id="cate" path="categoryRecruitmentId" cssClass="form-control"/>--%>
        </div>
    </form>
</form:form>




