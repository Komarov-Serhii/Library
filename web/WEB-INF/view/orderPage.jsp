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
<html>
<head>
    <title>Contract</title>
</head>
<body>
<div align="center">
    <div class="w3-center">
        <h3>List Orders</h3>
    </div>
</div>
<div align="left">
    <h2>My Library</h2>
</div>
<div align="right">
    <div class="w3-card-4 w3-quarter w3-margin-top w3-display-topmiddle">
        <div class=" w3-green">
            <a href="${pageContext.request.contextPath}/view/logout">logout</a>
            <a href="${pageContext.request.contextPath}/view/adminPage">admin</a>
            <a href="${pageContext.request.contextPath}/view/language/registration?language=RU">RU</a>
            <a href="${pageContext.request.contextPath}/view/language/registration?language=EN">EN</a>
        </div>
    </div>
</div>

<table>
    <tr>
        <th>№</th>
        <th>Name Person</th>
        <th>Email</th>
        <th>№ Book</th>
        <th>Name Book</th>
        <th>Author</th>
        <th>Accept</th>
        <th>Reject</th>
    </tr>
    <c:forEach items="#{order}" var="a">
        <tr>
            <td> ${a.key.id} <br></td>
            <td> ${a.key.name} <br></td>
            <td> ${a.key.email} <br></td>
            <td> ${a.value.id} <br></td>
            <td> ${a.value.name} <br></td>
            <td> ${a.value.author} <br></td>
            <td><a href="${pageContext.request.contextPath}/view/orderPage?id=${a.value.id}&button=accept"
                   onclick="return confirm('Are you sure you want to accept this book?')">accept</a>
            </td>
            <td><a href="${pageContext.request.contextPath}/view/orderPage?id=${a.value.id}&button=reject"
                   onclick="return confirm('Are you sure you want to reject this book?')">reject</a>
            </td>
        </tr>
    </c:forEach>
</table>
</body>
</html>
