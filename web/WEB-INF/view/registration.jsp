<%--
  Created by IntelliJ IDEA.
  User: komarov_s_s
  Date: 19.05.2021
  Time: 16:11
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
  <title><fmt:message key="registration"/></title>
  <link rel="stylesheet" href="https://www.w3schools.com/w3css/4/w3.css">
</head>
<body>
<div align="center">
  <div class="w3-card-4 w3-quarter w3-margin-top w3-display-topmiddle">
    <div class=" w3-green">
      <div class="w3-center">
        <h3><fmt:message key="registration"/></h3>
      </div>
      <a href="${pageContext.request.contextPath}/view/language/registration?language=RU">RU</a>
      <a href="${pageContext.request.contextPath}/view/language/registration?language=EN">EN</a>
    </div>

    <form class="w3-container" align="center" method="post"
          action="${pageContext.request.contextPath}/view/registration">

      <p>
        <label>
          <input class="w3-input" type="text" required placeholder="<fmt:message key="name"/>"
                 name="firstName">
        </label>
      </p>

      <p>
        <label>
          <input class="w3-input" type="text" required placeholder="<fmt:message key="surName"/>"
                 name="secondName">
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


      <input class="w3-button w3-green" type="submit" value="<fmt:message key="registration"/>">
      <c:if test="${requestScope.wrongData}">
        <div class="w3-container">
          <fmt:message key="incorrectEmailOrPass"/>
        </div>
      </c:if>
    </form>
  </div>
</div>
</body>
</html>
