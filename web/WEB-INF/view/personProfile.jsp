<%--
  Created by IntelliJ IDEA.
  User: komarov_s_s
  Date: 30.05.2021
  Time: 13:27
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
    <title><fmt:message key="myProfile"/></title>
</head>
<body>
<div align="center">
    <div class="w3-center">
        <h3><fmt:message key="myProfile"/></h3>
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
            <a href="${pageContext.request.contextPath}/view/language/personProfile?language=RU">RU</a>
            <a href="${pageContext.request.contextPath}/view/language/personProfile?language=EN">EN</a>
        </div>
    </div>
</div>

<table>
    <tr>
        <th><fmt:message key="name"/></th>
        <th>Email</th>
        <th><fmt:message key="password"/></th>
        <th><fmt:message key="edit"/></th>
    </tr>

        <tr>
            <td> ${person.name}</td>
            <td> ${person.email}</td>
            <td> ${person.password}</td>
            <td>
                <form class="w3-container" align="left" method="post"
                      action="${pageContext.request.contextPath}/view/personProfile?id=${person.id}&button=set&name=${person.name}&email=${person.email}&password=${person.password}&status=${person.status}"
                      onclick="return confirm('<fmt:message key="editPersonConfirm"/>')">

                    <button type="submit" value="set" name="button"><fmt:message key="edit"/></button>
                </form>
            </td>
        </tr>

</table>

<c:if test="${tab}">
    <form class="w3-container" align="left" method="post"
          action="${pageContext.request.contextPath}/view/personProfile?id=${param.get("id")}&button=update"
          onclick="return confirm(<fmt:message key="updateProfile"/>)">


        <p>
            <label>
                <input class="w3-input" type="text" value="${param.get("name")}"
                       name="name">
            </label>
        </p>

        <p>
            <label>
                <input class="w3-input" type="text" value="${param.get("email")}" name="email">
            </label>
        </p>

        <p>
            <label>
                <input class="w3-input" type="text" value="${param.get("password")}" name="password">
            </label>
        </p>



        <button type="submit" value="update" name="button"><fmt:message key="update"/></button>
    </form>
</c:if>

</body>
</html>
