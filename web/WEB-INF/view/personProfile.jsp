<%--
  Created by IntelliJ IDEA.
  User: komarov_s_s
  Date: 30.05.2021
  Time: 13:27
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>List person</title>
</head>
<body>
<div align="center">
    <div class="w3-center">
        <h3>My Profile</h3>
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
        <th>Имя</th>
        <th>Эмаил</th>
        <th>Пароль</th>
        <th>Изменить</th>
    </tr>

        <tr>
            <td> ${person.name}</td>
            <td> ${person.email}</td>
            <td> ${person.password}</td>
            <td>
                <form class="w3-container" align="left" method="post"
                      action="${pageContext.request.contextPath}/view/personProfile?id=${person.id}&button=set&name=${person.name}&email=${person.email}&password=${person.password}&status=${person.status}"
                      onclick="return confirm('Are you sure you want to setting your profile?')">

                    <button type="submit" value="set" name="button">SET</button>
                </form>
            </td>
        </tr>

</table>

<c:if test="${tab}">
    <form class="w3-container" align="left" method="post"
          action="${pageContext.request.contextPath}/view/personProfile?id=${param.get("id")}&button=update"
          onclick="return confirm('Are you sure you want to update your profile?')">


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



        <button type="submit" value="update" name="button">Update</button>
    </form>
</c:if>

</body>
</html>
