<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<nav class="navbar navbar-expand-sm navbar-dark bg-dark">
    <div class="container-fluid">
        <a class="navbar-brand" href="/AnhTuan1">
            <img src="<c:url value="/images/logo.png"/>" width="30" height="30" alt="test"/>
        </a>
        <button class="navbar-toggler" type="button" data-bs-toggle="collapse" data-bs-target="#mynavbar">
            <span class="navbar-toggler-icon"></span>
        </button>

        <div class="collapse navbar-collapse" id="mynavbar">
            <c:forEach var="cat" items="${category}">
                <ul class="navbar-nav nav-item me-auto">
                    <li class="nav-item">
                        <c:url value="/" var="catPath">
                            <c:param name="CateId" value="${cat.id}"></c:param>
                        </c:url>
                        <a class="nav-link" href="${catPath}"/>${cat.name}</a>
                    </li>
                </ul> 
            </c:forEach>
            <c:if test="${pageContext.request.userPrincipal.name == null}">
                <li class="nav-item">
                    <a href="<c:url value="/login"/>"class="nav-link " style="margin-top: -25px">
                        <i style="color: white" class="fa-solid fa-user"></i>Đăng nhập
                    </a>
                </li>
                <li class="nav-item">
                    <a href="<c:url value="/register"/>"class="nav-link " style="margin-top: -25px">
                        <i class="fa-user"></i>Đăng ký
                    </a>
                </li>
            </c:if>
            <c:if test="${pageContext.request.userPrincipal.name != null}">
                <li class="nav-item">
                    <a href="<c:url value="/"/>"class="nav-link " style="margin-top: -25px">
                        <i ></i>${pageContext.request.userPrincipal.name}
                    </a>
                </li>
                <li class="nav-item">
                    <a href="<c:url value="/logout"/>"class="nav-link text-danger" style="margin-top: -25px">
                        <i ></i>Đăng xuất
                    </a>
                </li>
                <li class="nav-item">
                    <a href="<c:url value="/cart" />" style="color: white">
                        <i class="fa-solid fa-cart-plus">Gio</i>
                        <div class="badge badge-danger" id="cartCounter">0</div>
                    </a>
                </li>
            </c:if>
                


            <form class="d-flex" action="index.jsp">
                <input class="form-control me-2" type="text" name="kw" placeholder="Search">
                <button class="btn btn-primary" type="submit">Search</button>
            </form>
        </div>

    </div>
</nav>