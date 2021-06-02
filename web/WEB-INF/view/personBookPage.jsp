<%--
  Created by IntelliJ IDEA.
  User: komarov_s_s
  Date: 02.06.2021
  Time: 01:57
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<html>
<head>
    <title>Person Books</title>
</head>
<body>
<div align="center">
    <div class="w3-center">
        <h3>My books</h3>
    </div>
</div>
<div align="left">
    <h2>My Library</h2>
</div>
<div align="right">
    <div class="w3-card-4 w3-quarter w3-margin-top w3-display-topmiddle">
        <div class=" w3-green">
            <a href="${pageContext.request.contextPath}/view/logout">logout</a>
            <a href="${pageContext.request.contextPath}/view/personPage">Person Page</a>
            <a href="${pageContext.request.contextPath}/view/language/registration?language=RU">RU</a>
            <a href="${pageContext.request.contextPath}/view/language/registration?language=EN">EN</a>
        </div>
    </div>
</div>

<table>
    <tr>
        <th>Название</th>
        <th>Автор</th>
        <th>Жанр</th>
        <th>Издательство</th>
        <th>Год издательства</th>
        <th>Описание</th>
        <th>Цена</th>
        <th>Штраф</th>
        <th>Дедлайн</th>
        <th>Возвратить</th>
    </tr>

    <c:forEach items="#{books}" var="a">
    <tr>
        <td> ${a.name}</td>
        <td> ${a.author}</td>
        <td> ${a.genre}</td>
        <td> ${a.publisher}</td>
        <td> ${a.publisher_date}</td>
        <td> ${a.description}</td>
        <td> ${a.price}</td>
        <td> ${a.debt}</td>
        <td> ${a.returnDate}</td>
        <c:if test="${a.debt == 0}">
        <td><a href="${pageContext.request.contextPath}/view/personBookPage?id=${a.id}&button=return"
               onclick="return confirm('Are you sure you want to return this book?')">Return</a>
        </td>
        </c:if>
        <c:if test="${a.debt > 0}">
        <td><a href="${pageContext.request.contextPath}/view/personBookPage?id=${a.id}&button=pay"
               onclick="return confirm('Are you sure you want to pay this book?')">Pay debt</a>
        </td>
        </c:if>
    </tr>
    </c:forEach>
</table>

</body>
</html>
