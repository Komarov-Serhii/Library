<%--
  Created by IntelliJ IDEA.
  User: komarov_s_s
  Date: 19.05.2021
  Time: 16:11
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<link rel="stylesheet" href="${pageContext.request.contextPath}/styles/nicepage.css" media="screen">
<link rel="stylesheet" href="${pageContext.request.contextPath}/styles/Page-1.css" media="screen">
<html>
<head>
  <title>REGISTRATION</title>
</head>
<body>
<div align="center">
  <div class="w3-card-4 w3-quarter w3-margin-top w3-display-topmiddle">
    <div class=" w3-green">
      <div class="w3-center">
        <h3>REGISTRATION</h3>
      </div>
      <a href="${pageContext.request.contextPath}/view/login">login</a>
      <a href="${pageContext.request.contextPath}/view/mainPage">mainPage</a>
      <a href="${pageContext.request.contextPath}/view/language/registration?language=RU">RU</a>
      <a href="${pageContext.request.contextPath}/view/language/registration?language=EN">EN</a>
    </div>

    <form class="w3-container" align="center" method="post"
          action="${pageContext.request.contextPath}/view/registration">

      <p>
        <label>
          <input class="w3-input" type="text" required placeholder="name"
                 name="firstName">
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
                 placeholder="password"
                 name="password">
        </label>
      </p>


      <input class="w3-button w3-green" type="submit" value="registration">
    </form>
  </div>
</div>
</body>
</html>
