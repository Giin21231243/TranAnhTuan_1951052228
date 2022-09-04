<%-- 
    Document   : index.jsp
    Created on : Aug 3, 2022, 11:28:38 PM
    Author     : dts
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %> 
<link href="<c:url value="/css/style.css" />" rel="stylesheet"/> 

<h1 class="text-center text-danger">Danh Sach Tuyen Dung</h1>



<div class="row" >
    <c:forEach var="r" items="${recruitments}" >
        <div class="card col-md-4 col-xs-12" style="padding: 10px">
            <div class="card-body">
                <a >
                    <c:choose>
                        <c:when test="${r.image != null && p.image.startsWith('https')== true}">
                            <img class="card-img-top img-fluid" src="${r.image}" alt="${r.title}"/>
                        </c:when>
                        <c:when test="${r.image == null || p.image.startsWith('https')== false}">
                            <img class="card-img-top img-fluid" src="<c:url value="/images/logo.png"/>" alt="${r.title}"/>
                        </c:when>
                    </c:choose>
                </a>
                
                
               
            </div>
            <div class="card-footer bg-info">
                <div style="background-color: whitesmoke">
                    <h3>${r.title}</h3>
                    <h3>${r.price}</h3>
                </div>
                <a href="<c:url value="/recruitment/${r.id}"/>">
                    <input type="button" value="Xem chi tiet" class="btn btn-danger"/>
                </a>
            </div>
        </div>
    </c:forEach>
</div>
