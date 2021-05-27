<%--
  Created by IntelliJ IDEA.
  User: komarov_s_s
  Date: 24.05.2021
  Time: 23:03
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<html>
<head>
    <title>List books</title>
</head>
<body>
<div align="center">
    <div class="w3-center">
        <h3>List books</h3>
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
        <th>Название</th>
        <th>Автор</th>
        <th>Жанр</th>
        <th>Издательство</th>
        <th>Год издательства</th>
        <th>Описание</th>
        <th>Цена</th>
        <th>Удалить</th>
        <th>Изменить</th>
    </tr>

    <c:forEach items="#{books}" var="a">
        <tr>
            <td> ${a.id}</td>
            <td> ${a.name}</td>
            <td> ${a.author}</td>
            <td> ${a.genre}</td>
            <td> ${a.publisher}</td>
            <td> ${a.publisher_date}</td>
            <td> ${a.description}</td>
            <td> ${a.price}</td>
            <td><a href="${pageContext.request.contextPath}/view/listBook?id=${a.id}&button=delete"
                   onclick="return confirm('Are you sure you want to remove this book?')">delete</a>
            </td>
            <td><a href="${pageContext.request.contextPath}/view/listBook">set</a></td>
        </tr>
    </c:forEach>
</table>
</body>
</html>
