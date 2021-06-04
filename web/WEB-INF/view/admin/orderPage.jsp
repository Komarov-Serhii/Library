<%--
  Created by IntelliJ IDEA.
  User: komarov_s_s
  Date: 01.06.2021
  Time: 01:38
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<c:set var="language" value="${not empty sessionScope.language ? sessionScope.language : pageContext.request.locale}"
       scope="session"/>
<fmt:setLocale value="${language}"/>
<fmt:setBundle basename="text"/>
<html>
<head>
    <title><fmt:message key="order"/></title>
</head>
<body>
<div align="center">
    <div class="w3-center">
        <h3><fmt:message key="listOrders"/></h3>
    </div>
</div>
<div align="left">
    <h2><fmt:message key="myLibrary"/></h2>
</div>
<div align="right">
    <div class="w3-card-4 w3-quarter w3-margin-top w3-display-topmiddle">
        <div class=" w3-green">
            <a href="${pageContext.request.contextPath}/view/logout"><fmt:message key="logout"/></a>
            <a href="${pageContext.request.contextPath}/view/admin/adminPage"><fmt:message key="admin"/></a>
            <a href="${pageContext.request.contextPath}/view/language/admin/orderPage?language=RU">RU</a>
            <a href="${pageContext.request.contextPath}/view/language/admin/orderPage?language=EN">EN</a>
        </div>
    </div>
</div>

<table>
    <tr>
        <th>№</th>
        <th>Name Person<fmt:message key="namePerson"/></th>
        <th>Email</th>
        <th><fmt:message key="idBook"/></th>
        <th>Name Book<fmt:message key="nameBook"/></th>
        <th><fmt:message key="author"/></th>
        <th><fmt:message key="accept"/></th>
        <th><fmt:message key="reject"/></th>
    </tr>
    <c:forEach items="#{order}" var="a">
        <tr>
            <td> ${a.key.id} <br></td>
            <td> ${a.key.name} <br></td>
            <td> ${a.key.email} <br></td>
            <td> ${a.value.id} <br></td>
            <td> ${a.value.name} <br></td>
            <td> ${a.value.author} <br></td>
            <td><a href="${pageContext.request.contextPath}/view/admin/orderPage?id=${a.value.id}&button=accept"
                   onclick="return confirm('<fmt:message key="acceptConfirm"/>')"><fmt:message key="accept"/></a>
            </td>
            <td><a href="${pageContext.request.contextPath}/view/admin/orderPage?id=${a.value.id}&button=reject"
                   onclick="return confirm('<fmt:message key="rejectConfirm"/>')"><fmt:message key="reject"/></a>
            </td>
        </tr>
    </c:forEach>
</table>
</body>
</html>
