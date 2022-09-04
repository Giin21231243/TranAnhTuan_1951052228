<%-- 
    Document   : cart
    Created on : Sep 3, 2022, 11:51:02 PM
    Author     : dts
--%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<h1 class="text-danger text-center">Don Ung Tuyen</h1>
<c:if test="${cart==null}">
    <h4 class="text-danger">Khong co don nao!!!</h4>
</c:if>
<c:if test="${cart!=null}">
    <table>
        <tr>
            <td>Ma don viec</td>
            <td>Ten viec</td>
            <td>Luong</td>
            <td>So luong</td>
        </tr>
        <c:forEach items="${cart}" var="c">
        <tr id="recruitment${c.recruitmentId}">
            <td>${c.recruitmentId}</td>
            <td>${c.recruitmentName}</td>
            <td>${c.price} VND</td>
            <td>
                <div class="form-group">
                    <input type="number"
                           value="${c.quatity}" class="form-control"/>

                </div>
            </td>
            <td>
                <div class="form-group">
                    <input type="button"
                           value="Xoa" class="btn badge-danger"/>

                </div>
            </td>
        </tr>
        </c:forEach>
    </table>
    <input type="button" value="Nop Don" class="btn btn-danger"/>
</c:if>

