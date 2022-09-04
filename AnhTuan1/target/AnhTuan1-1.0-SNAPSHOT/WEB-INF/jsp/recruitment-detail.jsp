<%-- 
    Document   : recruitment
    Created on : Aug 16, 2022, 10:06:45 PM
    Author     : dts
--%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<link href="<c:url value="/css/style.css" />" rel="stylesheet"/> 

<h1 class="text-center text-danger">Chi Tiec San Pham</h1>


<div class="row" style="background-color: whitesmoke">
    <div class="col-md-6">
        <div class="card-body">
            <c:choose>
                <c:when test="${recruitment.image != null && recruitment.image.startsWith('https')== true}">
                    <img class="card-img-top img-fluid" src="${recruitment.image}" alt="${recruitment.title}"/>
                </c:when>
                <c:when test="${recruitment.image == null || recruitment.image.startsWith('https')== false}">
                    <img class="card-img-top img-fluid" src="<c:url value="/images/logo.png"/>" alt="${recruitment.title}"/>
                </c:when>
            </c:choose>   
        </div>
    </div>
    <div class="col-md-6">
        <h1>${recruitment.title}</h1>
        <p>${recruitment.content}</p>
        <h3 class="text-danger">${recruitment.price}</h3>
        <p class="text-danger">${recruitment.education}</p>
        <div>
            <a href="/cart" class="btn btn-primary" onclick="addToCart(${recruitment.id}, '${recruitment.title}', ${recruitment.price},)">Nop Don</a>
        </div>
    </div>

</div>
<br><br/>
<form>
    <div class="form-group">
        <label class="text-danger" for="comment" >Comments:</label>
        <textarea class="form-control" placeholder="Nhap noi dung binh luan" id="contentId"></textarea>

        <button class="btn btn-danger" onclick="addComment('${endpoint}', ${recruitment.id})">Them binh luan</button>
    </div>
</form>  
<br><br/>

<div class="comment">
    <c:forEach items="${comment}" var="c">
        <div class="comtent row"> 
            <div class="col-md-2">
                <img src="<c:url value="/images/logo.png"/>" class="rounded-circle img-fluid"/>
            </div>
            <div class="col-md-10">
                <p>
                    ${c.content}
                </p>
                <p class="commentDate">
                    ${c.createdDate}
                </p>
            </div>
        </div>
    </c:forEach>
</div>


<script src="<c:url value="/js/comment.js" />"></script>

<script>
    <c:url value="/api/recruitment/${recruitment.id}/comment/" var="endpoint" />
            window.onload = function () {
                loadComments('${endpoint}');
            }
</script> 

<ul id="comments" class="list-group"">

</ul>
