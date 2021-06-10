<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="Tag" uri="/WEB-INF/myTag.tld" %>

<html>
<meta charset="utf-8">

<head>
    <title>Welcome</title>
    <link rel="stylesheet" href="${pageContext.request.contextPath}/styles/style.css" media="screen">
</head>
<body>
<div class="slider-area">
    <div class="slider-bgLogin text-center">
        <div align="left">
            <Tag:dateTag/>
        </div>
        <div class="container">
            <div class="row">
                <div class="slidertext">
                        <h3>Welcome!!!</h3>
                </div>

                <div class="slidertext">
                    <a class="loginBtn res" href="${pageContext.request.contextPath}/view/mainPage">Нажмите меня!</a>
                </div>
            </div>
        </div>
    </div>
</div>
</body>
</html>


