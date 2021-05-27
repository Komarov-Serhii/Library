<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<html>
    <head>
        <title>404</title>
    </head>
    <body>
        <h2>pageNotFound</h2>
        <form class="w3-container" align="center" method="post"
              action="${pageContext.request.contextPath}/view/logout">
        <div class="w3-container w3-grey w3-opacity w3-right-align w3-padding">
            <div>
                <input class="w3-button w3-margin-bottom w3-green" type="submit"
                       value=enter>
            </div>
        </div>
        </form>
    </body>
</html>
