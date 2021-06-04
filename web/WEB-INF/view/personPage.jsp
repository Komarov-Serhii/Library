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

<c:set var="language" value="${not empty sessionScope.language ? sessionScope.language : pageContext.request.locale}"
       scope="session"/>
<fmt:setLocale value="${language}"/>
<fmt:setBundle basename="text"/>

<html>
<head>
    <title><fmt:message key="personPage"/></title>
</head>
<body>

<div align="center">
<div class="w3-center">
    <h3><fmt:message key="personPage"/></h3>
</div>
</div>
<div align="left">
    <h2><fmt:message key="myLibrary"/></h2>
    <form class="w3-container" align="left" method="post"
          action="${pageContext.request.contextPath}/view/personPage">
        <p>
            <label>
                <input class="w3-input" type="search" required placeholder="<fmt:message key="searchSite"/>"
                       name="search">
            </label>
        </p>
        <div>
            <input class="w3-button w3-margin-bottom w3-green" type="submit"
                   value="<fmt:message key="search"/>" name="sear">
        </div>
        <c:if test="${requestScope.notFoundSearch}">
            <div class="w3-container">
                <p><fmt:message key="notFoundSearch"/></p>
            </div>
        </c:if>
    </form>

    <div align="center">
        <c:if test="${win}">
        <table>
            <tr>
                <th><fmt:message key="name"/></th>
                <th><fmt:message key="author"/></th>
                <th><fmt:message key="genre"/></th>
                <th><fmt:message key="publisher"/></th>
                <th><fmt:message key="publisherDate"/></th>
                <th><fmt:message key="description"/></th>
                <th><fmt:message key="price"/></th>

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
            <a href="${pageContext.request.contextPath}/view/logout"><fmt:message key="logout"/></a>
            <a href="${pageContext.request.contextPath}/view/personInfoBookPage"><fmt:message key="myBooks"/></a>
            <a href="${pageContext.request.contextPath}/view/personProfile"><fmt:message key="myProfile"/></a>
            <a href="${pageContext.request.contextPath}/view/language/personPage?language=RU">RU</a>
            <a href="${pageContext.request.contextPath}/view/language/personPage?language=EN">EN</a>
        </div>
        </div>
        </div>

<div align="left">
    <div class="w3-card-4 w3-quarter w3-margin-top w3-display-topmiddle">
        <div class=" w3-green">
            <a href="${pageContext.request.contextPath}/view/mainPage?sort=sortName"><fmt:message key="name"/></a>
            <a href="${pageContext.request.contextPath}/view/mainPage?sort=sortAuthor"><fmt:message key="author"/></a>
            <a href="${pageContext.request.contextPath}/view/mainPage?sort=sortPublisher"><fmt:message key="publisher"/></a>
            <a href="${pageContext.request.contextPath}/view/mainPage?sort=sortPublisherDate"><fmt:message key="publisherDate"/></a>
        </div>
    </div>
</div>


    <table>
        <tr>
            <th><fmt:message key="name"/></th>
            <th><fmt:message key="author"/></th>
            <th><fmt:message key="genre"/></th>
            <th><fmt:message key="publisher"/></th>
            <th><fmt:message key="publisherDate"/></th>
            <th><fmt:message key="description"/></th>
            <th><fmt:message key="price"/></th>
            <th><fmt:message key="order"/></th>

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
                       onclick="return confirm('Are you sure you want to order this book?')"><fmt:message key="order"/></a>
                </td>
            </tr>
        </c:forEach>

    </table>

</body>
</html>
