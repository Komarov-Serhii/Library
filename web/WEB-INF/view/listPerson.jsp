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
<c:set var="language" value="${not empty sessionScope.language ? sessionScope.language : pageContext.request.locale}"
       scope="session"/>
<fmt:setLocale value="${language}"/>
<fmt:setBundle basename="text"/>
<html>
<head>
    <title><fmt:message key="listPerson"/></title>
</head>
<body>
<div align="center">
    <div class="w3-center">
        <h3><fmt:message key="listPerson"/></h3>
    </div>
</div>
<div align="left">
    <h2><fmt:message key="myLibrary"/></h2>
</div>
<div align="right">
    <div class="w3-card-4 w3-quarter w3-margin-top w3-display-topmiddle">
        <div class=" w3-green">
            <a href="${pageContext.request.contextPath}/view/logout"><fmt:message key="logout"/></a>
            <a href="${pageContext.request.contextPath}/view/adminPage"><fmt:message key="admin"/></a>
            <a href="${pageContext.request.contextPath}/view/language/listPerson?language=RU">RU</a>
            <a href="${pageContext.request.contextPath}/view/language/listPerson?language=EN">EN</a>
        </div>
    </div>
</div>

<div align="left">
  <table>
    <tr>
      <th>№</th>
      <th><fmt:message key="name"/></th>
      <th>Email</th>
      <th><fmt:message key="delete"/></th>
      <th><fmt:message key="status"/></th>
      <th><fmt:message key="check"/></th>
    </tr>

    <c:forEach items="#{people}" var="a">
      <tr>
        <td> ${a.id}</td>
        <td> ${a.name}</td>
        <td> ${a.email}</td>
          <td><a href="${pageContext.request.contextPath}/view/listPerson?id=${a.id}&button=delete"
              onclick="return confirm('Are you sure you want to remove this client?')"><fmt:message key="delete"/></a>
          </td>

          <c:if test="${a.status == 1}">
              <td><a class="block"
                     href="${pageContext.request.contextPath}/view/listPerson?button=block&id=${a.id}"
                     onclick="return confirm('Are you sure you want to block this client?')"><fmt:message key="block"/></a>
              </td>
          </c:if>
          <c:if test="${a.status == 2}">
              <td><a class="unblock"
                     href="${pageContext.request.contextPath}/view/listPerson?button=unblock&id=${a.id}"
                     onclick="return confirm('Are you sure you want to unblock this client?')"><fmt:message key="unblock"/></a>
              </td>
          </c:if>

          <td><a href="${pageContext.request.contextPath}/view/listPerson?id=${a.id}&button=book"><fmt:message key="checkBooks"/></a></td>
      </tr>
    </c:forEach>
  </table>
</div>

<div align="left">
<c:if test="${win}">
<table>
    <tr>
        <th>№</th>
        <th><fmt:message key="name"/></th>
        <th><fmt:message key="author"/></th>
        <th><fmt:message key="genre"/></th>
        <th><fmt:message key="publisher"/></th>
        <th><fmt:message key="publisherDate"/></th>
        <th><fmt:message key="description"/></th>
        <th><fmt:message key="price"/></th>
    </tr>

    <c:forEach items="${books}" var="b">
    <tr>
        <td> ${b.id}</td>
        <td> ${b.name}</td>
        <td> ${b.author}</td>
        <td> ${b.genre}</td>
        <td> ${b.publisher}</td>
        <td> ${b.publisher_date}</td>
        <td> ${b.description}</td>
        <td> ${b.price}</td>
    </tr>
    </c:forEach>
</table>
</c:if>
</div>





<form class="w3-container" align="center" method="post"
      action="${pageContext.request.contextPath}/view/listPerson">

    <button type="submit" value="add" name="button"><fmt:message key="addAdmin"/></button>
</form>
<c:if test="${window}">
    <form class="w3-container" align="center" method="post"
          action="${pageContext.request.contextPath}/view/listPerson">

        <p>
            <label>
                <input class="w3-input" type="text" required placeholder="<fmt:message key="name"/>"
                       name="name">
            </label>
        </p>

        <p>
            <label>
                <input class="w3-input" type="text" required placeholder="Email" name="email">
            </label>
        </p>

        <p>
            <label>
                <input class="w3-input" type="password" required
                       placeholder="<fmt:message key="password"/>"
                       name="password">
            </label>
        </p>


        <input class="w3-button w3-green" type="submit" value="<fmt:message key="add"/>" name="button">
    </form>
</c:if>



</body>
</html>
