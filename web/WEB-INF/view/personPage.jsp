<%--
  Created by IntelliJ IDEA.
  User: komarov_s_s
  Date: 21.05.2021
  Time: 13:50
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>

<html>
<head>
    <title>PERSON PAGE</title>
</head>
<body>

<div align="center">
<div class="w3-center">
    <h3>PERSON PAGE</h3>
</div>
</div>
<div align="left">
    <h2>My Library</h2>
    <form class="w3-container" align="left" method="post"
          action="${pageContext.request.contextPath}/view/personPage">
        <p>
            <label>
                <input class="w3-input" type="search" required placeholder="Поиск по сайту"
                       name="search">
            </label>
        </p>
        <div>
            <input class="w3-button w3-margin-bottom w3-green" type="submit"
                   value="Найти" name="sear">
        </div>
    </form>

    <div align="center">
        <c:if test="${win}">
        <table>
            <tr>
                <th>Название</th>
                <th>Автор</th>
                <th>Жанр</th>
                <th>Издательство</th>
                <th>Год издательства</th>
                <th>Описание</th>
                <th>Цена</th>

            </tr>

            <c:forEach items="${list}" var="b">
            <tr>
                <td> ${b.name}</td>
                <td> ${b.author}</td>
                <td> ${b.genre}</td>
                <td> ${b.publisher}</td>
                <td> ${b.publisher_date}</td>
                <td> ${b.description}</td>
                <td> ${b.price}</td>
            </tr>
            </c:forEach>
            </c:if>
    </div>
</div>
<div align="right">
    <div class="w3-card-4 w3-quarter w3-margin-top w3-display-topmiddle">
        <div class=" w3-green">
            <a href="${pageContext.request.contextPath}/view/logout">logout</a>
            <a href="${pageContext.request.contextPath}/view/personInfoBookPage">My books</a>
            <a href="${pageContext.request.contextPath}/view/personProfile">My Profile</a>
            <a href="${pageContext.request.contextPath}/view/language/registration?language=RU">RU</a>
            <a href="${pageContext.request.contextPath}/view/language/registration?language=EN">EN</a>
        </div>
        </div>
        </div>

<div align="left">
    <div class="w3-card-4 w3-quarter w3-margin-top w3-display-topmiddle">
        <div class=" w3-green">
            <a href="${pageContext.request.contextPath}/view/personPage?sort=sortName">Name</a>
            <a href="${pageContext.request.contextPath}/view/personPage?sort=sortAuthor">Author</a>
            <a href="${pageContext.request.contextPath}/view/personPage?sort=sortPublisher">Publisher</a>
            <a href="${pageContext.request.contextPath}/view/personPage?sort=sortPublisherDate">Publisher_Date</a>
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
            <th>Заказать</th>

        </tr>

        <c:forEach items="${books}" var="a">
            <tr>
                <td> ${a.name}</td>
                <td> ${a.author}</td>
                <td> ${a.genre}</td>
                <td> ${a.publisher}</td>
                <td> ${a.publisher_date}</td>
                <td> ${a.description}</td>
                <td> ${a.price}</td>
                <td><a href="${pageContext.request.contextPath}/view/personPage?id=${a.id}&button=order"
                       onclick="return confirm('Are you sure you want to order this book?')">Order</a>
                </td>
            </tr>
        </c:forEach>

    </table>

</body>
</html>
