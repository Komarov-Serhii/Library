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
<c:set var="language" value="${not empty sessionScope.language ? sessionScope.language : pageContext.request.locale}"
       scope="session"/>
<fmt:setLocale value="${language}"/>
<fmt:setBundle basename="text"/>
<html>
<head>
    <title><fmt:message key="booksPerson"/></title>
</head>
<body>
<div align="center">
    <div class="w3-center">
        <h3>My books<fmt:message key="myBooks"/></h3>
    </div>
</div>
<div align="left">
    <h2><fmt:message key="myLibrary"/></h2>
</div>
<div align="right">
    <div class="w3-card-4 w3-quarter w3-margin-top w3-display-topmiddle">
        <div class=" w3-green">
            <a href="${pageContext.request.contextPath}/view/logout"><fmt:message key="logout"/></a>
            <a href="${pageContext.request.contextPath}/view/personPage"><fmt:message key="personPage"/></a>
            <a href="${pageContext.request.contextPath}/view/language/personBookPage?language=RU">RU</a>
            <a href="${pageContext.request.contextPath}/view/language/personBookPage?language=EN">EN</a>
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
        <th><fmt:message key="penalty"/></th>
        <th><fmt:message key="deadline"/></th>
        <th><fmt:message key="return"/></th>
    </tr>

    <c:forEach items="#{books}" var="a">
    <tr>
        <td> ${a.name}</td>
        <td> ${a.author}</td>
        <td> ${a.genre}</td>
        <td> ${a.publisher}</td>
        <td> ${a.publisherDate}</td>
        <td> ${a.description}</td>
        <td> ${a.price}</td>
        <td> ${a.debt}</td>
        <td> ${a.returnDate}</td>
        <c:if test="${a.debt == 0}">
        <td><a href="${pageContext.request.contextPath}/view/personBookPage?id=${a.id}&button=return"
               onclick="return confirm('<fmt:message key="returnConfirm"/>')"><fmt:message key="return"/></a>
        </td>
        </c:if>
        <c:if test="${a.debt > 0}">
        <td><a href="${pageContext.request.contextPath}/view/personBookPage?id=${a.id}&button=pay"
               onclick="return confirm('<fmt:message key="payConfirm"/>')"><fmt:message key="payFine"/></a>
        </td>
        </c:if>
    </tr>
    </c:forEach>
</table>

</body>
</html>
