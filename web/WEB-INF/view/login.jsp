<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<html>
<head>
    <title>LOGIN</title>
</head>
<body>

<div align="center">
    <div class="w3-card-4 w3-quarter w3-margin-top w3-display-topmiddle">

        <div class=" w3-green">
            <div align="center">
                <h3>LOGIN</h3>
            </div>
            <a href="${pageContext.request.contextPath}/view/registration">registration</a>
            <a href="${pageContext.request.contextPath}/mainPage.jsp">mainPage</a>
            <a href="${pageContext.request.contextPath}/view/language//?language=RU">
                <%--<img src="image/ru.png"/>--%>
                RU
            </a>
            <a href="${pageContext.request.contextPath}/view/language//?language=EN">
                <%--<img src="${pageContext.request.contextPath}image/en.png"/>--%>
                EN
            </a>
        </div>

        <form class="w3-container" align="center" method="post"
              action="${pageContext.request.contextPath}/view/login">
            <p>
                <label>
                    <input class="w3-input" type="text" required placeholder="login"
                           name="login">
                </label>
            </p>

            <p>
                <label>
                    <input class="w3-input" type="password" required placeholder="password"
                           name="password">
                </label>
            </p>

            <div>
                <input class="w3-button w3-margin-bottom w3-green" type="submit"
                       value=enter>
            </div>
        </form>
    </div>
</div>
</body>
</html>