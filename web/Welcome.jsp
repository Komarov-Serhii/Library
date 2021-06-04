<%--
  Created by IntelliJ IDEA.
  User: komarov_s_s
  Date: 31.05.2021
  Time: 17:48
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<html>
<head>
    <title>Welcome</title>
</head>
<body>
<form class="w3-container" align="center" method="post"
      action="${pageContext.request.contextPath}/view/mainPage">
    <div class="w3-container w3-grey w3-opacity w3-right-align w3-padding">
        <div>
            <input class="w3-button w3-margin-bottom w3-green" type="submit"
                   value=Welcome>
        </div>
    </div>
</form>
</body>
</html>
