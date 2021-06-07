<%--
  Created by IntelliJ IDEA.
  User: komarov_s_s
  Date: 22.05.2021
  Time: 06:14
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<link rel="stylesheet" href="${pageContext.request.contextPath}/styles/nicepage.css" media="screen">
<link rel="stylesheet" href="${pageContext.request.contextPath}/styles/Page-1.css" media="screen">

<c:set var="language" value="${not empty sessionScope.language ? sessionScope.language : pageContext.request.locale}"
       scope="session"/>
<fmt:setLocale value="${language}"/>
<fmt:setBundle basename="text"/>

<html>
<head>
    <title><fmt:message key="mainPage"/></title>
</head>
<body>
<div>
    <div align="left">
        <h2>My Library</h2>
        <form class="w3-container" align="left" method="post"
              action="${pageContext.request.contextPath}/view/mainPage">
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
    </div>
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
                <td> ${b.publisherDate}</td>
                <td> ${b.description}</td>
                <td> ${b.price}</td>
            </tr>
            </c:forEach>
            </c:if>
    </div>

    <div align="center">
        <div class="w3-center">
            <h3><fmt:message key="mainPage"/></h3>
        </div>
    </div>
    <div align="right">
        <div class="w3-card-4 w3-quarter w3-margin-top w3-display-topmiddle">
            <div class=" w3-green">
                <a href="${pageContext.request.contextPath}/view/registration"><fmt:message key="registration"/></a>
                <a href="${pageContext.request.contextPath}/view/login"><fmt:message key="login"/></a>
                <a href="${pageContext.request.contextPath}/view/language/mainPage?language=RU">
                    <%--<img src="image/ru.png"/>--%>
                    RU
                </a>
                <a href="${pageContext.request.contextPath}/view/language/mainPage?language=EN">
                    <%--<img src="${pageContext.request.contextPath}image/en.png"/>--%>
                    EN
                </a>
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
    <div align="left">
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

            <c:forEach items="${books}" var="a">
            <tr>
                <td> ${a.name}</td>
                <td> ${a.author}</td>
                <td> ${a.genre}</td>
                <td> ${a.publisher}</td>
                <td> ${a.publisherDate}</td>
                <td> ${a.description}</td>
                <td> ${a.price}</td>
            </tr>
            </c:forEach>
    </div>

    </table>
</div>
</body>
</html>