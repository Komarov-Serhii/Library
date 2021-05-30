<%--
  Created by IntelliJ IDEA.
  User: komarov_s_s
  Date: 22.05.2021
  Time: 06:14
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<link rel="stylesheet" href="${pageContext.request.contextPath}/styles/nicepage.css" media="screen">
<link rel="stylesheet" href="${pageContext.request.contextPath}/styles/Page-1.css" media="screen">
<html>
<head>
    <title>MAIN PAGE</title>
</head>
<body>
<div>
    <div align="left">
        <h2>My Library</h2>
        <form>
            <p><input type="search" name="q" placeholder="Поиск по сайту">
                <input type="submit" value="Найти"></p>
        </form>
    </div>
    <div align="center">
        <div class="w3-center">
            <h3>MAIN PAGE</h3>
        </div>
    </div>
    <div align="right">
        <div class="w3-card-4 w3-quarter w3-margin-top w3-display-topmiddle">
            <div class=" w3-green">
                <a href="${pageContext.request.contextPath}/view/registration">registration</a>
                <a href="${pageContext.request.contextPath}/view/login">login</a>
                <a href="${pageContext.request.contextPath}/view/language/registration?language=RU">RU</a>
                <a href="${pageContext.request.contextPath}/view/language/registration?language=EN">EN</a>
            </div>
        </div>
    </div>
</div>
</body>
</html>

