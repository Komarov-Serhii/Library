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
    <title><fmt:message key="login"/></title>
</head>
<body>

<div align="center">
    <div class="w3-card-4 w3-quarter w3-margin-top w3-display-topmiddle">

        <div class=" w3-green">
            <div align="center">
                <h3><fmt:message key="login"/></h3>
            </div>
            <a href="${pageContext.request.contextPath}/view/registration"><fmt:message key="registration"/></a>
            <a href="${pageContext.request.contextPath}/view/mainPage"><fmt:message key="mainPage"/></a>
            <a href="${pageContext.request.contextPath}/view/language/login?language=RU">
                <%--<img src="image/ru.png"/>--%>
                RU
            </a>
            <a href="${pageContext.request.contextPath}/view/language/login?language=EN">
                <%--<img src="${pageContext.request.contextPath}image/en.png"/>--%>
                EN
            </a>
        </div>

        <form class="w3-container" align="center" method="post"
              action="${pageContext.request.contextPath}/view/login">
            <p>
                <label>
                    <input class="w3-input" type="text" required placeholder="<fmt:message key="login"/>"
                           name="login">
                </label>
            </p>

            <p>
                <label>
                    <input class="w3-input" type="password" required placeholder="<fmt:message key="password"/>"
                           name="password">
                </label>
            </p>

            <div>
                <input class="w3-button w3-margin-bottom w3-green" type="submit"
                       value=<fmt:message key="logout"/>>
            </div>

            <c:if test="${requestScope.notFound}">
                <div class="w3-container">
                    <p><fmt:message key="invalidData"/></p>
                </div>
            </c:if>

            <c:if test="${requestScope.wrongData}">
                <div class="w3-container">
                    <fmt:message key="incorrectData"/>
                </div>
            </c:if>


            <div>
                <div id="center">
                    <c:if test="${requestScope.errorMessage}" >
                <p><fmt:message key="infoBan"/></p>
                <p><fmt:message key="moreInfoBan"/></p>
                <a href="#">+380661345678</a>
                    </c:if>
                </div>
            </div>
        </form>
    </div>
</div>
</body>
</html>