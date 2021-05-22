<%--
  Created by IntelliJ IDEA.
  User: komarov_s_s
  Date: 21.05.2021
  Time: 13:50
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>PERSON PAGE</title>
</head>
<body>
<div align="center">
    <div class="w3-card-4 w3-quarter w3-margin-top w3-display-topmiddle">
        <div class=" w3-green">
            <div class="w3-center">
                <h3>PERSON PAGE</h3>
            </div>
            <a href="${pageContext.request.contextPath}/login.jsp">logout</a>
            <a href="${pageContext.request.contextPath}/view/language/registration?language=RU">RU</a>
            <a href="${pageContext.request.contextPath}/view/language/registration?language=EN">EN</a>
        </div>
        </div>
        </div>
</body>
</html>
