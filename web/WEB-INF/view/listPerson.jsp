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
    <title>List person</title>
</head>
<body>
<div align="center">
    <div class="w3-center">
        <h3>List person</h3>
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
      <th>Имя</th>
      <th>Эмаил</th>
      <th>Удалить</th>
      <th>Статус</th>
    </tr>

    <c:forEach items="#{people}" var="a">
      <tr>
        <td> ${a.id}</td>
        <td> ${a.name}</td>
        <td> ${a.email}</td>
          <td><a href="${pageContext.request.contextPath}/view/listPerson?id=${a.id}&button=delete"
              onclick="return confirm('Are you sure you want to remove this client?')">delete</a>
          </td>

          <c:if test="${a.status == 1}">
              <td><a class="deleteButton"
                     href="${pageContext.request.contextPath}/view/listPerson?button=block&id=${a.id}"
                     onclick="return confirm('Are you sure you want to block this client?')">block</a>
              </td>
          </c:if>
          <c:if test="${a.status == 2}">
              <td><a class="deleteButton"
                     href="${pageContext.request.contextPath}/view/listPerson?button=unblock&id=${a.id}"
                     onclick="return confirm('Are you sure you want to unblock this client?')">unblock</a>
              </td>
          </c:if>
      </tr>
    </c:forEach>
  </table>





</body>
</html>
