<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<c:set var="language" value="${not empty param.language ? param.language : pageContext.request.locale}"
       scope="application"/>

<fmt:setLocale value="${language}"/>
<fmt:setBundle basename="text"/>

<!DOCTYPE html>
<html lang="java">
<meta charset="utf-8">
<head>
    <title>Admin: Main page/></title>

    <link rel="stylesheet" href="${pageContext.request.contextPath}/styles/style.css" media="screen">
</head>

<body>
<div id="home"></div>
<div class="ournet-inter-area">
    <header id="header" class="header-area">
        <div class="logoBlock">
            <div style="font-size: 16px; text-align: end;">
                <a class="btn" href="${pageContext.request.contextPath}/view/language/admin/adminPage?language=RU">RU</a>
                <a class="btn" href="${pageContext.request.contextPath}/view/language/admin/adminPage?language=EN">EN</a>
            </div>
            <p id="pageLogo">ISPAdmin</p>
            <div class="adminmenu">
                <ul>
                    <li><a class="scroll-animite btn"
                           href="${pageContext.request.contextPath}/view/admin/listBook"><fmt:message key="books"/></a>
                    </li>
                    <li><a class="scroll-animite btn"
                           href="${pageContext.request.contextPath}/view/admin/listPerson"><fmt:message key="users"/></a></li>
                    <li><a class="scroll-animite btn"
                           href="${pageContext.request.contextPath}/view/admin/orderPage"><fmt:message key="orders"/></a></li>
                    <li><a class="scroll-animite logOutBtn"
                           href="${pageContext.request.contextPath}/view/logout"><fmt:message key="logout"/></a></li>
                </ul>
            </div>
        </div>

        <div id="time"><span id="datetime"></span></div>
        <script src="${pageContext.request.contextPath}/styles/js/time.js"></script>

    </header>
    <!-- Slider area Start -->
    <div class="slider-area">
        <div class="slider-bg text-center">
            <div class="container">
                <div class="row">
                    <div class="col-lg-12">
                        <div class="slidertext">
                            <h1><fmt:message key="mainPage"/></h1>
                        </div>
                    </div>
                    <div class="userInfo">
                        <h4><fmt:message key="countUser"/>: ${people}</h4>
                        <h4><fmt:message key="countActive"/>: ${active}</h4>
                        <h4><fmt:message key="countBlocked"/> : ${blocked}</h4>
                        <h4><fmt:message key="countOrder"/> : ${order}</h4>
                    </div>
                </div>
            </div>
        </div>
    </div>

</div>
</body>
</html>

